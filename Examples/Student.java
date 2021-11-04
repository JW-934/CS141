public class Student implements Comparable<Student>{
	// member variables, fields
	String given;
	String family;
	int year;
	double avg;
	
	// default constructor
	public Student(){
		this("", "", 0, 0.0);
	}
	
	// fancy constructor
	public Student(String given, String family, int year, double avg){
		this.given = given;
		this.family = family;
		this.year = year;
		this.avg = avg;
	}
	
	public String toString(){
		return "given: " + this.given + "\n"+
				"family: " + this.family + "\n"+
				"year: " + this.year + "\n"+
				"avg: " + this.avg + "\n";
	}
	
	public int compareTo(Student x){
		return given.compareTo(x.given);
	}
}
