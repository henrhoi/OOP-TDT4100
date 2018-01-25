package oving9;

public class DebitAccount extends AbstractAccount{
	
	public DebitAccount(){
		super();
	}

	@Override
	public void internalWithdraw(double n) {
		if(super.balance-n >=0){
			super.balance -= n;			
		}else{
		throw new IllegalStateException("Ikke lov å ha negativt på kontoen");}
	}
	
	
	
	

}
