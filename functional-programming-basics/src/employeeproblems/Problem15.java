package employeeproblems;

import java.util.Comparator;

//Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
public class Problem15 {
public static void main(String[] args) {
	Employee orElseThrow = EmployeeUtils.fetchEmployees()
				.stream()
				.max(Comparator.comparing(Employee::getAge))
				.orElseThrow(RuntimeException::new)
				;
	System.out.println(orElseThrow);
				

}
}
