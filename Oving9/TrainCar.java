package oving9;

public class TrainCar {
	protected int deadWeight;
	
	public TrainCar(int deadWeight){
		this.deadWeight = deadWeight;
	}

	public int getDeadWeight() {
		return deadWeight;
	}
	public void setDeadWeight(int deadWeight) {
		this.deadWeight = deadWeight;
	}
	
	public int getTotalWeight(){
		if (this instanceof CargoCar){
			CargoCar a = (CargoCar) this;
			return deadWeight + a.cargoWeight;
			
		}
		else{
			PassengerCar a = (PassengerCar) this;
			return deadWeight + a.getPassengerCount()*80;
		}
	}
	
	@Override
	public String toString() {
		return "A " + this.getType() + " with a the deadweight "
				+ deadWeight;
	}
	public String getType() {
		return null;
	}



	
	

}
