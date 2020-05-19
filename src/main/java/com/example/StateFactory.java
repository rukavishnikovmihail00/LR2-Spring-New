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
        State result = states.get(name);
        if (result == null) {
            //Rand rand = new Rand();
            result = new State(this.rand.generatePassword(passwordLength));
            states.put(name, result);
        }
        return result;
    }
}

