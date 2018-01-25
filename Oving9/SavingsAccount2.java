package oving9;

public class SavingsAccount2 extends AbstractAccount{
	
	private int withdrawals;
	private int maxWithdrawals;
	private double fee;
	
	public SavingsAccount2(int maxWithdrawals, double fee){
		super();
		this.maxWithdrawals = maxWithdrawals;
		this.withdrawals = 0;
		this.fee = fee;
	}

	@Override
	public void internalWithdraw(double n) {
		if (withdrawals >= maxWithdrawals){
			if(super.balance-n-fee >=0){
				super.balance = super.balance -n-fee;			
			}else{
			throw new IllegalStateException("Ikke lov å ha negativt på kontoen");}
		}
		else{
			if (super.balance-n >=0){
				super.balance -= n;	
				this.withdrawals ++;
			}
			else{
			throw new IllegalStateException("Ikke lov å ha negativt på kontoen");}
		}
			
		
	}

}
