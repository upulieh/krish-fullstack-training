package mypackage;

public class SSF extends Handler{

	@Override
	public double applyTax(Invoice invoice) {
		invoice.setTax(invoice.getAmount()+invoice.getAmount()*0.04);
		System.out.println("SSF is calculated");
		return invoice.getTax(); //final tax
	}
}
