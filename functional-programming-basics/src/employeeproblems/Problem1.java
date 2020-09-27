package employeeproblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Query 3.1 : How many male and female employees are there in the organization?
public class Problem1 {

	public static void main(String[] args) {
		List<Employee> employees = EmployeeUtils.fetchEmployees();
		findUsingFilter(employees);
		System.out.println("==========================");
		findUsingCollector(employees);
	}

	private static void findUsingFilter(List<Employee> employees) {
		long maleCount = employees
		 .stream()
		 .filter(EmployeeUtils.isEmployeeFemalePredicate.negate())
		 .count()
		 ;		
		
		long femmaleCount = employees
				 .stream()
				 .filter(EmployeeUtils.isEmployeeFemalePredicate)
				 .count()
				 ;	
		System.out.println("findUsingFilter->maleCount: "+maleCount);
		System.out.println("findUsingFilter->femmaleCount: "+femmaleCount);
	}
	
	private static void findUsingCollector(List<Employee> employees) {
		Map<String, Long> countMap =employees.stream()
				 .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("findUsingCollector->maleCount: "+countMap.get(EmployeeUtils.MALE));
		System.out.println("findUsingCollector->femmaleCount: "+countMap.get(EmployeeUtils.FEMALE));
	}
}
