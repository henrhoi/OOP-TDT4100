package oving4;


public class TicTacToe {
	private char[][] board;

	
	public TicTacToe(){
		this.board = new char[3][3];
		for (int b = 0; b<board.length; b++){
			board[b][0] = ' ';
			board[b][1] = ' ';
			board[b][2] = ' ';
		}
	}
	
	public char getCell(int x, int y){
		return board[x][y];
	}
	
	public boolean setCell(char c, int x, int y){
		if (board[x][y] == ' '){
			board[x][y] = c;
			return true;
		}
		return false;
	}
	
	public boolean isOccupied(int x, int y){
		if (board[x][y] != ' '){
			return true;
		}
		return false;
	}
	
	public char getCurrentPlayer(){
		int p1 = 0;
		int p2 = 0;
		for (int b = 0; b<board.length; b++){
			if (board[b][0] == 'x'){
				p1 += 1;
			}
			if (board[b][1] == 'x'){
				p1 += 1;
			}
			if (board[b][2] == 'x'){
				p1 += 1;
			}
			if (board[b][0] == 'o'){
				p2 += 1;
			}
			if (board[b][1] == 'o'){
				p2 += 1;
			}
			if (board[b][2] == 'o'){
				p2 += 1;
			}
		}
		if (p1==p2){
			return 'x';
		}
		return 'o';
	}
	
	public String toString(){
		if (isWinner('x') == true){
			return "Spiller 1 (x) vant";
		}
		else if (isWinner('o') == true){
			return "Spiller 2 (o) vant";
		}
		else if (isFinished() == true){
			return "Ingen vant";
		}
		else{
			String a = "";
			a += "__________________";
			a += "\n";
			a += "|  ";
			a += board[0][0];
			a += " \t|  ";
			a += board[0][1];
			a += " \t|  ";
			a += board[0][2];
			a += " \t| ";
			a += "\n";
			a += "__________________";
			a += "\n|  ";
			a += board[1][0];
			a += " \t|  ";
			a += board[1][1];
			a += " \t|  ";
			a += board[1][2];
			a += " \t| ";
			a += "\n";
			a += "__________________";
			a += "\n|  ";
			a += board[2][0];
			a += " \t|  ";
			a += board[2][1];
			a += " \t|  ";
			a += board[2][2];
			a += " \t|  ";
			a += "\n";
			a += "__________________";
			return a;
		}
	}
	
	
	public void play(int x, int y){
		char c = getCurrentPlayer();
		setCell(c,x,y);
	}
	
	public boolean isWinner(char c){
		if (board[0][0] == c && board[0][1] == c && board[0][2] == c){
			return true;
		}
		else if (board[1][0] == c && board[1][1] == c && board[1][2] == c){
			return true;
		}
		else if (board[2][0] == c && board[2][1] == c && board[2][2] == c){
			return true;
		}
		else if (board[0][0] == c && board[1][0] == c && board[2][0] == c){
			return true;
		}
		else if (board[0][1] == c && board[1][1] == c && board[2][1] == c){
			return true;
		}
		else if (board[0][2] == c && board[1][2] == c && board[2][2] == c){
			return true;
		}
		else if (board[0][0] == c && board[1][1] == c && board[2][2] == c){
			return true;
		}
		else if (board[0][2] == c && board[1][1] == c && board[2][0] == c){
			return true;
		}
		return false;
	}
	public boolean hasWinner(){
		if (isWinner('x') == true || isWinner('o') == true){
			return true;
		}
		return false;
	}
	
	public boolean isFinished(){
		if (hasWinner() == true){
			return true;
		}
		int empty = 0;
		for (int b = 0; b<board.length; b++){
			if (board[b][0] == ' '){
				empty += 1;
			}
			if (board[b][1] == ' '){
				empty += 1;
			}
			if (board[b][2] == ' '){
				empty += 1;
			}
		}
		if (empty == 0){
			return true;
		}
		return false;
	}
	
	public void getInput(String in){
		int x = Character.getNumericValue(in.charAt(0));
		int y = Character.getNumericValue(in.charAt(2));
		play(x,y);
	}
	public static void main(String[] args) {
		TicTacToe henrik = new TicTacToe();
		System.out.println(henrik);
		if (henrik.board[0][1] == ' '){
			System.out.println("Jaa");
		}
	}
	

}
