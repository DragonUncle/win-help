package top.dragon.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import top.dragon.configuration.DragonException;
import top.dragon.configuration.ResultException;
import top.dragon.utils.JwtUtils;
import top.dragon.utils.UrlPathSlit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class ApiGlobalFilter extends ZuulFilter {

    private final UrlPathSlit pathSlit;

    @Resource
    private JwtUtils jwtUtils;


    public ApiGlobalFilter(UrlPathSlit pathSlit){
        this.pathSlit = pathSlit;
        this.pathSlit.addMapping("/consumer/user/login")
                .addMapping("/consumer/user/register")
                .addMapping("/consumer/user/resetPassword")
                .addMapping("/consumer/user/forgetPassword")
                .addMapping("/consumer/user/sendCode")
                .addMapping("/consumer/user/uploadToken")
                .addMapping("/swagger-ui.html");
    }
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        System.out.println("ZuulFilter.shouldFilter"+"=======>"+request.getRequestURI());
        String requestURI = request.getRequestURI();
        if (requestURI.contains("v2/api-docs"))return false;
        return !pathSlit.vTo(requestURI);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String headerToken = request.getHeader("Authorization");
        if(StringUtils.isBlank(headerToken)){
            filterException(new ResultException(512,"无验证信息"));
            return null;
        }
        try {
            Claims claims = jwtUtils.parseJWTToken(headerToken);
            Long userId = claims.get("userId",Long.class);
            context.addZuulRequestHeader("userId",userId.toString());
        }catch (DragonException e){
            filterException(new ResultException(e.getCode(),e.getMessage()));
        }catch (Exception e){
            filterException(new ResultException(500,"验证失败"));
        }
        return null;
    }
    private void filterException(ResultException resultException){
        RequestContext context = RequestContext.getCurrentContext();
        context.setSendZuulResponse(false);
        //throw new SweetException(512,"无验证数据");
        //走到这里中止返回给网页
        context.setSendZuulResponse(false);
        //设置错误代码
        context.setResponseStatusCode(200);
        //设置返回的内容
        context.setResponseBody(resultException.toJson());
        //设置返回的类型
        context.getResponse().setContentType("application/json;charset=UTF-8");
    }


}
