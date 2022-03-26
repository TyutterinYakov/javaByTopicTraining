package com.example.service;

import com.example.annotation.InjectByType;
import com.example.annotation.Singletone;
import com.example.interfaces.Announcer;
import com.example.interfaces.Recommendator;

@Singletone
public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
