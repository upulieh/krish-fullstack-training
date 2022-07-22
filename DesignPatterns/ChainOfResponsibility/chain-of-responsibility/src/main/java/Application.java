import logexample.Example;
import mypackage.BTT;
import mypackage.Invoice;
import mypackage.NBT;
import mypackage.SSF;
import mypackage.Tax;
import mypackage.VAT;

public class Application {

	public static void main(String[] args) {
		//sample demo from java 
		Example example1 = new Example();
		example1.myMethod();
		
		//custom demo
		//to make naming less complex a new class called Tax is used
		//so the chain is, Tax->VAT->NBT->BTT->SSF (for an invoice higher than 300)
		Tax tax=new Tax();
		VAT vat=new VAT();
		NBT nbt=new NBT();
		BTT btt=new BTT();
		SSF ssf=new SSF();
		
		//Tax.successor is VAT
		tax.setSuccessor(vat);
		vat.setSuccessor(nbt);
		nbt.setSuccessor(btt);
		btt.setSuccessor(ssf);
		
		Invoice invoice0 = new Invoice(1,50);
		System.out.println(tax.applyTax(invoice0));
		
		Invoice invoice1 = new Invoice(2,150);
		System.out.println(tax.applyTax(invoice1));

		Invoice invoice2 = new Invoice(3,250);
		System.out.println(tax.applyTax(invoice2));
		
		Invoice invoice3 = new Invoice(4,450);
		System.out.println(tax.applyTax(invoice3));
		
		Invoice invoice4 = new Invoice(5,550);
		System.out.println(tax.applyTax(invoice4));
	}

}
