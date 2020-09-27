package employeeproblems;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Query 3.10 : How many male and female employees are there in the sales and marketing team?
public class Problem10 {
public static void main(String[] args) {
	List<Employee> employees = EmployeeUtils.fetchEmployees();
	usingFilters(employees, EmployeeUtils.MALE);
	usingFilters(employees, EmployeeUtils.FEMALE);
	System.out.println("============");
	usingCollectors(employees);
}

private static void usingFilters(List<Employee> employees, String gender) {
	Predicate<Employee> filter = EmployeeUtils.FEMALE.equals(gender) ? EmployeeUtils.isEmployeeFemalePredicate:EmployeeUtils.isEmployeeFemalePredicate.negate() ;
	long count= employees.stream()
									.filter(EmployeeUtils.isSalesAndMarketing)
									.filter(filter)
									.count();
			System.out.println("count of "+gender+" is "+count);
}

private static void usingCollectors(List<Employee> employees) {
	Map<String, Long> genderCount = employees.stream()
											.filter(EmployeeUtils.isSalesAndMarketing)
											.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()))
										;
									
			System.out.println(genderCount);
}
}
