package employeeproblems;

import java.util.Comparator;
import java.util.List;

//Query 3.9 : Who has the most working experience in the organization?
public class Problem9 {
public static void main(String[] args) {
	List<Employee> employees = EmployeeUtils.fetchEmployees();
	usingReduce(employees);
	System.out.println("============================");
	usingMax(employees);
}
private static void usingReduce(List<Employee> employees) {
	Employee mostExperiencedEmp = employees.stream()
			 .reduce((a,b) -> a.getYearOfJoining() <= b.getYearOfJoining() ? a:b)
			 .orElseThrow(RuntimeException::new);
	System.out.println(mostExperiencedEmp);
}

private static void usingMax(List<Employee> employees) {
	Employee mostExperiencedEmp = employees.stream()
			.min(Comparator.comparing(Employee::getYearOfJoining))
			.orElseThrow(RuntimeException::new);
	System.out.println(mostExperiencedEmp);
}
}
