package mypackage;

public class VAT extends Handler{

	@Override
	public double applyTax(Invoice invoice) {
		invoice.setTax(invoice.getAmount()+invoice.getAmount()*0.01);
		System.out.println("VAT is calculated");
		
		if(invoice.getAmount()<=100) {
			return invoice.getTax(); //stop adding other taxes
		}else {
			return successor.applyTax(invoice); //add more taxes
		}
		
		
	}
	
}
