package com.example;

import java.util.HashMap;
import java.util.Map;

public class StateFactory {
    static Map<String, State> states = new HashMap<>();

    public static State getState(String name, int passwordLength) {
        State result = states.get(name);
        if (result == null) {
            Rand rand = new Rand();
            result = new State(rand.generatePassword(passwordLength));
            states.put(name, result);
        }
        return result;
    }
}

