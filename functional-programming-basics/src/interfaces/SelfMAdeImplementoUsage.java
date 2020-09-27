package interfaces;

public class SelfMAdeImplementoUsage {
public static void main(String[] args) {

	SelfMadeInterface<String> kaStr = new SeldMAdeInterfaceIMPL<>();
	//we can call abstract method
	kaStr.simpleMethod("jai shree ram");
	
	//we can still call instnace method(default method)
	System.out.println("=======================");
	kaStr.useDefault("jai radha madhav");
	
	//we cna not call static method of interface
	//static methods can only be used on interface static level
	System.out.println("=======================");
	SelfMadeInterface.useStatic("jai shree ram");
	
	System.out.println("==============");
	SeldMAdeInterfaceIMPL.useStatic("jai shiva shankar");
}
}
