package top.dragon.utils;


import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import top.dragon.configuration.DragonException;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName : DragonJwt
 * @Description :
 * @Author : DragonUncle
 * @Date :  16:56 2020/5/11
 */
@Component
public  class JwtUtils {

    //private final String jwtKey = UUID.randomUUID().toString();
    private final static String jwtKey = "ab034779-d0a6-4924-af09-8ba63a1b697d";
    public String createJwtToken(Long validity, Map<String, Object> message) {
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        //生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。
        // 它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        //下面就是在为payload添加各种标准声明和私有声明了
        //这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(message)
                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, jwtKey);
        if (validity >= 0) {
            long expMillis = nowMillis + validity;
            Date exp = new Date(expMillis);
            //设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
    public String createJwtToken(Long validity, Long Id) {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("userId",Id);
        return createJwtToken(validity,parameterMap);
    }
    public Claims parseJWTToken(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new DragonException(514,"Token已过期",e);
        } catch (UnsupportedJwtException e) {
            throw new DragonException(508,"Token不支持",e);
        } catch (MalformedJwtException e) {
            throw new DragonException(508,"Token有缺陷",e);
        } catch (SignatureException e) {
            throw new DragonException(508,"Token签名异常",e);
        } catch (IllegalArgumentException e) {
            throw new DragonException(508,"Token被篡改",e);
        }
    }
}
