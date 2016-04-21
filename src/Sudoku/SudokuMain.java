package Sudoku;

public class SudokuMain {
	public static void main(String[] args) {
		SudokuBuilder builder = new SudokuBuilder();
		int[][] sudoku = builder.getSoduku();
		print(sudoku);
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
