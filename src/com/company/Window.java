package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {

    public static JFrame frame;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 20;
    public static final int SIZE = 10;
    public static Box[][] boxes = new Box[WIDTH][HEIGHT];

    @Override
    public void run() {
        createWindow();
        initBoxes();
        createColony();
        initTimer();
    }

    public static void createWindow() {

        frame = new JFrame("Life Game");
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(WIDTH*SIZE, HEIGHT*SIZE);
        frame.setVisible(true);
    }

    public static void initBoxes() {
        for (int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }

        for (int x = 0; x < WIDTH; x++)
            for(int y = 0; y < HEIGHT; y++)
                findNearCells(boxes[x][y]);
    }

        public static void findNearCells(Box box){
        for (int sx = -1; sx <= +1; sx++) {
            for (int sy = -1; sy <= +1; sy++) {
                if (!(sx == 0 && sy == 0)) {
                    box.cell.addNearCell(Window.boxes
                            [(box.x + sx + WIDTH) % WIDTH]
                            [(box.y + sy + HEIGHT) % HEIGHT].cell);
                }
            }
        }
    }
    public void initTimer(){
        var tm = new TimeListener();
        Timer timer = new Timer(100, tm);
        timer.start();
    }
    private class TimeListener implements ActionListener {

        boolean flop = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for(int x = 0; x < WIDTH; x++){
                for(int y = 0; y < HEIGHT; y++){
                    if(flop)boxes[x][y].step1();
                    else boxes[x][y].step2();
                }
            }
        }
    }

    public void createColony(){
        for(int x = 10; x < 15; x++){
            boxes[x][10].cell.setStatus(Status.LIVE);
        }
    }




}
