package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class StateFactory {

    private static Map<String, State> states = new HashMap<>();

    public static State getStates(String name, int passwordLength, Rand rand, ClassPathXmlApplicationContext context) {

        State currentState = states.get(name);

        if (currentState == null) {
            currentState = context.getBean("StateBean", State.class);
            currentState.setPassword(rand.generatePassword(passwordLength));
            states.put(name, currentState);
        }
        return currentState;
    }
}

