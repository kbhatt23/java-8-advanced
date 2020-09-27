package employeeproblems;

import java.util.List;
import java.util.stream.Collectors;

//Query 3.5 : Get the names of all employees who have joined after 2015?
public class Problem5 {
	public static void main(String[] args) {
		List<Employee> employees = EmployeeUtils.fetchEmployees();
		printUsingCollect(employees);
		System.out.println("====================");
		printUsingFilterAndMap(employees);
	}

	private static void printUsingCollect(List<Employee> employees) {
		List<String> names = employees.stream().filter(EmployeeUtils.hasJoinedAfter2015)
				.collect(Collectors.mapping(Employee::getName, Collectors.toList()));
		names.forEach(System.out::println);
	}
	
	private static void printUsingFilterAndMap(List<Employee> employees) {
		List<String> names = employees.stream().filter(EmployeeUtils.hasJoinedAfter2015)
								.map(Employee::getName)
								.collect(Collectors.toList());
						
				names.forEach(System.out::println);
	}
}
