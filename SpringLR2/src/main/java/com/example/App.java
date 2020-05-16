package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Printer printer = Printer.getInstance();

    public void Start()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Lock electronicLock = context.getBean("LockBean", Lock.class);

        electronicLock.lock();

        while(!(electronicLock.unlock()))
            printer.print("Пороль неверный. Попробуйте еще ");

        printer.print("Пороль введен верно");
    }

}
