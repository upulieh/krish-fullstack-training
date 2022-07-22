package mypackage;

public class PlatinumPackage extends Package {

	@Override
	protected void createPackage() {
		decorations.add(new BridalDeco());
		decorations.add(new BrideMaidDeco());
		decorations.add(new FlowerGirlDeco());
	}

}
