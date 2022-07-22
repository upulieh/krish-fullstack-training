package mypackage;

public class Invoice {
	private int invoiceNumber;
	private double amount;
	private double tax;
	
	public Invoice(int invoiceNumber, double amount) {
		this.invoiceNumber = invoiceNumber;
		this.amount = amount;
	}
	
	//only tax has a setter
	protected void setTax(double tax) {
		this.tax=tax;
	}

	//all fields have getters
	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public double getAmount() {
		return amount;
	}

	public double getTax() {
		return tax;
	}
	
}
