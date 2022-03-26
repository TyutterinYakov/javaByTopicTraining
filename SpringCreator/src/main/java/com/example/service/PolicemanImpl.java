package com.example.service;

import com.example.annotation.Singletone;
import com.example.interfaces.Policeman;
@Singletone
public class PolicemanImpl implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Всем покинуть комнату! Пиу пау!");
    }
}
