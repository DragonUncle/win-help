package top.dragon.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import top.dragon.entity.ConfigParamEntity;
import top.dragon.entity.RedisConfig;
import top.dragon.entity.SweetConfig;
import top.dragon.service.SystemConfig;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@Configuration
public class RedisConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);
    @Resource
    private SystemConfig systemConfig;

    public RedisConfig initialRedisConfig()  {
        List<SweetConfig> systemConfigConfig = systemConfig.getConfig(
                ConfigParamEntity.listInfo("AliSmsChinaCode",
                        Arrays.asList("regionId", "accessKeyId", "secret", "domain",
                                "templateName", "template", "timeOut")));
        logger.info("获取redis配置信息:{}", systemConfigConfig);
        return RedisConfig.getConfig(systemConfigConfig);
    }
    /**
     * 配置redis
     * @return JedisConnectionFactory配置信息
     */

    /**
     * 配置redisTemplate
     //    * @param lettuceConnectionFactory lettuceConnection工厂
     * @return 配置成功返回可以使用RedisTemplate<String, Object> 类型
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        // 设置序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
                Object.class);
        ObjectMapper om = new ObjectMapper();
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.registerModule(new JavaTimeModule());
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //配置redis
        RedisConfig redisConfig = initialRedisConfig();
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(Integer.parseInt(redisConfig.getRedisDatabase()));
        redisStandaloneConfiguration.setPort(Integer.parseInt(redisConfig.getRedisPort()));
        redisStandaloneConfiguration.setPassword(redisConfig.getRedisPassword() == null?"":redisConfig.getRedisPassword());
        redisStandaloneConfiguration.setHostName(redisStandaloneConfiguration.getHostName());
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        lettuceConnectionFactory.afterPropertiesSet();
        //配置连接池
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        RedisSerializer<?> stringSerializer = new StringRedisSerializer();
        // key序列化
        redisTemplate.setKeySerializer(stringSerializer);
        // value序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // Hash key序列化
        redisTemplate.setHashKeySerializer(stringSerializer);
        // Hash value序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();
        logger.info("redis初始化信息:{}", redisTemplate);
        return redisTemplate;
    }
}
