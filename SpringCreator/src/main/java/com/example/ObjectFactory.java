package com.example;

import com.example.config.Config;
import com.example.config.JavaConfig;
import com.example.config.ObjectConfigurator;
import com.example.interfaces.Policeman;
import com.example.service.AngryPoliceman;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory(){
        this.config = new JavaConfig(
                "com.example",
                new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));

        for (Class<? extends ObjectConfigurator> aClass : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if(type.isInterface()){
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach((c)->{
            c.configure(t);
        });


        return t;
    }
}
