package sudoku;

public final class SudokuEasy extends SudokuA {
	public SudokuEasy() {
		builder.createEasyPuzzle(1000);
		solution = builder.getSoduku();
		SudokuBuilder.copyArray(solution, sudoku, 9);
		builder.removeCells(sudoku, 50);
	}
}
