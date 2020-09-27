package interfaces;
@FunctionalInterface
public interface SelfMadeInterface<T> {

	void simpleMethod(T t);
	//will be used by anoy implmentaion class
	//also cna be called using object of implenenation class
	//not possible to keep protected -> kindly use abstract class for that 
	/* protected */ default void useDefault(T t) {
		System.out.println("using default method implementaion "+t);
		//can call static metho dedined in interface
		//useStatic(t);
		
	}
	//can only be used statically only, 
	//can not be called form instnace method of impl class or object 
	//can be ued only within static method of impl classes
	//inside static <T > defined at class generic wotn be available
	static <T> void useStatic(T t) {
		System.out.println("using static method implementation "+t);
	}
}
