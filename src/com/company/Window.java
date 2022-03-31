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
                //boxes[x][y].findNearCells();
                for (int sx = -1; sx <= +1; sx++) {
                    for (int sy = -1; sy <= +1; sy++) {
                        if (!(sx == 0 && sy == 0)) {
                            boxes[x][y].cell.addNearCell(Window.boxes
                                    [(x + sx + WIDTH) % WIDTH]
                                    [(y + sy + HEIGHT) % HEIGHT].cell);
                        }
                    }
                }



    }

    private class TimeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void createColony(){
        for(int x = 10; x < 15; x++){
            boxes[x][10].cell.setStatus(Status.LIVE);
        }
    }


}
