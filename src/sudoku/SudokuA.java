package sudoku;

public abstract class SudokuA {
	protected int[][] sudoku = new int[9][9];
	protected int[][] solution = new int[9][9];
	protected final SudokuBuilder builder = new SudokuBuilder();
	
	public int[][] getSudoku() {
		int[][] sudokuCP = new int[9][9];
		SudokuBuilder.copyArray(sudoku, sudokuCP, 9);
		return sudokuCP;
	}
	
	public int[][] getSolution() {
		int[][] solutionCP = new int[9][9];
		SudokuBuilder.copyArray(solution, solutionCP, 9);
		return solutionCP;
	}
	
	public String[] toStringSudo(int[][] sudok) {
		String[] sudo = new String[9];
		for (int i = 0; i < 9; i++) {
			StringBuilder temp = new StringBuilder();
			if (sudok[i][0] != 0) {
				temp.append(sudok[i][0]);
			} else {
				temp.append('_');
			}
			for (int j = 1; j < 9; j++) {
				temp.append(" ");
				if (sudok[i][j] != 0) {
					temp.append(sudok[i][j]);
				} else {
					temp.append('_');
				}
			}
			sudo[i] = temp.toString();
		}
		return sudo;
	}
}
