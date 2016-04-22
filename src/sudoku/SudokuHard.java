package sudoku;

public final class SudokuHard extends SudokuA{
	public SudokuHard() {
		builder.createHardPuzzle(1000);
		solution = builder.getSoduku();
		SudokuBuilder.copyArray(solution, sudoku, 9);
		builder.removeCells(sudoku, 50);
	}
}
