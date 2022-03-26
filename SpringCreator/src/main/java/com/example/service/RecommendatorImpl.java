package com.example.service;

import com.example.annotation.InjectProperty;
import com.example.interfaces.Recommendator;

public class RecommendatorImpl implements Recommendator {
    @InjectProperty(value = "alcohol")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("Is very good support: "+alcohol);
    }
}
