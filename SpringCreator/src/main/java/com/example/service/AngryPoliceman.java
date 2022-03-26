package com.example.service;

import com.example.interfaces.Policeman;

public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Пиу пау! Я злой, валите все!");
    }
}
