package SudokuTest;

public class TestSudoku {
	private static int[][] testsudoku;
	
	public static boolean testSudoku(int[][] sudoku) {
		testsudoku = sudoku;
		if (checkValidRow() && checkValidColumn() && checkValidBox()) {
			return true;
		}
		return false;
	}

	private static boolean checkValidBox() {
		for (int i = 0; i < 9; i+=3) {
			for (int j = 0; j < 9; j+=3) {
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						for (int m = i; m < i + 3; m++) {
							for (int n = j; n < j + 3; n++) {
								if ((testsudoku[k][l] == testsudoku[m][n]) && (k != m || l != n)) {
									return false;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	private static boolean checkValidColumn() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					if ((testsudoku[j][i] == testsudoku[k][i]) && j != k) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean checkValidRow() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					if ((testsudoku[i][j] == testsudoku[i][k]) && j != k) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
