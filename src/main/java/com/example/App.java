package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Printer printer = Printer.getInstance(); // Создается Синглтон


    public void start(ClassPathXmlApplicationContext context)
    {
        Lock electronicLock = context.getBean("LockBean", Lock.class); // Создаем бин класса Lock

        electronicLock.lock(context);

        while(!(electronicLock.unlock()))
            printer.print("Пороль неверный. Попробуйте еще ");

        printer.print("Пороль введен верно");
    }

}
