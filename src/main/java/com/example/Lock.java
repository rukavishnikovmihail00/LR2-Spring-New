package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyEditorSupport;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;


public class Lock {

    private Printer printer = Printer.getInstance();

    private Scanner in = new Scanner(System.in);
    private ArrayList<Stage> stages = new ArrayList();
    private int stageNumber = 0;

    public void lock() {

        printer.print("Сколько стадий ввода пороля должно быть у замка?");
        this.stageNumber = in.nextInt();
        printer.print("Введите длину поролей");
        int length = in.nextInt();
        printer.print("Число вариаций пороля");
        int stateNumber = in.nextInt();


        for (int i = 0; i < this.stageNumber; i++) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            Rand rand = context.getBean("RandBean", Rand.class);
            printer.print("Введите название стадии " + (i + 1));
            String name = in.next();
            printer.print(rand.randomInt2String(1, stateNumber));


            State state = StateFactory.getState(rand.randomInt2String(1, stateNumber), length);

            Stage stage = context.getBean("StageBean", Stage.class);
            stage.setName(name);
            stage.setState(state);
            stages.add(i, stage);
        }
    }

    public boolean unlock() {
        for (int i = 0; i < this.stageNumber; i++) {
            Stage currentStage = stages.get(i);
            printer.print("Название стадии: " + currentStage.getName() + "\n");
            printer.print("Стадия: " + (i + 1) + " Всего стадий: " + (this.stageNumber) + "\n");
            printer.print("Введите пороль: ");
            String password = in.next();
            if (!(password.equals(currentStage.getPassword())))
                return false;

        }
        return true;
    }

}