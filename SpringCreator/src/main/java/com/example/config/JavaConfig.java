package com.example.config;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        this.ifc2ImplClass = ifc2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> interf) {
        return ifc2ImplClass.computeIfAbsent(interf, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(interf);
            if(classes.size()!=1){
                throw new RuntimeException(interf+" has zero or more then one impl");
            }
            return classes.iterator().next();
        });
    }
}
