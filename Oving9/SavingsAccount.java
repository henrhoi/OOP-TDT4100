package oving9;

public class SavingsAccount implements Account{
	
	protected double rent;
	protected double balance;
	
	public SavingsAccount(double rent){
		this.rent = rent;
		this.balance = 0;
	}

	@Override
	public void deposit(double amount) {
		if (amount >= 0){
			this.balance += amount;
		}
		else{ throw new IllegalArgumentException("Beløp må være positivt");}
		
	}

	@Override
	public void withdraw(double amount) {
		if (amount > 0){
			if(this.balance - amount < 0){
				throw new IllegalStateException("Beløp på konto må være positivt");
			}
			this.balance -= amount;
		}
		else{ throw new IllegalArgumentException("Beløp må være positivt");}
		
	}

	@Override
	public double getBalance() {
		return this.balance;
	}
	

	public void endYearUpdate(){
		this.balance += balance*rent;
	}

}
