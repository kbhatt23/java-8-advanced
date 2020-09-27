package employeeproblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import employeeproblems.Employee;

//Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
public class Problem14 {
	public static void main(String[] args) {
		List<Employee> employees = EmployeeUtils.fetchEmployees();

		Map<Boolean, List<String>> collect = employees.stream().collect(Collectors.partitioningBy(
				EmployeeUtils.isGreaterThan25.negate(), Collectors.mapping(Employee::getName, Collectors.toList())));

		collect.entrySet().forEach(e -> {
			System.out.println("Employees with key " + e.getKey());
			e.getValue().forEach(System.out::println);
			System.out.println("==========================");
		});
	}
}
