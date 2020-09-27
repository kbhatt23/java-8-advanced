package employeeproblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Query 3.6 : Count the number of employees in each department?
public class Problem6 {
public static void main(String[] args) {
	List<Employee> employees = EmployeeUtils.fetchEmployees();
	String department="Sales And Marketing";
	System.out.println("cound of department "+department+" is: "+
			findCountUsingDepartMEntName(employees, department)
			);
	System.out.println("=====================");
	printAllDepartmnetcount(employees);
	System.out.println("total count "+employees.size()
	);
	
}

private static long findCountUsingDepartMEntName(List<Employee> employees,String department) {
	return employees.stream()
			.filter(emp -> department.equals(emp.getDepartment()))
			.count();
}

private static void printAllDepartmnetcount(List<Employee> employees) {
	Map<String, Long> deartmnetcount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	System.out.println(deartmnetcount);
}
}
