package mypackage;

import java.util.Stack;

//the caretaker (holds the state of the previous object)
//follows as, last in first out (as a stack) 
public class CareTaker {
	
	Stack<Cart.CartMemento> history = new Stack<Cart.CartMemento>();
	
	//caretaker has to save the cart state
	public void save(Cart cart) {
		history.push(cart.save());
	}
	
	//caretaker has to rever the cart state
	public void revert(Cart cart) {
		//if the stack is not empty, remove the last item
		if(!history.isEmpty()) {
			cart.revert(history.pop());
		}else {
			System.out.println("Cannot undo as nothing is done");
		}
	}
	
}
