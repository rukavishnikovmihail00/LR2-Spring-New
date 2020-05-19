package com.example;

public class Stage {

    private String name;
    private State state;

    public Stage() {
    }

    public void setName(String name){
        this.name = name;
    }

    public void setState(State state){
        this.state = state;
    }

    public String getPassword(){
        return this.state.password;
    }

    public String getName() {
        return name;
    }
}

