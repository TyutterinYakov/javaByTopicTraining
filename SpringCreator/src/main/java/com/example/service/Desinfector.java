package com.example.service;

import com.example.ObjectFactory;
import com.example.interfaces.Announcer;
import com.example.interfaces.Policeman;
import com.example.model.Room;

public class Desinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room){
        announcer.announce("начинаем дезинфекцию! Все вон!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Вы можете вернуться в комнату");
    }

    private void desinfect(Room room) {
        System.out.println("Изгнание вируса...");
    }
}
