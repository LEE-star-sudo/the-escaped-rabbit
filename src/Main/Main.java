package Main;

import Data.data;
import Interface.gather;
import Items.preciousStone;
import Items.wall;

import javax.swing.*;
import java.util.Random;

public class Main {

    private data data = new data();
    private Random rand = new Random();
    private int xPreciousStone;
    private int yPreciousStone;
    private int xWall;
    private int yWall;
    private int totalCount;
    private final static String[][] temp = new String[50][50];

    public Main(){
        totalCount = 5;
    }

    public void initialization(){
        //初始化宝石
        gather preciousStone = new preciousStone(1,3);
        xPreciousStone = rand.nextInt(100);
        yPreciousStone = rand.nextInt(100);
        data.storage(xPreciousStone,yPreciousStone, preciousStone);
        temp[xPreciousStone][yPreciousStone] = "preciousStone";
        //初始化墙壁
        while(totalCount > 0) {
            xWall = rand.nextInt(46);  //避免越界
            yWall = rand.nextInt(46);
            if (temp[xWall][yWall] == null) {
                for (int i = 1; i < 5; i++) {
                    for (int j = 1; j < 5; j++) {
                        if (temp[xWall + i][yWall + j] == null) {
                            gather wall = new wall();
                            data.storage(xWall + i, yWall + j, wall);
                            temp[xWall + i][yWall + j] = "wall";
                        }
                    }
                }
            }
            totalCount--;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initialization();
        System.out.println(main.data);
    }
}