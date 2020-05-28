package com.soulballad.usage.springboot.http.messsage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.stream.Stream;

import org.springframework.cglib.core.ReflectUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ReflectionUtils;

import com.soulballad.usage.springboot.model.UserModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : converter 自定义消息解析器，解析 “text/properties” 格式消息
 * @since ：2020/5/28 19:33
 */
public class PropertiesHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public PropertiesHttpMessageConverter() {
        super(MediaType.valueOf("text/properties"));
        setDefaultCharset(StandardCharsets.UTF_8);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(UserModel.class);
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
        throws IOException, HttpMessageNotReadableException {

        Properties props = new Properties();
        props.load(new InputStreamReader(inputMessage.getBody(), getDefaultCharset()));

        // 要求对象必须有无参构造函数
        Object instance = ReflectUtils.newInstance(UserModel.class);
        Field[] fields = clazz.getDeclaredFields();

        Stream.of(fields).filter(field -> props.containsKey(field.getName())).forEach(field -> {
            String property = props.getProperty(field.getName());
            Class<?> fieldType = field.getType();
            field.setAccessible(true);
            ReflectionUtils.setField(field, instance, resolveFieldValue(property, fieldType));
        });

        return instance;
    }

    @Override
    protected void writeInternal(Object user, HttpOutputMessage outputMessage)
        throws IOException, HttpMessageNotReadableException {

        Properties props = new Properties();
        Field[] fields = user.getClass().getDeclaredFields();

        Stream.of(fields).forEach(field -> {
            String fieldName = field.getName();
            field.setAccessible(true);
            Object fieldValue = ReflectionUtils.getField(field, user);
            props.put(fieldName, String.valueOf(fieldValue));
        });

        props.store(new OutputStreamWriter(outputMessage.getBody(), getDefaultCharset()),
            "written by properties message converter");
    }

    private Object resolveFieldValue(String property, Class<?> fieldType) {

        if (Integer.class == fieldType) {
            return Integer.valueOf(property);
        } else if (Long.class == fieldType) {
            return Long.valueOf(property);
        } else if (Short.class == fieldType) {
            return Short.valueOf(property);
        } else if (Byte.class == fieldType) {
            return Byte.valueOf(property);
        } else if (String.class == fieldType) {
            return property;
        } else if (Float.class == fieldType) {
            return Float.valueOf(property);
        } else if (Double.class == fieldType) {
            return Double.valueOf(property);
        } else if (BigDecimal.class == fieldType) {
            return new BigDecimal(property);
        } else if (Date.class == fieldType) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return sdf.parse(property);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        return property;
    }
}
