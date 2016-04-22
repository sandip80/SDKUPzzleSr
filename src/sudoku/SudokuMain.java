package sudoku;

import sudoku.test.TestSudoku;

public class SudokuMain {
	public static void main(String[] args) {
		SudokuHard sudo = new SudokuHard();
		long start = System.nanoTime();
		if (TestSudoku.testSudoku(sudo.getSolution())) {
			System.out.println("Valid sudoku");
		} else {
			System.out.println("Invalid sudoku");
		}
		print(sudo.toStringSudo(sudo.getSudoku()));
		System.out.println("\n");
		print(sudo.toStringSudo(sudo.getSolution()));
		long ellapsed = System.nanoTime() - start;
		Double tomillis = new Double(ellapsed);
		tomillis = tomillis / 1000000;
		System.out.println("Time ellapsed: " + tomillis + " ms");
	}

	private static void print(String[] sudoku) {
		for (int i = 0; i < 9; i++) {
			System.out.println(sudoku[i]);
		}
	}
}
