package mypackage.newway;

public class Car {
	private final String insurance;
	private final Boolean etc; //electronic transfer
	private final String roadAssistance;
	private final String dropOffLocation;
	
	public Car(Builder builder) {
		this.insurance=builder.insurance;
		this.etc=builder.etc;
		this.roadAssistance=builder.roadAssistance;
		this.dropOffLocation=builder.dropOffLocation;
	}
	
	//inner class
	public static class Builder{
		String insurance;
		Boolean etc; //electronic transfer
		String roadAssistance;
		String dropOffLocation;
		
		public Car build() {
			return new Car(this);
		}
		
		//to enforce a required parameter, add it to the parameter list on the constructor
		public Builder(String insurance) {
			this.insurance=insurance;
		}
		
		//create the rest of the methods,
		//where each method will set the particular parameter and return the same object
		public Builder etc(Boolean etc) {
			this.etc=etc;
			return this;
		}
		public Builder roadAssistance(String roadAssistance) {
			this.roadAssistance=roadAssistance;
			return this;
		}
		public Builder dropOffLocation(String dropOffLocation) {
			this.dropOffLocation=dropOffLocation;
			return this;
		}	
		
	}

	@Override
	public String toString() {
		return "Car [insurance=" + insurance + ", etc=" + etc + ", roadAssistance=" + roadAssistance
				+ ", dropOffLocation=" + dropOffLocation + "]";
	}
	
}
