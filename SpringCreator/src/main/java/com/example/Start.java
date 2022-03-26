package com.example;

import com.example.model.Room;
import com.example.service.Desinfector;

public class Start {

    public static void main(String[] args){
        new Desinfector().start(new Room());
    }
}
