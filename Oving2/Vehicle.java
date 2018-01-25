package oving2;

public class Vehicle {
	
	private char VehicleType;
	private char FuelType;
	private String RegistrationNumber;
	
	private String FuelTypes = "HEDG";
	private String LegalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	
	
	

	public Vehicle(char VehicleType, char FuelType, String RegistrationNumber) throws IllegalArgumentException{
		if ((VehicleType != 'M') && (VehicleType!='C')){
			throw new IllegalArgumentException("Must be a car or motorcycle");
		}
		else if (FuelTypes.indexOf(FuelType) == -1){
			throw new IllegalArgumentException("Select a valid fuel");
		}
			
		else{
			this.VehicleType=VehicleType;
			this.FuelType=FuelType;
		}
		setRegistrationNumber(RegistrationNumber);
	}
	

	public String getRegistrationNumber() {
		return RegistrationNumber;
	}

	public void setRegistrationNumber(String RegistrationNumber)throws IllegalArgumentException {
		 if ((!(RegistrationNumber.length() == 7) && (VehicleType == 'C')) || (!(RegistrationNumber.length() == 6) && (VehicleType == 'M'))){
			throw new IllegalArgumentException("Regnum is not correct length");
		}
		 
		else if ((LegalLetters.indexOf(RegistrationNumber.charAt(0)) == -1) ||    
				(LegalLetters.indexOf(RegistrationNumber.charAt(1)) == -1)){
			throw new IllegalArgumentException("Regnum must start with two letters");
		}
		else if ((VehicleType=='M') && (!(RegistrationNumber.substring(2).matches("[0-9]+")))){
			throw new IllegalArgumentException("Regnum must contain 4 numbers");
		}
		else if ((VehicleType=='C') && (!(RegistrationNumber.substring(2).matches("[0-9]+")))){
			throw new IllegalArgumentException("Regnum must contain 5 numbers");
		}
		
		else if (((VehicleType == 'M') && RegistrationNumber.length() == 7) || ((VehicleType == 'C') && RegistrationNumber.length() == 6)){
			throw new IllegalArgumentException("You have not the right regnum for your vehicle.");
		}
		else if ((FuelType == 'E') && !(RegistrationNumber.startsWith("EL") || RegistrationNumber.startsWith("EK"))){
			throw new IllegalArgumentException("Regnum must start with 'EL' or 'EK'");
		}
		else if (!(FuelType == 'E') && (RegistrationNumber.startsWith("EL") || RegistrationNumber.startsWith("EK"))){
			throw new IllegalArgumentException("Regnum can´t start with 'EL' or 'EK'");
		}
		else if (((FuelType == 'D') || (FuelType == 'G')) && (RegistrationNumber.startsWith("EL") || RegistrationNumber.startsWith("EK")
				|| RegistrationNumber.startsWith("HY"))){
			throw new IllegalArgumentException("Regnum can not start with 'EL' or 'EK' or 'HY'");
		}
		else if ((FuelType == 'H') && !(RegistrationNumber.startsWith("HY"))){
			throw new IllegalArgumentException("Regnum must start with 'HY'");
		}
		else if (!(FuelType == 'H') && (RegistrationNumber.startsWith("HY"))){
			throw new IllegalArgumentException("Regnum must can´t start with 'HY'");
		}
		else if (RegistrationNumber.substring(0,2).contains("[A-Z]+")){
			throw new IllegalArgumentException("Unvalid letters");
		}
		 
		else if((VehicleType == 'M') && RegistrationNumber.startsWith("HY")){
			throw new IllegalArgumentException("Motorcycle can not go on Hydrogen");
		}
		
		else{
			this.RegistrationNumber = RegistrationNumber;
		}
		
	}

	public char getVehicleType() {
		return VehicleType;
	}

	public char getFuelType() {
		return FuelType;
	}
	
	
	
}
