package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import data.EmployeeVO;

public class StreamUtil {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String WORD_SEPERATOR = ",";
	public static final String EMPLOYEE_FILE_PATH = "C:\\Kanishk\\learning\\java-8\\java-8-advanced\\streams-advanced\\employeeData.txt";

	public static <T> List<T> paginate(List<T> items, int pageNumber, int sizePerPage){
		Objects.requireNonNull(items);
		int skip = pageNumber *sizePerPage;
		return items.stream()
			 .skip(skip)
			 .limit(sizePerPage)
			 .collect(Collectors.toList());
		
	}
	
	public static List<EmployeeVO> findAllEmployees(){
		List<EmployeeVO> findEmployeesUsingSpliterator = findEmployeesUsingSpliterator(EMPLOYEE_FILE_PATH);
		return findEmployeesUsingSpliterator;
	}
	
	public static List<EmployeeVO> findEmployeesUsingSpliterator(String file){
		List<EmployeeVO> employees = null;
		try(Stream<String> lines = Files.lines(Paths.get(file))){
			employees=StreamSupport.stream(new EmployeeVOSpliterator(lines.spliterator()), false)
				.collect(Collectors.toList());
			;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public static EmployeeVO transformFileLineToEmployeeVO(String line) {
		String[] parts = line.split(WORD_SEPERATOR);
		return new EmployeeVO(Integer.parseInt(parts[0]), parts[1], parts[2].toCharArray()[0],
				convertStringToDate(parts[3], DATE_FORMAT), parts[4], parts[5], convertStringToDate(parts[6], DATE_FORMAT),
				Double.parseDouble(parts[7]));
	}

	public static java.sql.Date convertStringToDate(String dateStr, String pattern) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			date = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}
	
	public static List<EmployeeVO> findEmployeesUsingStreams(String file){
		List<EmployeeVO> employees = null;
		try(Stream<String> lines = Files.lines(Paths.get(file))){
			employees= lines.map(StreamUtil::transformFileLineToEmployeeVO)
				.collect(Collectors.toList());
		}catch (IOException e) {
			e.printStackTrace();
		}
		return employees;
		
	}
}
