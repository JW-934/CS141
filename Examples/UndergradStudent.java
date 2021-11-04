
// an Undergrad is a college student, without a bachelor's but they
// may have a minor

public class UndergradStudent extends CollegeStudent{
	private String minor;
	
	public UndergradStudent(String g, String f, int y, String[]grades, String m, String a, String minor){
		super(g, f, y, grades, m, a);
		this.minor = minor;
	}
}


/*
 * student: given, family, year, grades
 * 		college student: all student and major, advisor
 * 			grad student: all of college and thesis
 * 			undergrad: all of the college student and minor
 * 
 */
