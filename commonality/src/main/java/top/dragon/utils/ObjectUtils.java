package top.dragon.utils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectUtils {
    public static void extracted(Map<String, String> result, Object redisConfig, Class<?> aClass) throws IllegalAccessException {
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            declaredField.setAccessible(true);
            if (result.get(name) != null &&
                    StringUtils.isNotBlank(result.get(name)))
                declaredField.set(redisConfig, result.get(name));
        }
    }
}
