package oving9;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {
	
	ObservableHighscoreList ob;
	public void init(){
		ob = new ObservableHighscoreList(10);
		ob.addObservableListListener(this);
	}

	
	
	public void run(){
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextInt()){
			int sum = in.nextInt();
			this.ob.addResult(sum);
		}
		in.close();
	}
	
	@Override
	public void listChanged(ObservableList list, int n) {
		System.out.println("Listen har endret seg på plass " + n);
		
	}
	
	public static void main(String[] args) {
		ObservableHighscoreListProgram p = new ObservableHighscoreListProgram();
		p.init();
		p.run();
	}

}
