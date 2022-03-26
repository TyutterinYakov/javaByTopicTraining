package com.example.config;

import org.reflections.Reflections;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> interf);
    Reflections getScanner();
}
