
public class Shapes{
	public static void main(String[]args){
		
		Shape[] shapes= new Shape[2];
		
		shapes[0] = new Rect(4,5);
		shapes[1] = new Square(6);
		
		Student x = new Student();
		Object y = x;
		Comparable z = x;
	}
}
