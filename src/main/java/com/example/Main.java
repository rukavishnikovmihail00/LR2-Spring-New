package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        App app = context.getBean("AppBean", App.class); // Создаем бин класса Арр
        app.start(context);
    }
}
