package employeeproblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Query 3.12 : List down the names of all employees in each department?
public class Problem12 {
public static void main(String[] args) {
	List<Employee> employees = EmployeeUtils.fetchEmployees();
	Map<String, List<String>> collect = employees.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment
					,Collectors.mapping(Employee::getName, Collectors.toList())
					));
	

	collect.entrySet()
			.forEach(e -> {
				System.out.println("Employees in department: "+e.getKey());
				e.getValue().forEach(System.out::println);
				System.out.println("==========================");
			});
}
}
