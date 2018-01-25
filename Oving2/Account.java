package oving2;

public class Account {
	
	double balance;
	double interestRate;
	
	public void checkNegativeInt(double number){
		if (number<0){
			throw new IllegalArgumentException("Number must be positive");
		}
	}
	
	public Account(double startBalance, double startRate) {
		checkNegativeInt(startBalance);
		checkNegativeInt(startRate);
		this.balance = startBalance;
		this.interestRate = startRate;
		
	}
	
	public void deposit(double amount){
		checkNegativeInt(amount);
		balance += amount;
	}
	
	public void withdraw(double amount){
		if (amount > balance){
			throw new IllegalArgumentException("Kan ikke ta ut mere enn det som er på kontoen.");
		}
		else if (amount<0){
			throw new IllegalStateException("Tall må være over null");
		}
		else{
			balance -= amount;
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
	
	public void setInterestRate(double rate){
		checkNegativeInt(rate);
		interestRate = rate;
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
