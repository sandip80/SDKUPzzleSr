package Sudoku;

import SudokuTest.TestSudoku;

public class SudokuMain {
	public static void main(String[] args) {
		SudokuBuilder builder = new SudokuBuilder();
		int[][] sudoku = builder.getSoduku();
		long start = System.nanoTime();
		if (TestSudoku.testSudoku(sudoku)) {
			System.out.println("Valid sudoku");
		} else {
			System.out.println("Invalid sudoku");
		}
		print(sudoku);
		long ellapsed = System.nanoTime() - start;
		Double tomillis = new Double(ellapsed);
		tomillis = tomillis / 1000000;
		System.out.println("Time ellapsed: " + tomillis + " ms");
	}

	private static void print(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
	}
}
