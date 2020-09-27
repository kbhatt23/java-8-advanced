package methodreference;

import java.util.function.Supplier;

import common.Student;

public class SupplierMethodReferenceUSage {
	private static Supplier<String> suplier1 = SupplierMethodReferenceUSage::findString;
	private Supplier<String> supplier2 = this::findStringInstance;
	// self made usage
	private Supplier<Student> suplierSelfMade = Student::new;

	public static void main(String[] args) {
		System.out.println(suplier1.get());
		SupplierMethodReferenceUSage obj = new SupplierMethodReferenceUSage();
		System.out.println(obj.supplier2.get());

	}

	private static String findString() {
		return "jai shree ram";
	}

	private String findStringInstance() {
		return "jai shree ram";
	}
}
