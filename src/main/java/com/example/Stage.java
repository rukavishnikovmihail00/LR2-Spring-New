package com.example;

public class Stage {

    private String name;
    private State state;

    Stage(String stageName, State state){

        this.name = stageName;
        this.state = state;

    }

    public String getPassword(){
        return this.state.password;
    }

    public String getName() {
        return name;
    }
}

