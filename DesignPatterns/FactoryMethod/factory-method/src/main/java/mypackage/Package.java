package mypackage;

import java.util.ArrayList;
import java.util.List;

public abstract class Package {
	
	protected List<Decoration> decorations=new ArrayList<>();
	
	//this is the abstract method that will be used to change as needed
	protected abstract void createPackage();
	
	public Package() {
		createPackage();
	}
	
	
	
	@Override
	public String toString() {
		return "Package{"+"decorations= "+decorations+"}";
	}
}
