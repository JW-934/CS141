
public class Square implements Shape{
	private int s;
	
	public Square(int s){
		this.s = s;
	}
	
	public int area(){
		return s*s;
	}
	
	public int perimeter(){
		return s * 4;
	}
}
