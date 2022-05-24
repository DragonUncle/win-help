package top.dragon.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : DragonUtils
 * @Description : redis封装工具实现类
 * @Author : DragonUncle
 * @Date :  9:45 2020/4/30
 */
@Component
public class RedisUtil  {

    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);


    public static final String systemUpload = "system-upload";

    public static final String systemUploadPath = "system-upload-path";
    @Resource
    private  RedisTemplate<String,Object> redisTemplate;
    /**
     * 读取信息
     * @param key 查询的key
     * @return 返回获取的数据  如果没有返回null
     */
    public synchronized Object read(String key){
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error("RedisUtil read Exception: Message:{}",e.getMessage());
            return null;
        }
    }
    /**
     * 读取信息
     * @param key 查询的key
     * @return 返回获取的数据
     */
    public synchronized <T> T read(String key,Class<T> clazz){
        try {
            Object value = redisTemplate.opsForValue().get(key);
            if (value == null) return null;
            if (clazz.isInstance(value)) return clazz.cast(value);
        } catch (Exception e) {
            logger.error("RedisUtil read Exception: Message:{}",e.getMessage());
        }
        return null;
    }

    /**
     * 获取过期时间
     * @param key 查询的key
     * @return 返回时长 单位为秒
     */
    public synchronized Long  getTime(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 获取过期时间
     * @param key 查询的key
     * @param timeUnit 时间单位
     * @return 返回时长
     */
    public synchronized Long getTime(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key,timeUnit);
    }
    /**
     * 写入数据 不限时间
     * @param key 定义的key
     * @param value 写入的值
     */
    public synchronized void write(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 写入
     * @param key 定义的key
     * @param value 写入的值
     * @param time 有效时间 秒为单位
     */
    public synchronized void write(String key, Object value, Long time) {
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,time,TimeUnit.SECONDS);
    }

    /**
     * 写入
     * @param key 定义的key
     * @param value 写入的值
     * @param time 有效时间
     * @param timeUnit 时间类型
     */
    public synchronized void write(String key, Object value, Long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,time,timeUnit);
    }

    /**
     * 是否存在
     * @param key 查询的key
     * @return 状态
     */
    public synchronized Boolean isExists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除
     * @param key 删除的key
     * @return 状态
     */
    public synchronized Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

}
