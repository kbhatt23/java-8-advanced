package employeeproblems;

import java.util.Comparator;
import java.util.List;

//Query 3.4 : Get the details of highest paid employee in the organization?
public class Problem4 {
	public static void main(String[] args) {
		List<Employee> employees  = EmployeeUtils.fetchEmployees();
		findUsingMax(employees);
		System.out.println("=============");
		findUsingReduce(employees);
	}

	private static void findUsingMax(List<Employee> employees) {
		Employee emp = employees.stream()
					 .max(Comparator.comparing(Employee::getSalary))
					 .orElseThrow(RuntimeException::new)
					 ;
		System.out.println("findUsingMax-> "+emp);
	}
	private static void findUsingReduce(List<Employee> employees) {
		Employee emp = employees.stream()
						.reduce((a,b) -> a.getSalary()  >= b.getSalary() ? a :b)
						.orElseThrow(RuntimeException::new)
						;
				System.out.println("findUsingReduce-> "+emp);
	}

}
