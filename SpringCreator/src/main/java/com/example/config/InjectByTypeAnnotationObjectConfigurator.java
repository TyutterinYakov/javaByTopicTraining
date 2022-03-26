package com.example.config;

import com.example.ApplicationContext;
import com.example.annotation.InjectByType;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator{
    @Override
    @SneakyThrows
    public void configure(Object obj, ApplicationContext context) {
        for (Field declaredField : obj.getClass().getDeclaredFields()) {
            if(declaredField.isAnnotationPresent(InjectByType.class)){
                declaredField.setAccessible(true);
                Object object = context.getObject(declaredField.getType());
                declaredField.set(obj, object);
            }
        }
    }
}
