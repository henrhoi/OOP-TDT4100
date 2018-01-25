package oving9;

public class CreditAccount extends AbstractAccount{
	
	private double creditLine;
	
	public CreditAccount(double creditLine){
		super();
		this.setCreditLine(creditLine);
	}

	@Override
	public void internalWithdraw(double n) {
		if (n<0){
			throw new IllegalStateException("Balancen cannot exceed the creditline");
		}
		else if (super.balance - n < creditLine*(-1)){
			throw new IllegalStateException("Balancen cannot exceed the creditline");
		}
		super.balance -= n;	
		
	}

	public double getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(double creditLine) {
		if (super.balance < 0){
			if(creditLine < super.balance){
				this.creditLine = creditLine;
			}
			throw new  IllegalStateException("CreditLine must be lower than balance");
		}
		else if (creditLine >= 0){
			this.creditLine = creditLine;			
		}
		else{throw new IllegalArgumentException("Må være større eller lik 0");}
	}


}
