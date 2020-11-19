package collectors;

import java.util.List;

import data.EmployeeVO;
import util.StreamUtil;

public class ReadEmployeeDataFromFile {
public static void main(String[] args) {
	List<EmployeeVO> findEmployeesUsingSpliterator = StreamUtil.findEmployeesUsingSpliterator(StreamUtil.EMPLOYEE_FILE_PATH);
	System.out.println(findEmployeesUsingSpliterator.size());
	
	List<EmployeeVO> employeesUsingStream = StreamUtil.findEmployeesUsingStreams(StreamUtil.EMPLOYEE_FILE_PATH);
	System.out.println(employeesUsingStream.size());
}
}
