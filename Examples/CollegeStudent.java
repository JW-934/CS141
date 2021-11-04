// a college student has a major and an advisor
public class CollegeStudent extends Student{ // parent aka super
					// a coll student """IS""" a student
	private String major;
	private String advisor;
	
	public CollegeStudent(String given, String family, int year, String[]grades,String major, String advisor){
		super(given, family, year, grades);
		setMajor(major);
		setAdvisor(advisor);
	}
	
	public void setMajor(String major){
		if(major == null){
			major = "";
		}
		this.major = major;
	}
	
	public void setAdvisor(String advisor){
		if(advisor == null){
			advisor = "";
		}
		this.advisor = advisor;
	}
	
	public static void main(String[]args){
		String[] grades = {"100", "100", "100"};
		Student peter = new GradStudent("peter", "parker", 17, grades, "bio-chem", "dr. olivia octavius", "how to be spider-man");
		System.out.println(peter.toString());
		System.out.println(peter.hashCode());
		
		// polymorphism : many shapes
		Object[] students = new Student[2];
		students[0] = new Student("gwen", "stacy", 14, grades);
		students[1] = peter;
		for(Object x: students){
			System.out.println(x.toString());
			//GradStudent y = (GradStudent) x;
			if(x instanceof GradStudent){
				System.out.println("Congrats on the degree!");
				GradStudent y = (GradStudent) x;
			}
		}
	}
	public String toString(){
		return super.toString() + "major: " + major+"\nadvisor: "+ advisor+"\n";
	}
}
