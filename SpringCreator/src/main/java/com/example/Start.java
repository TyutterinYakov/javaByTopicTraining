package com.example;

import com.example.interfaces.Policeman;
import com.example.model.Room;
import com.example.service.AngryPoliceman;
import com.example.service.Desinfector;

import java.util.HashMap;
import java.util.Map;

public class Start {

    public static void main(String[] args){
            ApplicationContext context = Application.run(
                    "com.example",
                    new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
            context.getObject(Desinfector.class).start(new Room());
    }
}
