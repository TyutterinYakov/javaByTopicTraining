package com.example;

import com.example.config.JavaConfig;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        JavaConfig javaConfig = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext applicationContext = new ApplicationContext(javaConfig);
        ObjectFactory objectFactory = new ObjectFactory(applicationContext);
        //TODO  - init all singletons which are not lazy
        applicationContext.setFactory(objectFactory);
        return applicationContext;
    }
}
