package oving4;

import java.util.Arrays;
import oving4.Cell;

public class BattleshipBoard {
	
	char[][] boardp1;
	char[][] gameBoardp1;
	char[][] boardp2;
	char[][] gameBoardp2;
	int player = 1;
	boolean winner1 = false;
	boolean winner2 = false;
	
	public BattleshipBoard(){
		String s = Levels.SAMPLE_LEVEL1;
		String p = Levels.SAMPLE_LEVEL2;
		String rad1 = s.substring(0, 10);
		String rad2 = s.substring(10, 20);
		String rad3 = s.substring(20, 30);
		String rad4 = s.substring(30, 40);
		String rad5 = s.substring(40, 50);
		String rad6 = s.substring(50, 60);
		String rad7 = s.substring(60, 70);
		String rad8 = s.substring(70, 80);
		String rad9 = s.substring(80, 90);
		String rad10 = p.substring(90, 100);
		String rad12 = p.substring(0, 10);
		String rad22 = p.substring(10, 20);
		String rad32 = p.substring(20, 30);
		String rad42 = p.substring(30, 40);
		String rad52 = p.substring(40, 50);
		String rad62 = p.substring(50, 60);
		String rad72 = p.substring(60, 70);
		String rad82 = p.substring(70, 80);
		String rad92 = p.substring(80, 90);
		String rad102 = p.substring(90, 100);
		this.boardp1 = new char[10][10];
		this.gameBoardp1 = new char[10][10];
		this.boardp2 = new char[10][10];
		this.gameBoardp2 = new char[10][10];
		for (int a = 0; a < 10; a++){
			boardp1[0][a] = rad1.charAt(a);
			boardp1[1][a] = rad2.charAt(a);
			boardp1[2][a] = rad3.charAt(a);
			boardp1[3][a] = rad4.charAt(a);
			boardp1[4][a] = rad5.charAt(a);
			boardp1[5][a] = rad6.charAt(a);
			boardp1[6][a] = rad7.charAt(a);
			boardp1[7][a] = rad8.charAt(a);
			boardp1[8][a] = rad9.charAt(a);
			boardp1[9][a] = rad10.charAt(a);
			boardp2[0][a] = rad12.charAt(a);
			boardp2[1][a] = rad22.charAt(a);
			boardp2[2][a] = rad32.charAt(a);
			boardp2[3][a] = rad42.charAt(a);
			boardp2[4][a] = rad52.charAt(a);
			boardp2[5][a] = rad62.charAt(a);
			boardp2[6][a] = rad72.charAt(a);
			boardp2[7][a] = rad82.charAt(a);
			boardp2[8][a] = rad92.charAt(a);
			boardp2[9][a] = rad102.charAt(a);
		}
		for (int a = 0; a<10; a++){
			for(int b = 0; b<10; b++){
				gameBoardp1[b][a] = '~';
				gameBoardp2[b][a] = '~';
			}
		}
	}
	public boolean bomb(char[][] board,int x, int y, int player){
		if (Cell.boatInCell(board,x,y) == true){
			board[x][y] = 'B';
			if (player == 1){
				gameBoardp2[x][y] = 'X';
			}
			if (player == 2){
				gameBoardp1[x][y] = 'X';
			}
			System.out.println("It was a hit");
			return true;
		}
		if (player == 1){
			gameBoardp2[x][y] = '.';;
		}
		if (player == 2){
			gameBoardp1[x][y] = '.';;
		}
		System.out.println("It was a miss");
		return false;
	}
	
		public void play(int x, int y){
			if (player == 1){
				bomb(boardp2,x,y,1);
				player = 2;
			}
			else if (player == 2){
				bomb(boardp1,x,y,2);
				player = 1;
			}
		}
		
		public void getInput(String in){
			int x = Character.getNumericValue(in.charAt(0));
			int y = Character.getNumericValue(in.charAt(2));
			play(x,y);
			winner();
		}
		
		public void winner(){
			int p1X = 0;
			int p2X = 0;
			for (int a = 0; a<10; a++){
				for(int b = 0; b<10; b++){
					if (boardp1[b][a] == 'X'){
						p1X += 1;
					}
					if (boardp2[b][a] == 'X'){
						p2X +=1;
					}
					
				}
			}
			if (p1X == 0){
				winner2 = true;
			}
			if (p2X == 0){
				winner1 = true;
			}
			
		}
		
		public String toString(){
			String k = "";
			if (winner1 == true){
				return "Player 1 won";
			}
			if (winner2 == true){
				return "Player 2 won";
			}
			if (player == 2){
				String a = "Player 2's turn: \n";
				for (int c = 0; c<10; c++){
					a+= "| "+ gameBoardp1[c][0] + " ";
					a+= gameBoardp1[c][1] + " ";
					a+= gameBoardp1[c][2] + " ";
					a+= gameBoardp1[c][3] + " ";
					a+= gameBoardp1[c][4] + " ";
					a+= gameBoardp1[c][5] + " ";
					a+= gameBoardp1[c][6] + " ";
					a+= gameBoardp1[c][7] + " ";
					a+= gameBoardp1[c][8] + " ";
					a+= gameBoardp1[c][9] + " |\n";
				}
				return a;
			}
			else if (player == 1){
				String a = "Player 1's turn: \n";
				for (int c = 0; c<10; c++){
					a+= "| " + gameBoardp2[c][0] + " ";
					a+= gameBoardp2[c][1] + " ";
					a+= gameBoardp2[c][2] + " ";
					a+= gameBoardp2[c][3] + " ";
					a+= gameBoardp2[c][4] + " ";
					a+= gameBoardp2[c][5] + " ";
					a+= gameBoardp2[c][6] + " ";
					a+= gameBoardp2[c][7] + " ";
					a+= gameBoardp2[c][8] + " ";
					a+= gameBoardp2[c][9] + " |\n";
				}
				return a;
			}
			return k;
		}
	
	
	
	public static void main(String[] args) {
		BattleshipBoard henrik = new BattleshipBoard();
		char[][] a = henrik.boardp1;
		System.out.println(Arrays.deepToString(a));
		
	}
	
	

}
