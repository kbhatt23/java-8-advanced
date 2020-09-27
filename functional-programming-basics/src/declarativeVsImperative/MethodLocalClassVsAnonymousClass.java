package declarativeVsImperative;

public class MethodLocalClassVsAnonymousClass {
public static void main(String[] args) {
	MethodLocalClassVsAnonymousClass la = new MethodLocalClassVsAnonymousClass();
	la.manipulate();
}

public void manipulate() {
	//,method local class have name and hence we can create objects multiple times within this method only
	//as usual scope is within braces only whihs is inisde this method only
	class MethodLocal implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
		public void fakeNEw() {
			System.out.println("jai shree ram from fake");
		}
		
	}
	
	MethodLocal la = new MethodLocal();
	//even newwer methods can be created and consumed
	la.fakeNEw();
	
	Runnable r = new Runnable() {
		public void run() {
			fakeNEw();
		}
		public void fakeNEw() {
			System.out.println("jai shree ram from fake");
		}
	};
	//can not be used outside the annoymous inner class
	//r.fakeNEw();
	new Thread(r).start();
	
	Runnable r1 = () -> System.out.println("jai shree ram \n"
			+ "jai mata sita"
			+ "jai rama duta hanumna"
			+ "jai shree radhe"
			+ "ia radhe shyam");
	new Thread(r1).start();
	
}
}
