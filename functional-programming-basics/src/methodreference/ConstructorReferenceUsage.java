package methodreference;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import common.Student;
import common.StudentDataBase;

public class ConstructorReferenceUsage {

	private int property1;
	private String property2;

	private int la = 23;
	public ConstructorReferenceUsage() {
	}

	public ConstructorReferenceUsage(int property1, String property2) {
		this.property1 = property1;
		this.property2 = property2;
	}

	public ConstructorReferenceUsage(String property2) {
		this.property2 = property2;
	}

	@Override
	public String toString() {
		return "ConstructorReferenceUsage [property1=" + property1 + ", property2=" + property2 + "]";
	}

	public ConstructorReferenceUsage(int property1) {
		this.property1 = property1;
	}

	private static Supplier<ConstructorReferenceUsage> noArgSuppleir = ConstructorReferenceUsage::new;

	public static void main(String[] args) {

		int nalelea = 23;
		String kaa="23";
		Integer la = 99;
//		nalelea=99;
		Function<String, Integer> ka = s -> {
			//effectively final
			// nalelea=29;
			//kaa = "99";
			//la=23;
			return s.length() + nalelea;
		};

//		nalelea=99;
		
		System.out.println(ka.apply("jai shree rama"));
		// consturcto refernce -> constructor acts same as method
		System.out.println(noArgSuppleir.get());
		Function<String, ConstructorReferenceUsage> constructo1 = ConstructorReferenceUsage::new;
		System.out.println(constructo1.apply("jia shree ram"));

		Function<Integer, ConstructorReferenceUsage> constructo2 = ConstructorReferenceUsage::new;
		System.out.println(constructo2.apply(23));

		BiFunction<Integer, String, ConstructorReferenceUsage> constructo22 = ConstructorReferenceUsage::new;
		System.out.println(constructo22.apply(99, "jai shree ram"));

		System.out.println("==========");

		StudentDataBase.getAllStudents().forEach(System.out::println);
		
		System.out.println("===================================");
		new ConstructorReferenceUsage().mehotdCool();
		
		
	}
	void mehotdCool() {
		Function<String, Integer> ka = s -> {
			// nalelea=29;
			la=99;
			return s.length() + la;
		};
		
		Function<String, Integer> ka1 =new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				la=108;
				return la+t.length();
			}
		};

		System.out.println(ka.apply("keshava"));
		System.out.println(ka1.apply("keshava"));
		
		//scope of variable
	
		
		Consumer<Integer> con = (messi1) ->{
			System.out.println(messi1+10);
		};
		int messi =10;
		int messi1 =99;
		con.accept(10);
		System.out.println(messi+messi1);
	}
	
	
	
}
