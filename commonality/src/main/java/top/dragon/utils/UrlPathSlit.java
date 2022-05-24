package top.dragon.utils;



import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlPathSlit {

    /**
     * 存放匹配的urlPath分组
     */
    private static final List<List<String>> pathList = new ArrayList<>();

    /**
     * 添加匹配路径
     * @param path 匹配的路径
     * @return this
     */
    public UrlPathSlit addMapping(String path) {
        List<String> urlPath = this.setPathList(path);
        pathList.add(urlPath);
        return this;
    }
    /**
     * 添加匹配路径
     * @param path 匹配的路径
     * @return 分组
     */
    private List<String> setPathList(String path) {
        List<String> urlPath = new ArrayList<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (StringUtils.isNotBlank(s))
                urlPath.add(s);
        }
        return urlPath;
    }

    /**
     * 匹配urlPath
     * @param url 匹配的path
     * @return 对比结果 true相同 false不匹配
     */
    public Boolean vTo(String url) {
        return vTo(url,false);
    }

    /**
     * 匹配urlPath
     * @param url 匹配的path
     * @param involveMe 是否包含自己
     * @return 对比结果 true相同 false不匹配
     */
    public Boolean vTo(String url,boolean involveMe) {
        List<String> urlList = setPathList(url);
        boolean flag = false;
        for (List<String> list : pathList) {
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("**"))
                    return true;
                if (!list.get(i).equals(urlList.get(index++))) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                    if (list.size() == urlList.size()) {
                        if (index >= urlList.size()) {
                            return true;
                        }
                    }else if(list.size() > urlList.size()){
                        if (involveMe){
                            //包括自己
                            if (index >= urlList.size() && list.get(i+1).equals("**")) {
                                return true;
                            }else{
                                flag = false;
                                break;
                            }
                        }else{
                            //不包括自己
                            if (index >= urlList.size()){
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }


}
