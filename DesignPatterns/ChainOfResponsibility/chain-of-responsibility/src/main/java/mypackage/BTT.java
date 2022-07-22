package mypackage;

public class BTT extends Handler{

	@Override
	public double applyTax(Invoice invoice) {
		invoice.setTax(invoice.getAmount()+invoice.getAmount()*0.03);
		System.out.println("BTT is calculated");
		
		if(invoice.getAmount()>200.00 && invoice.getAmount()<=300.0) {
			return invoice.getTax(); //stop adding other taxes
		}else {
			return successor.applyTax(invoice); //add more taxes
		}
		
		
	}
	
}
