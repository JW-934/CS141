
public class Rect implements Shape{
	private int s1, s2;
	
	public Rect(int s1, int s2){
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public int area(){
		return s1 * s2;
	}
	
	public int perimeter(){
		return s1 *2 + s2 *2;
	}
}
