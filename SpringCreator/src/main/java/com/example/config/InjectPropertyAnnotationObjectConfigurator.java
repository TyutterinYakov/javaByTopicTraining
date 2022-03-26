package com.example.config;

import com.example.ApplicationContext;
import com.example.annotation.InjectProperty;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    private final Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        this.propertiesMap = new BufferedReader(
                new FileReader(path))
                .lines()
                .map(line -> line.split("="))
                .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
    }

    @Override
    @SneakyThrows
    public void configure(Object obj, ApplicationContext context) {
        Class<?> implClass = obj.getClass();
        for (Field declaredField : implClass.getDeclaredFields()) {
            InjectProperty annotation = declaredField.getAnnotation(InjectProperty.class);
            if(annotation!=null){
                String valueField = annotation.value().isBlank() ?
                        propertiesMap.get(declaredField.getName()) : propertiesMap.get(annotation.value());
                declaredField.setAccessible(true);
                declaredField.set(obj, valueField);
            }

        }
    }
}
