package com.company;

import java.util.Scanner;

public class InputData {
    private Integer row;
    private Integer col;
    private Integer numberOfIterations;
    private Integer[][] grid;

    public void insertData(){
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split(", ");
        int width = Integer.parseInt(dimension[0]);
        int height = Integer.parseInt(dimension[1]);
        grid = new Integer[width][height];
        for (int i = 0; i < width; i++) {
            String[] gridData = scanner.nextLine().split("");
            for (int j = 0; j < gridData.length; j++) {
                grid[i][j] = Integer.parseInt(gridData[j]);
            }
        }
        String[] coordinates = scanner.nextLine().trim().split(", ");
        row = Integer.parseInt(coordinates[0]);
        col = Integer.parseInt(coordinates[1]);
        numberOfIterations = Integer.parseInt(coordinates[2]);
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }

    public Integer getNumberOfIterations() {
        return numberOfIterations;
    }

    public Integer[][] getGrid() {
        return grid;
    }
}

