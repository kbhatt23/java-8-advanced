package common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class StudentDataBase {

    /**
     * Total of 6 students in the database.
     * @return
     */
    public static List<Student> getAllStudents(){

        /**
         * 2nd grade students
         */
        Student student1 = new Student("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball")
        		,new String[]{"messi", "ronaldinho", "xavi"}
        		,10);
        Student student2 = new Student("Jenny",2,3.8,"female", Arrays.asList("swimming", "gymnastics","soccer")
        		,new String[]{"zidane", "kaka", "raul"}
        		,11);
        Student student9 = new Student("kangla",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball")
        		,new String[]{"messi", "ronaldinho", "xavi"}
        		,10);
        /**
         * 3rd grade students
         */
        Student student3 = new Student("Emily",3,4.0,"female", Arrays.asList("swimming", "gymnastics","aerobics")
        		,new String[]{"puyol", "maldini", "cafu"}
        		,18);
        Student student4 = new Student("Dave",3,3.9,"male", Arrays.asList("swimming", "gymnastics","soccer")
        		
        	,new String[]{"inzaghi", "ibrahimovic", "messi"},19);
        /**
         * 4th grade students
         */
        Student student5 = new Student("Sophia",4,3.5,"female", Arrays.asList("swimming", "dancing","football")
        		,new String[]{"neueer", "jovic", "lamela"}
        		,14);
        Student student6 = new Student("James",4,3.9,"male", Arrays.asList("swimming", "basketball","baseball","football")
        		,new String[]{"iniesta", "messi", "pele"}
        		,20);
        
        Student student7 = new Student("James",4,3.9,"female", Arrays.asList("swimming", "basketball","baseball","football")
        		,new String[]{"iniesta", "messi", "pele"}
        		,22);

        List<Student> students = Arrays.asList(student9,student1,student2,student3,student4,student5,student6,student7);
        return students;
    }
    
    public static  <T> Map<T, List<Student>> groupByCustomProperty(Function<Student, T> func, List<Student> students) {
    	Map<T, List<Student>> complexMap=  new HashMap<>();
    	
    	for(Student student: students) {
    		T property = func.apply(student);
    		if(complexMap.containsKey(property)) {
    			complexMap.get(property).add(student);
    		}else {
    			List<Student> newStrudentList = new ArrayList<Student>();
    			newStrudentList.add(student);
    			complexMap.put(property, newStrudentList);
    		}
    	}
    	return complexMap;
    }
    
    public static <T> void printGroupedMap(Map<T, List<Student>> commonNameStudentnts) {
    	commonNameStudentnts.forEach((k,v) ->{
    		System.out.println("name "+k+" has below students: ");
    		v.forEach(System.out::println);
    		System.out.println("======================");
    	});
    }

}
