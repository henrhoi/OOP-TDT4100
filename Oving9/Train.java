package oving9;

import java.util.ArrayList;
import java.util.List;

public class Train {
	
	private List<TrainCar> trainCars;
	
	public Train(){
		trainCars = new ArrayList<>();
	}
	
	public void addTrainCar(TrainCar trainCar){
		trainCars.add(trainCar);
	}
	
	public boolean contains(TrainCar trainCar){
		return trainCars.contains(trainCar);
	}
	
	public int getTotalWeight(){
		int totalWeight = 0;
		for (TrainCar trainCar : trainCars){
			totalWeight += trainCar.getTotalWeight();
		}
		return totalWeight;
	}
	
	public int getPassengerCount(){
		int passengers = 0;
		for (TrainCar ps : trainCars){
			if (ps instanceof PassengerCar){
				PassengerCar js = (PassengerCar) ps;
				passengers += js.getPassengerCount();
				
			}
		}
		return passengers;
	}
	
	public int getCargoWeight(){
		int cargoWeight = 0;
		for (TrainCar ps : trainCars){
			if (ps instanceof CargoCar){
				CargoCar js = (CargoCar) ps;
				cargoWeight += js.getCargoWeight();
				
			}
		}
		return cargoWeight;
	}
	
	public String toString(){
		String a = "";
		for (TrainCar ps : trainCars){
			a+=ps + "\n";
		}
		return a;
	}
	

	
	
	
	

}
