package employeeproblems;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
//Query 3.7 : What is the average salary of each department?
public class Problem7 {
public static void main(String[] args) {
	List<Employee> employees = EmployeeUtils.fetchEmployees();
	Map<String, Double> deaprtMentAvgSalaryMap = employees.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, 
					Collectors.averagingDouble(Employee::getSalary)
					));
	System.out.println(deaprtMentAvgSalaryMap);
	
	System.out.println("lets sort it by value ,  meaning lowest slaary department comes first and so on");
	deaprtMentAvgSalaryMap=deaprtMentAvgSalaryMap.entrySet()
						 .stream()
						 .sorted(Entry.comparingByValue())
						 //we already sorted but since insertion orde to be aminiatined we are using linkedHAshMap
						 .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a,b) -> a, LinkedHashMap::new))
						 ;
	System.out.println(deaprtMentAvgSalaryMap);
	System.out.println("lets sort it by name of departmnet -> which is key");
	
	deaprtMentAvgSalaryMap=deaprtMentAvgSalaryMap.entrySet()
			 .stream()
			 //default is key which is string the department name
			 .sorted(Entry.comparingByKey())
			 //we already sorted but since insertion orde to be aminiatined we are using linkedHAshMap
			 .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a,b) -> a, LinkedHashMap::new))
			 ;
	System.out.println(deaprtMentAvgSalaryMap);
}		
}
