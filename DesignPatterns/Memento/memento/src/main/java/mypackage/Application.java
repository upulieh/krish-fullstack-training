package mypackage;

public class Application {

	public static void main(String[] args) {
		
		CareTaker careTaker=new CareTaker();
		Cart cart=new Cart();
		
		//user adds few items to the cart
		cart.addItem(new Item("book"));
		cart.addItem(new Item("pen"));
		
		//user saves cart state
		careTaker.save(cart); //1
		System.out.println(cart);
		
		cart.addItem(new Item("bottle"));
		
		//user saves cart state
		careTaker.save(cart); //2
		System.out.println(cart); //prints version1 of the cart
		
		cart.addItem(new Item("shoe"));
		
		//user saves cart state
		careTaker.save(cart); //3
		System.out.println(cart); //prints version2 of the cart
		
		cart.addItem(new Item("rug"));
		
		//user saves cart state
		careTaker.save(cart); //4
		System.out.println(cart); //prints version2 of the cart
		
		careTaker.revert(cart);//undo the final add
		System.out.println(cart); //prints version3 of the cart
		
		//user saves cart state
		careTaker.revert(cart);//undo the final add
		System.out.println(cart); //prints version4 of the cart
		
		//user saves cart state
		careTaker.revert(cart);//undo the final add
		System.out.println(cart); //prints version4 of the cart
		
		//user saves cart state
		careTaker.revert(cart);//undo the final add
		System.out.println(cart); //prints version4 of the cart
		
		//user saves cart state
		careTaker.revert(cart);//undo the final add
		System.out.println(cart); //prints version4 of the cart
		
	}

}
