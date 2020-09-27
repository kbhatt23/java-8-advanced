package methodreference;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import common.Student;
import common.StudentDataBase;

public class BiConsumerMethodReferenceUsage {

	private static BiConsumer<String,String> printconsumer1 =BiConsumerMethodReferenceUsage::printAndconsume1;
	
	private static BiConsumer<Integer,Integer> printconsumer2 =BiConsumerMethodReferenceUsage::printAndconsume2;
	
	private static Consumer<Student> selfObtainedconsumer = Student::consumeKing;

	public static void printAndconsume1(String s ,String s2) {
		System.out.println(s + ","+s2);
	}

	public static void printAndconsume2(Integer s, Integer s2) {
		System.out.println(s+s2);
	}
	
	public  void printAndconsume1Instnce(String s , String s2) {
		System.out.println(s+","+s2);
	}

	public  void printAndconsume2Instnce(Integer s,Integer s2) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		printconsumer1.accept("jai shree ram" , "jai radha madhav");
		printconsumer2.accept(108,108);
		
		System.out.println("==============");
		StudentDataBase.getAllStudents().forEach(selfObtainedconsumer);
		System.out.println("==============");
		StudentDataBase.getAllStudents().forEach(Student::consumeKing);
		System.out.println("==============");
		BiConsumerMethodReferenceUsage obj = new BiConsumerMethodReferenceUsage();
		BiConsumer<String,String> printconsumer1 =obj::printAndconsume1Instnce;
		
		BiConsumer<Integer,Integer> printconsumer2 =obj::printAndconsume2Instnce;
		printconsumer1.accept("jai sita ram","jai ramaduta hanuman" );
		printconsumer2.accept(7,101);
	}
}
