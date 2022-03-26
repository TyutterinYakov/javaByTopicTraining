package com.example.service;

import com.example.annotation.InjectByType;
import com.example.annotation.Singletone;
import com.example.interfaces.Announcer;
import com.example.interfaces.Policeman;
import com.example.model.Room;

@Singletone
@Deprecated
public class Desinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

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
