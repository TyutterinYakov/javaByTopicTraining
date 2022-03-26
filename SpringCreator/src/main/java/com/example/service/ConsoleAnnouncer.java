package com.example.service;

import com.example.ObjectFactory;
import com.example.interfaces.Announcer;
import com.example.interfaces.Recommendator;

public class ConsoleAnnouncer implements Announcer {

    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
