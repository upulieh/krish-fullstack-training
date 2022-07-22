package mypackage;

public abstract class Handler {
	//handler should know about its successor
	protected Handler successor;
	
	public void setSuccessor(Handler successor) {
		this.successor=successor;
	}
	
	//tax depends on the scenario
	public abstract double applyTax(Invoice invoice);
	
	
}
