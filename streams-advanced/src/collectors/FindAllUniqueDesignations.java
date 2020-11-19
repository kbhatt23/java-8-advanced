package collectors;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import data.EmployeeVO;
import util.StreamUtil;

public class FindAllUniqueDesignations {
public static void main(String[] args) {
	List<String> designationList = StreamUtil.findAllEmployees()
			.stream()
			.map(EmployeeVO::getDesignation)
			.distinct()
			.collect(Collectors.toList());
	
	Set<String> designationSet = StreamUtil.findAllEmployees()
			.stream()
			.map(EmployeeVO::getDesignation)
			//.distinct()
			.collect(Collectors.toSet());
	
	Set<String> designationSetOrdered = StreamUtil.findAllEmployees()
			.stream()
			.map(EmployeeVO::getDesignation)
			//.distinct()
			.collect(Collectors.toCollection(LinkedHashSet::new));
	
	Set<String> designationSetSorted = StreamUtil.findAllEmployees()
			.stream()
			.map(EmployeeVO::getDesignation)
			//.distinct()
			.collect(Collectors.toCollection(TreeSet::new));
	
	
	
	
	System.out.println(designationList);
	System.out.println(designationSet);
	System.out.println(designationSetOrdered);
	System.out.println(designationSetSorted);
} 

}
