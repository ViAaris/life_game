package com.company;

import javax.swing.*;

public class Window implements Runnable {

    JFrame frame;


    public static final int WIDTH = 40;
    public static final int HEIGHT = 20;
    public static final int SIZE = 10;
    public Box[][] boxes = new Box[WIDTH][HEIGHT];

    @Override
    public void run() {
        createWindow();
        initBoxes();
        createColony();
    }

    public void createWindow() {

        frame = new JFrame("Life Game");
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(WIDTH*SIZE, HEIGHT*SIZE);
        frame.setVisible(true);
    }

    public void initBoxes() {
        for (int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }
    }

    public void createColony(){
        for(int x = 10; x < 25; x++){
            boxes[x][10].cell.setStatus(Status.LIVE);
        }
    }


}
