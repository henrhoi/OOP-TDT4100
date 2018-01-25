package oving8;

import java.util.Scanner;

public class HighscoreProgram implements HighscoreListListener{
	HighscoreList hsl;

	@Override
	public void listChanged(HighscoreList list, int n) {
		System.out.println("Listen endret seg på plass nr: " + n);
		
	}
	
	public void init(){
		 hsl = new  HighscoreList(10);
		 hsl.addHighscoreListListener(this);
	}
	
	public void run(){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int num = in.nextInt();
			hsl.addResult(num);
		}
		in.close();

	}
	 
	public static void main(String[] args) {
		HighscoreProgram prog = new HighscoreProgram();
		prog.init();
		prog.run();
	}
	 

}
