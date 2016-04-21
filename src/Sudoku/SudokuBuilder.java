package Sudoku;

import java.util.ArrayList;
import java.util.Random;

public class SudokuBuilder {
	Random rn;
	private int[][] sudoku;
			
	public SudokuBuilder() {
		rn = new Random();
		sudoku = new int[9][9];
		assignNumbers();
		//createEasyPuzzle(200);
		createHardPuzzle(1000);
	}

	private void assignNumbers() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = (i * 3 + i / 3 + j) % 9 + 1;
			}
		}
	}
	
	public void createHardPuzzle(int iteration) {
		while (iteration != 0) {
			int num1 = rn.nextInt(9) + 1;
			int num2 = rn.nextInt(9) + 1;
			swapCells(num1, num2);
			iteration--;
		}
	}
	
	public void createEasyPuzzle(int iteration) {
		while (iteration != 0) {
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					int rand1 = rn.nextInt(3) + i;
					int rand2 = rn.nextInt(3) + i;
					int rand3 = rn.nextInt(3) + j;
					int rand4 = rn.nextInt(3) + j;
					swapTwoRows(rand1, rand2);
					swapTwoColumns(rand3, rand4);
				}
			}
			iteration--;
		}
	}
	
	public void swapTwoRows(int row1, int row2) {
		for (int i = 0; i < 9; i++) {
			int temp = sudoku[row1][i];
			sudoku[row1][i] = sudoku[row2][i];
			sudoku[row2][i] = temp;
		}
	}
	
	public void swapTwoColumns(int column1, int column2) {
		for (int i = 0; i < 9; i++) {
			int temp = sudoku[i][column1];
			sudoku[i][column1] = sudoku[i][column2];
			sudoku[i][column2] = temp;
		}
	}
	
	public void swapCells(int num1, int num2) {
		boolean swapped = false;
		for (int i = 0; i < 9; i++) {
			swapped = false;
			for (int j = 0; j < 9; j++) {
				if (num1 == sudoku[i][j]) {
					int k = 0;
					while (k < 9 && !swapped) {
						if (num2 == sudoku[i][k]) {
							int temp = sudoku[i][j];
							sudoku[i][j] = sudoku[i][k];
							sudoku[i][k] = temp;
							swapped = true;
						}
						k++;
					}
				}
			}
		}
	}
	
	public int[][] getSoduku() {
		int[][] sudokuCP = sudoku;
		return sudokuCP;
	}
}
