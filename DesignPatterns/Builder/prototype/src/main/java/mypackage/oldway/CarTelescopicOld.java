package mypackage.oldway;

public class CarTelescopicOld {
	String insurance;
	Boolean etc; //electronic transfer
	String roadAssistance;
	String dropOffLocation;
	
	public CarTelescopicOld(String insurance) {
		this.insurance = insurance;
	}
	
	public CarTelescopicOld(String insurance, Boolean etc) {
		this(insurance);
		this.etc = etc;
	}
	
	public CarTelescopicOld(String insurance, Boolean etc, String roadAssistance) {
		this(insurance,etc);		
		this.roadAssistance = roadAssistance;
	}
	
	public CarTelescopicOld(String insurance, Boolean etc, String roadAssistance, String dropOffLocation) {
		this(insurance,etc,roadAssistance);	
		this.dropOffLocation = dropOffLocation;
	}

	@Override
	public String toString() {
		return "CarTelescopic1 [insurance=" + insurance + ", etc=" + etc + ", roadAssistance=" + roadAssistance
				+ ", dropOffLocation=" + dropOffLocation + "]";
	}
	
	
}
