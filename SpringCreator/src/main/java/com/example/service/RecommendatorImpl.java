package com.example.service;

import com.example.annotation.InjectProperty;
import com.example.annotation.Singletone;
import com.example.interfaces.Recommendator;

@Singletone
public class RecommendatorImpl implements Recommendator {
    @InjectProperty(value = "alcohol")
    private String alcohol;


    @Override
    public void recommend() {
        System.out.println("Is very good support: "+alcohol);
    }
}
