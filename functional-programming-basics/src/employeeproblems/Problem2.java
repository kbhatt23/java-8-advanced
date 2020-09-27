package employeeproblems;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Query 3.2 : Print the name of all departments in the organization?
public class Problem2 {

	public static void main(String[] args) {
		List<Employee> employees = EmployeeUtils.fetchEmployees();
		printDepartmentsUsingConsumer(employees);
		System.out.println("=============");
		printDepartmentsUsingCollector1(employees);
		System.out.println("=============");
		printDepartmentsUsingCollector2(employees);
	}
	
	private static void printDepartmentsUsingConsumer(List<Employee> employees) {
		employees.stream()
				 .map(Employee::getDepartment)
				 .distinct()
				 .forEach(System.out::println);
	}

	private static void printDepartmentsUsingCollector1(List<Employee> employees) {
		List<String> collect = employees.stream()
				 .map(Employee::getDepartment)
				 .distinct()
				 .collect(Collectors.toList());
		collect.forEach(System.out::println);
	}
	private static void printDepartmentsUsingCollector2(List<Employee> employees) {
		Set<String> collect = employees.stream()
				 .map(Employee::getDepartment)
				 //.distinct()
				 .collect(Collectors.toCollection(LinkedHashSet::new));
		collect.forEach(System.out::println);
	}

}
