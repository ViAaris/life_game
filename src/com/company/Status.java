package com.company;

import java.awt.*;

public enum Status {

    NONE,
    BORN,
    LIVE,
    DEAD;

    public Status step1(int cellsAround){
        if(this == NONE && cellsAround == 3) return BORN;
        if(this == LIVE && (cellsAround <= 1  || cellsAround > 3)) return DEAD;
        else return this;
    }

    public Status step2(){
        if(this == BORN) return LIVE;
        if(this == DEAD) return NONE;
        else return this;
    }

    public Color getColor(){
        return switch (this) {
            case NONE -> Color.BLACK;
            case DEAD -> Color.GRAY;
            case BORN -> Color.PINK;
            case LIVE -> Color.GREEN;
        };
    }

}
