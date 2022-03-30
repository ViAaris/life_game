package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.Window.SIZE;

public class Box extends JPanel{
    public Cell cell;

    public Box(int x, int y){
        super();
        cell = new Box.Cell();
        setBounds(SIZE*x, SIZE*y, SIZE, SIZE);
        setBackground(cell.getColor());
    }

    public void setColor(){
        setBackground(cell.getColor());
    }

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
            Box.this.setColor();
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }
}
