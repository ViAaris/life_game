package com.company;
import javax.swing.*;
import static com.company.Window.SIZE;

public class Box extends JPanel{
    public Cell cell;

    public Box(int x, int y){
        super();
        this.cell = new Cell();
        setBounds(SIZE*x, SIZE*y, SIZE, SIZE);
        setBackground(cell.getColor());
    }

}
