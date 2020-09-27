package employeeproblems;

import java.util.List;
import java.util.stream.Collectors;

public class Problem13 {
public static void main(String[] args) {
	List<Employee> employees = EmployeeUtils.fetchEmployees();
	
	double average = employees.stream()
			.collect(Collectors.averagingDouble(Employee::getSalary))
			;
	double total = employees.stream()
			.collect(Collectors.summingDouble(Employee::getSalary))
			;
	System.out.println(average);
	System.out.println(total);
}
}
