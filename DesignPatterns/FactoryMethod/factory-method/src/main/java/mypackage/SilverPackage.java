package mypackage;

public class SilverPackage extends Package {

	@Override
	protected void createPackage() {
		decorations.add(new BridalDeco());
		decorations.add(new BrideMaidDeco());
	}

}
