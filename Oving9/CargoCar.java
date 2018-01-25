package oving9;

public class CargoCar extends TrainCar {
	protected int cargoWeight;
	
	public CargoCar(int deadWeight, int cargoWeight){
		super(deadWeight); //Starter en nedarvet konstruktør
		this.cargoWeight = cargoWeight;
	}



	public int getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(int cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	
	
	@Override
	public String toString() {
		return super.toString() +" and a cargoweight of "+ cargoWeight;
	}



	public int getTotalWeight() {
		return super.deadWeight + cargoWeight;
	}
	

	@Override
	public String getType() {
		return "cargo car";
	}
	
	

}
