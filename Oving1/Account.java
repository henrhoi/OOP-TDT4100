package oving1;

public class Account {
	
	double balance;
	double interestRate;
	
	public Account(double startBalance, double startRate) {
		balance = startBalance;
		interestRate = startRate;
		
	}
	
	public void deposit(double amount){
		if (amount > 0) {
			balance += amount;
		}
	}
	
	public void addInterest(){
		double rent = interestRate;
		double rentValue = (balance*rent)/100;
		balance+= rentValue;
		
	}
	
	public double getBalance(){
		return balance;
	}
	
	public double getInterestRate(){
		return interestRate;
	}
	
	public double setInterestRate(double rate){
		return interestRate = rate;
	}
	
	public String toString(){
		return String.format("Beløpet på kontoen er nå %s, renta er nå %s prosent.", balance, interestRate);
	}

	public static void main(String[] args) {
		Account Axelskonto = new Account(12, 80);
		Axelskonto.deposit(8);
		Axelskonto.addInterest();
		System.out.println(Axelskonto);
	}
}
