import mypackage.Package;
import mypackage.PackageCode;
import mypackage.PackageFactory;

public class Application {

	public static void main(String[] args) {
		Package p1 = PackageFactory.createPackage(PackageCode.BASIC);
		System.out.println(p1);

		Package p2 = PackageFactory.createPackage(PackageCode.PLATINUM);
		System.out.println(p2);
	}

}
