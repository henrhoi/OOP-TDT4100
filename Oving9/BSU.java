package oving9;

public class BSU extends SavingsAccount{
	
	private double maxInput;
	private double yearlyInput;
	private double outtakes;

	public BSU(double rent, double maxInput) {
		super(rent);
		this.maxInput = maxInput;
		this.yearlyInput = 0;
		this.outtakes = 0;
	}
	
	public void deposit(double amount) {
		if (yearlyInput + amount <= maxInput){
			super.deposit(amount);
			yearlyInput += amount;
		}
		else{
			throw new IllegalStateException("Du har satt inn for mye i år");
		}

//
	}
	
	public void withdraw(double amount) {
		if (amount + outtakes <= yearlyInput){
			super.withdraw(amount);
			outtakes += amount;
		}
		else {
			throw new IllegalStateException("Du kan ikke ta ut så mye");
		}

		
	}
	
	public double getTaxDeduction(){
		return yearlyInput*0.2;
		
	}
	
	public void endYearUpdate(){
		super.endYearUpdate();
		yearlyInput = 0;
		outtakes = 0;
	}

}
