package com.jonas.util;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * 【 反射工具类 】
 *
 * @author shenjy 2018/08/25
 */
@Data
public class ReflectUtils {

    /**
     * 通过属性名获取属性值
     * @param object
     * @param fieldName
     * @return
     */
    public static Object getFiledValue(Object object, String fieldName) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(fieldName)) {
                    field.setAccessible(true);
                    return field.get(object);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 反射设置属性名
     * @param object
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public static Object setFieldValue(Object object, String fieldName, Object fieldValue) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(fieldName)) {
                    field.setAccessible(true);
                    field.set(object, fieldValue);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return object;
    }
}
