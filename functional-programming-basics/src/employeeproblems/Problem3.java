package employeeproblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Query 3.3 : What is the average age of male and female employees?
public class Problem3 {
public static void main(String[] args) {
	List<Employee> employees = EmployeeUtils.fetchEmployees();
	
	Map<String, Double> avgMap =employees.stream()
			 .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
	
	avgMap.forEach((a,b) -> System.out.println(a+" : "+b));
}
}
