import java.util.*;

public class Student implements Comparable<Student>{
	// member variables, fields
	private String given;
	private String family;
	private int year;
	private String[]grades;
	
	// default constructor
	public Student(){
		this("", "", 0, null);
	}
	
	// fancy constructor
	public Student(String given, String family, int year, String[]grades){
		setGiven(given); // re-use code and prevent bad data
		setFamily(family);
		this.year = year;
		setGrades(grades, "42");
	}
	
	// getters and setters, ensures data cannot be null
	public String getGiven(){
		return given;
	}
	
	public String getFamily(){
		return family;
	}
	
	public int getYear(){
		return year;
	}
	
	public String[] getGrades(){
		return Arrays.copyOf(grades,grades.length); // return a copy to the user can't tamper
	}
	
	public void setGiven(String given){
		if(given == null){
			this.given = "";
		}else{
			this.given = given.toLowerCase();
		}
	}
	
	public void setFamily(String family){
		if(family == null){
			this.family = "";
		}else{
			this.family = family.toUpperCase();
		}
	}
	
	public void setGrades(String[]grades, String password){
		// only edit if they have the password
		if(password.equals("42")){
			if(grades == null){ // prevent null 
				grades = new String[0];
				grades[0] = "0";
				this.grades = grades; 
			}else{
				this.grades = Arrays.copyOf(grades, grades.length); // prevent tamper
			}
		}
	}
	
	public String toString(){
		return "given: " + this.given + "\n"+
				"family: " + this.family + "\n"+
				"year: " + this.year + "\n"+
				"avg: " + this.avg() + "\n";
	}
	
	// students should know how to computer their average
	public double avg(){
		double sum = 0;
		int num = 0;
		for(String x: grades){
			sum += Integer.parseInt(x);
			num++;
		}
		return sum / num;
	}
	
	public int compareTo(Student x){
		return this.given.compareTo(x.given);
	}
}
