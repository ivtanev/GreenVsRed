package com.company;

public class Game {
    private Integer row;
    private Integer col;
    private Integer numberOfIterations;
    private Integer[][] grid;
    private Integer result = 0;

    public Game(Integer row, Integer col, Integer numberOfIterations, Integer[][] grid) {
        this.setRow(row);
        this.setCol(col);
        this.setNumberOfIterations(numberOfIterations);
        this.setGrid(grid);
    }

    private Integer getRow() {
        return row;
    }

    private Integer getCol() {
        return col;
    }

    private Integer getNumberOfIterations() {
        return numberOfIterations;
    }

    private Integer[][] getGrid() {
        return grid;
    }

    private Integer getResult() {
        return result;
    }

    private void setRow(Integer row) {
        this.row = row;
    }

    private void setCol(Integer col) {
        this.col = col;
    }

    private void setNumberOfIterations(Integer numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }

    private void setGrid(Integer[][] grid) {
        this.grid = grid;
    }

    private void setResult(Integer result) {
        this.result = result;
    }

    public void startGeneration() {
        int size = this.getNumberOfIterations();
        int counter = 0;
        int rowSize = grid[0].length;
        int colSize = grid[1].length;
        Integer[][] newGrid = new Integer[rowSize][colSize];
        for (int i = 0; i <= size; i++) {
            for (int currentRow = 0; currentRow < rowSize; currentRow++) {
                for (int currentCol = 0; currentCol < colSize; currentCol++) {
                    if (grid[currentRow][currentCol] == 1) {
                        counter = countGreenCell(counter, currentRow, currentCol);
                        if (counter == 2 || counter == 3 || counter == 6) {
                            newGrid[currentRow][currentCol] = 1;
                        } else {
                            newGrid[currentRow][currentCol] = 0;
                        }
                        counter = 0;
                    } else {
                        counter = countGreenCell(counter, currentRow, currentCol);
                        if (counter == 3 || counter == 6) {
                            newGrid[currentRow][currentCol] = 1;
                        } else {
                            newGrid[currentRow][currentCol] = 0;
                        }
                        counter = 0;
                    }
                }
            }
            if (grid[row][col] == 1) {
                this.setResult(this.getResult() + 1);
            }

            for (int row = 0; row < newGrid[0].length; row++) {
                for (int col = 0; col < newGrid[1].length ; col++) {
                    grid[row][col] = newGrid[row][col];
                }
            }
        }

    }

    private int countGreenCell(int counter, int row, int col) {
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r < 0 || c < 0 || r >= this.grid[0].length || c >= this.grid[1].length) {
                    continue;
                }
                if (r == row && c == col) {
                    continue;
                }
                if (grid[r][c] == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "# expected result: " + this.getResult();
    }
}
