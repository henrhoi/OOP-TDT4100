package oving9;

public class PassengerCar extends TrainCar{
	private int passengerCount;
	
	public PassengerCar(int deadWeight, int passengerCount){
		super(deadWeight);
		// TODO Auto-generated constructor stub
		this.passengerCount = passengerCount;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int n) {
		if (n >= 0){
			passengerCount = n;
		}
	}

	@Override
	public String getType() {
		return "dining car";
	}
	
	public int getTotalWeight() {
		return super.deadWeight + (passengerCount*80);
	}

}
