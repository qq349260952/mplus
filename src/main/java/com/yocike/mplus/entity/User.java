package com.yocike.mplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

@Data
public class User{
//    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)

    private Date updateTime;
    @Version
    private Integer version;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.yocike.mplus.entity.Book");
        Object o = aClass.newInstance();
//        Field[] declaredFields = aClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField.getName());
//        }
//        Method[] methods = aClass.getMethods();
//        Method setName = aClass.getMethod("setName",String.class);
//        Parameter[] parameters = setName.getParameters();
//        Method method = aClass.getDeclaredMethod("");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Annotation[] annotations = declaredField.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
//        for (Parameter parameter : parameters) {
//            System.out.println(parameter);
//        }
//        for (Method method : methods) {
//            setName.setAccessible(true);
//            setName.invoke(o,"yocike");
//        Method getName = aClass.getMethod("getName");
//        System.out.println(getName.invoke(o));
//            method.invoke(o);
//            System.out.println(method.getName());
//        }
    }
}
