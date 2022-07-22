package mypackage;

public class PackageFactory {
	
	public static Package createPackage(PackageCode packageCode) {
		
		//return the package based on the given code
		switch(packageCode) {
			case BASIC:
				return new BasicPackage();
			case SILVER:
				return new SilverPackage();
			case PLATINUM:
				return new PlatinumPackage();
			default:
				return null;
		}
	}
}
