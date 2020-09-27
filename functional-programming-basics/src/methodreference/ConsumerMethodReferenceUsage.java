package methodreference;

import java.util.function.Consumer;

import common.Student;
import common.StudentDataBase;

public class ConsumerMethodReferenceUsage {

	private static Consumer<String> printconsumer1 =ConsumerMethodReferenceUsage::printAndconsume1;
	
	private static Consumer<Integer> printconsumer2 =ConsumerMethodReferenceUsage::printAndconsume2;
	
	private static Consumer<Student> selfObtainedconsumer = Student::consumeKing;

	public static void printAndconsume1(String s) {
		System.out.println(s);
	}

	public static void printAndconsume2(Integer s) {
		System.out.println(s);
	}
	
	public  void printAndconsume1Instnce(String s) {
		System.out.println(s);
	}

	public  void printAndconsume2Instnce(Integer s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		printconsumer1.accept("jai shree ram");
		printconsumer2.accept(108);
		
		System.out.println("==============");
		StudentDataBase.getAllStudents().forEach(selfObtainedconsumer);
		System.out.println("==============");
		StudentDataBase.getAllStudents().forEach(Student::consumeKing);
		System.out.println("==============");
		ConsumerMethodReferenceUsage obj = new ConsumerMethodReferenceUsage();
		Consumer<String> printconsumer1 =obj::printAndconsume1Instnce;
		
		Consumer<Integer> printconsumer2 =obj::printAndconsume2Instnce;
		printconsumer1.accept("jai ramaduta hanuman");
		printconsumer2.accept(7);
	}
}
