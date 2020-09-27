package employeeproblems;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Query 3.11 : What is the average salary of male and female employees?
public class Problem11 {


	public static void main(String[] args) {
		List<Employee> employees = EmployeeUtils.fetchEmployees();
		usingFilters(employees, EmployeeUtils.FEMALE);
		usingFilters(employees, EmployeeUtils.MALE);
		System.out.println("===================");
		
		usingCollectors(employees);
	}
	
	private static void usingFilters(List<Employee> employees, String gender) {
		Predicate<Employee> filter = EmployeeUtils.FEMALE.equals(gender) ? EmployeeUtils.isEmployeeFemalePredicate:EmployeeUtils.isEmployeeFemalePredicate.negate() ;
		double avg= employees.stream()
										.filter(filter)
										.mapToDouble(Employee::getSalary)
										.average()
										.orElseThrow(RuntimeException::new)
										;
				System.out.println("average slaary of "+gender+" is "+avg);
	}
	
	private static void usingCollectors(List<Employee> employees) {
		Map<String,Double> avg= employees.stream()
						.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))
				;
		System.out.println(avg);
	}
}
