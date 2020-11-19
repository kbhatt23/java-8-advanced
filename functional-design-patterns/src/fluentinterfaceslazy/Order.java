package fluentinterfaceslazy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Order {
	//wud be using table startegy or seuqnece generator instead of this
	private static int LAST_ORDER_ID = 0;
	private int id;
	
	private Order() {
		//randomly generate the orde here -> could have been using jpa to autogenerate the order
		id = ++LAST_ORDER_ID;
	}
	
	//as of now adding string,
	//could have been Item java bean having its properties
	private List<String> items;
	

	//could have been seperate bean
	private String address;

	public void addItem(String item) {
		if(items==null) {
			items=new ArrayList<String>();
		}
		//could have validation for item
		System.out.println(String.format("Adding item %s to order %s", item,id));
		items.add(item);
	}
	
	public void addAddress(String address) {
		//could have validation for address
		System.out.println(String.format("Adding address %s to order %s", address,id));
		this.address=address;
	}
	
	
	//an order do not have value until we actually place order
	//lazy creation helps here, we o not create order object until we place order
	public static void placeOrder(Function<Order, Order> orderFunction) {
		Order order = new Order();
		//triggers the orderFunction pipeline
		orderFunction.apply(order);
		System.out.println(String.format("Succesfully placed order: %s",order.id));
		//we could return Order but better to keep in session, current order field in session
	}
	
	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}
}
