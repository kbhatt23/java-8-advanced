package collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import data.EmployeeVO;
import util.StreamUtil;

public class GroupingByGender {
public static void main(String[] args) {
	Map<Boolean, List<String>> nmesByGender = StreamUtil.findAllEmployees()
				.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getGender() == 'M',
				Collectors.mapping(EmployeeVO::getName, Collectors.toList())));
	
	System.out.println(nmesByGender);
	
	Map<String, List<String>> namesbdesignation = StreamUtil.findAllEmployees().stream()
			.collect(Collectors.groupingBy(EmployeeVO::getDesignation,
					Collectors.mapping(EmployeeVO::getName, Collectors.toList())));
	
	System.out.println(namesbdesignation);
	
	Map<String, Long> departmentcount = StreamUtil.findAllEmployees().stream()
			.collect(Collectors.groupingBy(EmployeeVO::getDesignation,
					Collectors.counting()))
			;
	System.out.println(departmentcount);
	
	Map<String, String> departmentHighSalaryName = StreamUtil.findAllEmployees().stream()
		.collect(Collectors.groupingBy(EmployeeVO::getDesignation,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(EmployeeVO::getSalary)), 
					optinalEmployee -> optinalEmployee.map(EmployeeVO::getName).orElse("not present")	)
				
				));
	System.out.println(departmentHighSalaryName);
	
	Map<String, Double> averageSalaryDepartmnet = StreamUtil.findAllEmployees().stream()
		.collect(Collectors.groupingBy(EmployeeVO::getDesignation,
				Collectors.averagingDouble(EmployeeVO::getSalary)
				));
	System.out.println(averageSalaryDepartmnet);
	
	Map<String, Double> highestSalaryeachdepartment = StreamUtil.findAllEmployees().stream()
			.collect(Collectors.groupingBy(EmployeeVO::getDesignation,
					Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(EmployeeVO::getSalary)), 
						optinalEmployee -> optinalEmployee.map(EmployeeVO::getSalary).orElse(10D)	)
					
					));
	System.out.println(highestSalaryeachdepartment);
	
	Map<String, Double> sameasabove = StreamUtil.findAllEmployees().stream()
		.collect(Collectors.groupingBy(EmployeeVO::getDesignation,
				Collectors.mapping(EmployeeVO::getSalary,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Function.identity())
								), Optional::get)
				
				)));
	System.out.println(sameasabove);
}
}
