package employeeproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeUtils {

	public static final String MALE = "Male";
	public static final String FEMALE = "Female";

	public static List<Employee> fetchEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, FEMALE, "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, MALE, "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, MALE, "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, MALE, "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, FEMALE, "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, MALE, "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, MALE, "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, MALE, "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, FEMALE, "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, MALE, "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, FEMALE, "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, MALE, "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, FEMALE, "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, MALE, "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, MALE, "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, FEMALE, "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, MALE, "Product Development", 2012, 35700.0));

		return employeeList;
	}
	
	public static Predicate<Employee> isEmployeeFemalePredicate = employee -> FEMALE.equals(employee.getGender());
	
	public static Predicate<Employee> hasJoinedAfter2015 = employee -> employee.getYearOfJoining() > 2015;
	public static Predicate<Employee> isSalesAndMarketing =
	e -> "Sales And Marketing".equals(e.getDepartment());
	
	public static Predicate<Employee> isGreaterThan25 =
			e -> e.getAge()> 25;
}
