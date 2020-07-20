package com.company;

import java.util.Scanner;

public class Engine implements Runnable {
    @Override
    public void run() {
        InputData inputData = new InputData();
        inputData.insertData();
        Integer row = inputData.getRow();
        Integer col = inputData.getCol();
        Integer numberOfIterations = inputData.getNumberOfIterations();
        Integer[][] grid = inputData.getGrid();
        Game game = new Game(col, row, numberOfIterations, grid);
        game.startGeneration();
        System.out.println(game.toString());
    }
}
