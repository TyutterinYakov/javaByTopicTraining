package com.example.service;

import com.example.annotation.InjectByType;
import com.example.annotation.Singletone;
import com.example.interfaces.Policeman;
import com.example.interfaces.Recommendator;

import javax.annotation.PostConstruct;

@Singletone
public class AngryPoliceman implements Policeman {
    @InjectByType
    private Recommendator recommendator;

//    @PostConstruct
//    public void init(){
//
//        System.out.println(recommendator.getClass());
//    }

    @Override
    public void makePeopleLeaveRoom() {
        recommendator.recommend();
        System.out.println("Пиу пау! Я злой, валите все!");
    }
}
