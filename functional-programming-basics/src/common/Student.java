package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Comparable<Student>{
	//assuming name is unique
    private String name;
    private int noteBooks;
    public int getNoteBooks() {
		return noteBooks;
	}
	public void setNoteBooks(int noteBooks) {
		this.noteBooks = noteBooks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private int gradeLevel;
    private double gpa;
    private String gender;
    List<String> activities = new ArrayList<>();
    //top 2 favourite footballler
    //hence using array as we know that 3 elements oly needed
    String[] favouriteFootballers  = new String[3];

    public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities , String[] favouriteFootballers,int noteBooks) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
        this.favouriteFootballers=favouriteFootballers;
        this.noteBooks = noteBooks;
    }
    public Student() {
    	
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }



    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    
    public String[] getFavouriteFootballers() {
		return favouriteFootballers;
	}
	public void setFavouriteFootballers(String[] favouriteFootballers) {
		this.favouriteFootballers = favouriteFootballers;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gradeLevel=" + gradeLevel + ", gpa=" + gpa + ", gender=" + gender
				+ ", activities=" + activities + ", favouriteFootballers=" + Arrays.toString(favouriteFootballers)
				+ "]";
	}
	public void consumeKing() {
    	System.out.println(toString());
    }
    
    public void consumeDoubleKing() {
    	System.out.println(toString()+ " king");
    }

    //self made filter for goodStudent
    public boolean isExcellentStudent() {
    	return this.gpa >=3.9;
    }
	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}
}

