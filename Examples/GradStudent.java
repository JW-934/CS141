import java.util.*;
// a gradstudent is a student, but they have a thesis
public class GradStudent extends CollegeStudent{
	private String thesis;
	
	public GradStudent(String g, String f, int y, String[]grades, String m, String a, String t){
		super(g, f, y, grades, m, a);
		thesis = t; // this is what differentiates a grad student from a general college student
	}
	
	public String toString(){
		return super.toString() +"thesis: "+ thesis + "\n" + Arrays.toString(grades) + "\n";
	}
}
