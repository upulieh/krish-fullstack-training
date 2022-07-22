import mypackage.newway.Car;
import mypackage.oldway.CarTelescopicOld;

public class Application {

	public static void main(String[] args) {
		//old way
		CarTelescopicOld carTelescopicOld1=new CarTelescopicOld("full");
		System.out.println(carTelescopicOld1);

		CarTelescopicOld carTelescopicOld2=new CarTelescopicOld("full");
		System.out.println(carTelescopicOld2);
		
		//builder pattern way
		//limited the number of constructors
		//no setters(guarantees immutability)
		//you don't need to pass null parameters for the values you don't need 
		//eg: java string builder
		Car.Builder builder=new Car.Builder("full"); //required param
		Car car=builder.dropOffLocation("Colombo").roadAssistance("full").build();
		System.out.println(car);
	}

}
