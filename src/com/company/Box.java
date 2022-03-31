package com.company;

import com.sun.jna.platform.win32.WinUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static com.company.Window.SIZE;

public class Box extends JPanel {
    public Cell cell;
    int x;
    int y;

    public Box(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        cell = new Box.Cell();
        setBounds(SIZE * x, SIZE * y, SIZE, SIZE);
        setBackground(cell.getColor());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.turn();
            }
        });
    }

    public void setColor() {
        //Config.getColor(cell.status)
        setBackground(cell.status.getColor());
    }

    public void step1() {
        cell.setStatus(cell.status.step1(cell.getHowManyAlive()));

    }

    public void step2() {
         cell.setStatus(cell.status.step2());

    }


    public class Cell {

        private Status status;
        private Color color;
        private ArrayList<Cell> nearCells = new ArrayList<Cell>();
        private final int howManyAlive = countAlive();

        public int getHowManyAlive() {
            return howManyAlive;
        }

        public ArrayList<Cell> getNearCells() {
            return nearCells;
        }

        public Cell() {
            status = Status.NONE;
            color = status.getColor();
        }

//for testing
        public void getCoord() {
            System.out.println(Box.this.x + " " + Box.this.y);
        }

        public void addNearCell(Cell cell) {
            nearCells.add(cell);
        }

        public int countAlive() {
            int howManyAlive = 0;
            for (Cell cell : nearCells) {
                if (cell.isAlive()) howManyAlive++;
            }
            return howManyAlive;
        }

        public boolean isAlive() {
            return status == Status.LIVE || status == Status.DEAD;
        }

        public void setStatus(Status status) {
            this.status = status;
            color = status.getColor();
            Box.this.setColor();
        }

        public Color getColor() {
            return color;
        }


        public void turn() {
            for (Cell cell : nearCells) {
                cell.status = cell.isAlive() ? Status.NONE : Status.LIVE;
            }
        }
    }
}
