package employeeproblems;

import java.util.Comparator;
import java.util.List;

//Query 3.8 : Get the details of youngest male employee in the product development department?
public class Problem8 {

	public static void main(String[] args) {
		List<Employee> employees = EmployeeUtils.fetchEmployees();
		usingSorting(employees);
		System.out.println("===============");
		usingMin(employees);
	}
	
	private static void usingSorting(List<Employee> employees) {
		Employee empYoungest = employees.stream()
				 .filter(EmployeeUtils.isEmployeeFemalePredicate.negate())
				 .filter(e -> "Product Development".equals(e.getDepartment()))
				 .sorted(Comparator.comparing(Employee::getAge))
				 //very bad as it breks the stream whihc goes one by one 
				 .findFirst()
				 .orElseThrow(RuntimeException::new);
		System.out.println(empYoungest);
	}
	

	private static void usingMin(List<Employee> employees) {
		Employee empYoungest = employees.stream()
				 .filter(EmployeeUtils.isEmployeeFemalePredicate.negate())
				 .filter(e -> "Product Development".equals(e.getDepartment()))
				 .min(Comparator.comparing(Employee::getAge))
				 .orElseThrow(RuntimeException::new);
		System.out.println(empYoungest);
	}
}
