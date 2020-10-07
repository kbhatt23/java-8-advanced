package employeeproblems;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import common.Student;

public class EmployeeNameWithMaxSalary {
public static void main(String[] args) {
	List<Employee> employees = EmployeeUtils.fetchEmployees();
	
	//method 1
	String name1 = employees.stream()
			 .max(Comparator.comparing(Employee::getSalary))
			 .map(Employee::getName)
			 .orElse("kuch nahi hai");
	System.out.println(name1);
	
	//method2
	String name2 = employees.stream()
			.collect(Collectors.collectingAndThen(
					Collectors.maxBy(Comparator.comparing(Employee::getSalary))
					,
					a ->{
						Optional<Employee> emp = (Optional<Employee>)a;
						return emp.map(Employee::getName).orElse("kuch nahi hai");
					}
					));
	System.out.println(name2);
	
	
}
}
