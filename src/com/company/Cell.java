package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Cell {
    private Status status;
    private Color color;
    private ArrayList<Cell> nearCells = new ArrayList<Cell>();

    public Cell(){
        status = Status.NONE;
        color =  status.getColor();
    }

    public void addNearCell(Cell cell){
        nearCells.add(cell);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        color = status.getColor();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
