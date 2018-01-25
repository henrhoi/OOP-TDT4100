package oving1;

public class Location {
	int x;
	int y;
	
	public Location(int x1, int y1){
		x = x1;
		y = y1;	
	}
	
	public void up(){
		y-=1;
	}
	
	public void down(){
		y+=1;
	}
	
	public void left(){
		x-=1;
	}
	
	public void right(){
		x+=1;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String toString(){
		return String.format("X-verdien er %s, og Y-verdien er %s", x,y);
	}
	
	public static void main(String[] args){
		Location test = new Location(3,3);
		System.out.println(test);
		test.down();
		test.left();
		System.out.println(test);
		test.down();
		System.out.println(test);
	}
	

}
