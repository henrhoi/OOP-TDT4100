package oving7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Stack;


public class TicTacToe implements saveload{
	private char[][] board;
	Stack<Action> redos;
	Stack<Action> undos;

	
	public TicTacToe(){
		this.board = new char[3][3];
		redos = new Stack<>();
		undos = new Stack<>();
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
			a += "_________________________";
			a += "\n";
			a += "|  ";
			a += board[0][0];
			a += " \t|  ";
			a += board[0][1];
			a += " \t|  ";
			a += board[0][2];
			a += " \t| ";
			a += "\n";
			a += "_________________________";
			a += "\n|  ";
			a += board[1][0];
			a += " \t|  ";
			a += board[1][1];
			a += " \t|  ";
			a += board[1][2];
			a += " \t| ";
			a += "\n";
			a += "_________________________";
			a += "\n|  ";
			a += board[2][0];
			a += " \t|  ";
			a += board[2][1];
			a += " \t|  ";
			a += board[2][2];
			a += " \t|  ";
			a += "\n";
			a += "_________________________";
			return a;
		}
	}
	
	
	public void play(int x, int y){
		char c = getCurrentPlayer();
		setCell(c,x,y);
		Action action = new Action(c,x,y);
		undos.push(action);
		redos.removeAllElements();
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
	
	public void undo(){
		if(undos.empty()){
			throw new IllegalStateException();
		}
		Action action = undos.pop();
		board[action.x][action.y] = ' ';
		setCell(' ' ,action.x ,action.y);
		redos.push(action);
	}
	
	public void redo(){
		if(redos.empty()){
			throw new IllegalStateException();
		}
		Action action = redos.pop();
		setCell(action.c ,action.x ,action.y);
		undos.push(action);			
	}
	


	@Override
	public void save(String fileName) {
		String brett = "";
		for (int i = 0; i<3; i++){
			for (int j = 0; j<3; j++){
				brett +=board[i][j];
			}
			brett+= "\n";
		}
		String filepath = new File("").getAbsolutePath();
		filepath += "/src/oving7/"+fileName;
		
		try {
			FileWriter writer = new FileWriter(new File(filepath));
			writer.write(brett);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void load(String fileName) {
		Reader reader = null;
		char[] buffer = null;
		
		try{
			String filepath = new File("").getAbsolutePath();
			filepath+= "/src/oving7/" + fileName;
			buffer = new char[12];
			reader = new FileReader(new File(filepath));
			reader.read(buffer);
			int k = 0;
			for (int i = 0; i<3; i++){
				for (int j = 0; j<3; j++){
					board[i][j] = buffer[k];
					if (k == 2 || k == 6){
						k+=2;
					}
					else{
						k+=1;
					}
				}
			}
			redos = new Stack<>();
			undos = new Stack<>();
			
			
		} catch (FileNotFoundException e1){
			System.err.println("Fant ikke filen...");
		} catch (IOException e2){
			System.err.println("Det her skjedde ved lesing fra filen");
		} finally{
			try{
				reader.close();
			} catch (IOException e3){
				e3.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TicTacToe game1 = new TicTacToe();
		game1.play(1, 1);
		game1.play(2, 2);
		game1.play(2, 1);
		game1.play(0, 0);
		//game1.save("spill.txt");
		game1.load("spill.txt");
		
		
	}
	

}
