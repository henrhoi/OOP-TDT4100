package oving9;

public abstract class AbstractAccount {
	
	protected double balance;
	
	public AbstractAccount(){
		this.balance = 0;
	}
	
	public void deposit(double n){
		if (n<=0){
			throw new IllegalArgumentException("Beløpet må være positivt");
		}
		if(n>0){
			this.balance += n;			
		}else{
		throw new IllegalArgumentException("Beløpet må være positivt");}
	}
	
	public void withdraw(double n){
		if (n<=0){
			throw new IllegalArgumentException("Beløpet må være positivt");
		}
		if(n>0){
			internalWithdraw(n);			
		}else{
		throw new IllegalStateException("Beløpet må være positivt");}
	}
	
	public abstract void internalWithdraw(double n);
	
	public double getBalance(){
		return this.balance;
	}
	
	
	
	

}
