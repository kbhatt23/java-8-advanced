package fluentinterfaceslazy;

import java.util.function.Function;

public class FluentOrderCreator {
public static void main(String[] args) {
	//just a template, no object is created
	//untill we cal placeorder function
	Function<Order, Order> orderFunction
		=	order -> {
		 		order.addItem("iphone");
		 		order.addItem("lenovo laptop");
		 		order.addItem("bluetooth keyboard");
		 		order.addAddress("A 901 DD flats D block janakpuri new delhi");
		 		return order;
	 		};
	 		
	Function<Order, Order> orderFunctionChaining1
	=	order -> {
	 		order.addItem("iphone");
	 		return order;
 		};
	Function<Order, Order> orderFunctionChaining2
	=	orderFunctionChaining1.andThen(order -> {
		order.addItem("lenovo laptop");
	 		return order;
 		});
	Function<Order, Order> orderFunctionChaining3
	=	orderFunctionChaining2.andThen(order -> {
		order.addItem("bluetooth keyboard");
	 		return order;
 		});

	Order.placeOrder(orderFunction);
	System.out.println("===========================");
	
	//if we were not using lazy evaluation
	//a blank order could be created and kept in JVM and that was not used to place order
	//its like creating something and was not useful
	//Order.placeOrder(orderFunctionChaining3);
}

}
