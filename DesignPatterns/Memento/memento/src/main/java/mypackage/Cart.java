package mypackage;

import java.util.ArrayList;

//the originator
//the cart will have an itemm
public class Cart {
	
	ArrayList<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item) {
		items.add(item);
	}

	public ArrayList<Item> getItems() {
		//to give immutability 
		//because the next modification shouldn't change taken object (through references)
		return (ArrayList<Item>)items.clone(); 
	}
	
	//for saving
	public CartMemento save() {
		//create a new cart object, using the current cart
		return new CartMemento(getItems()); 
	}
	
	//for reverting
	public void revert(CartMemento cartMemento) {
		items=cartMemento.getItems();
	}
	
	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

	
	static class CartMemento{
		ArrayList<Item> items;
		
		public CartMemento(ArrayList<Item> items) {
			this.items=items;
		}
		
		//only cart can access this method
		private ArrayList<Item> getItems(){
			return items;
		}
	}
	
}
