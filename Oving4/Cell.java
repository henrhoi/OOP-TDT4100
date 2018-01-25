package oving4;

public class Cell {
	
	public static boolean boatInCell(char[][] board, int x, int y){
		if (board[x][y] == 'X'){
			return true;
		}
		return false;
	}
	
	public char inCell(char[][] board, int x, int y){
		return board[x][y];
	}
	
	public boolean beenBombed(char[][] board, int x, int y){
		if(board[x][y] == 'B'){
			return true;
		}
		return false;
	}

}
