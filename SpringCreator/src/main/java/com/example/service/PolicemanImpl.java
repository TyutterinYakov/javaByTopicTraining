package com.example.service;

import com.example.interfaces.Policeman;

public class PolicemanImpl implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Всем покинуть комнату! Пиу пау!");
    }
}
