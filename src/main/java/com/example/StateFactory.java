package com.example;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StateFactory {

    static Map<String, State> states = new HashMap<>();

    private Rand rand;

    public StateFactory() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.rand = context.getBean("RandBean", Rand.class);
    }


    public static State getState(String name, int passwordLength) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        State result = context.getBean("StateBean", State.class);
        result = states.get(name);
        if (result == null) {
            result = new State(Rand.generatePassword(passwordLength));
            states.put(name, result);
        }
        return result;
    }
}

