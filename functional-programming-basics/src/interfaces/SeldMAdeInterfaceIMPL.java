package interfaces;

public class SeldMAdeInterfaceIMPL<T> implements SelfMadeInterface<T>{
	//instance method can call interface default method and static method both
	@Override
	public void simpleMethod(T t) {
		System.out.println("class implementor implenmetation of simpleMEthod "+t);
		
		useDefault(t);
	}
	
	@Override
	public void useDefault(T t) {
		System.out.println("using custom method implementaion "+t);
	}
	//if instance is child then this gets called otherwise father one
	static <T> void useStatic(T t) {
		System.out.println("using custom static method implementation "+t);
	}

}
