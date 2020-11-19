package collectors;

import static java.util.stream.Collectors.joining;

import data.EmployeeVO;
import util.StreamUtil;

public class EmployeeNameJoined {
public static void main(String[] args) {
	String namesjoined = StreamUtil.findAllEmployees()
			 .stream()
			 .map(EmployeeVO::getName)
			 .collect(joining(","));
	System.out.println(namesjoined);
	
	String namesJoinedwithPrefixAndPostfix = StreamUtil.findAllEmployees()
	 .stream()
	 .map(EmployeeVO::getName)
	 .collect(joining(",", "(", ")"));
	System.out.println(namesJoinedwithPrefixAndPostfix);
}

}
