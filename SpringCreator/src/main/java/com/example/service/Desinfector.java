package com.example.service;

import com.example.model.Room;

public class Desinfector {

    public void start(Room room){
        announcer.announce("начинаем дезинфекцию!");
        desinfect(room);
    }

    private void desinfect(Room room) {
        System.out.println("Изгнание вируса....");
    }
}
