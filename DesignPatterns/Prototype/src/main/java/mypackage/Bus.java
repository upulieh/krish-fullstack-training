package mypackage;

public class Bus extends Vehicle {
	private int numberOfSeats;

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		return "Bus [numberOfSeats=" + numberOfSeats + "]";
	}
	
}
