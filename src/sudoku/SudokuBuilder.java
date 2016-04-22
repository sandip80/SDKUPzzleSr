package sudoku;

import java.util.Random;

public class SudokuBuilder {
	Random rn;
	private int[][] sudoku;
			
	public SudokuBuilder() {
		rn = new Random();
		sudoku = new int[9][9];		
	}

	private void assignNumbers() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = (i * 3 + i / 3 + j) % 9 + 1;
			}
		}
	}
	
	public void createHardPuzzle(int iteration) {
		assignNumbers();
		while (iteration != 0) {
			int num1 = rn.nextInt(9) + 1;
			int num2 = rn.nextInt(9) + 1;
			swapCells(num1, num2);
			iteration--;
		}
	}
	
	public void createEasyPuzzle(int iteration) {
		assignNumbers();
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
	
	private void swapTwoRows(int row1, int row2) {
		for (int i = 0; i < 9; i++) {
			int temp = sudoku[row1][i];
			sudoku[row1][i] = sudoku[row2][i];
			sudoku[row2][i] = temp;
		}
	}
	
	private void swapTwoColumns(int column1, int column2) {
		for (int i = 0; i < 9; i++) {
			int temp = sudoku[i][column1];
			sudoku[i][column1] = sudoku[i][column2];
			sudoku[i][column2] = temp;
		}
	}
	
	private void swapCells(int num1, int num2) {
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
	
	public void removeCells(int[][] sudo, int num) {
		while (num != 0) {
			int row = rn.nextInt(9);
			int column = rn.nextInt(9);
			if (sudo[row][column] != 0) {
				sudo[row][column] = 0;
				num--;
			}
		}
	}
	
	public int[][] getSoduku() {
		int[][] sudokuCP = new int[9][9];
		SudokuBuilder.copyArray(sudoku, sudokuCP, 9);
		return sudokuCP;
	}
	
	public static void copyArray(int[][] src, int[][] dest, int length) {
		for (int i = 0; i < length; i++) {
			System.arraycopy(src[i], 0, dest[i], 0, length);
		}
	}
}
