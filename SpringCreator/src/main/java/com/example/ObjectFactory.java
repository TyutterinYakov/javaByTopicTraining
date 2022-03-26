package com.example;

import com.example.config.ObjectConfigurator;
import com.example.config.ProxyConfigurator;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectFactory {
    private static ObjectFactory ourInstance;
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private ApplicationContext context;
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context){
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner()
                .getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
        for(Class<? extends ProxyConfigurator> aClass: context.getConfig().getScanner()
                .getSubTypesOf(ProxyConfigurator.class)) {
            proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = create(implClass);
        configure(t);
        t = configureProxy(t, implClass);
        invokeInit(t, implClass);
        return t;
    }

    private <T> T configureProxy(T t, Class<T> imlClass) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = (T) proxyConfigurator.replaceWithProxyIfNeeded(t, imlClass);
        }
        return t;
    }


    @SneakyThrows
    private <T> T create(Class<T> implClass){
        return implClass.getDeclaredConstructor().newInstance();
    }

    private <T> void configure(T t){
        configurators.forEach((c)->{
            c.configure(t, context);
        });
    }

    private <T> void invokeInit(T t, Class<T> implClass){
        Arrays.stream(implClass.getMethods())
                .filter(m->m.isAnnotationPresent(PostConstruct.class))
                .forEach(m->{
                    try {
                        m.invoke(t);
                    } catch (Exception ex){
                        ex.printStackTrace();
                        throw new RuntimeException("Ошибка вызова метода");
                    }
                });
    }

}
