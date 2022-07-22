package mypackage;

public class NBT extends Handler{

	@Override
	public double applyTax(Invoice invoice) {
		invoice.setTax(invoice.getAmount()+invoice.getAmount()*0.02);
		System.out.println("NBT is calculated");
		
		if(invoice.getAmount()>100.00 && invoice.getAmount()<=200.0) {
			return invoice.getTax(); //stop adding other taxes
		}else {
			return successor.applyTax(invoice); //add more taxes
		}
		
		
	}
	
}
