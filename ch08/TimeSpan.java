/**
 * Represents a time span of hours and minutes elapsed.
 * 
 * @author Jesse Watson
 */

public class TimeSpan{
	
	private int totalMinutes;
	
	private int hours;
	private int minutes;
	
	public String toString(){
		return hours + "h " + minutes + "m"; 
	}
	
	//Creates a TimeSpan
	public TimeSpan(int h, int m){
		if (h < 0 || m < 0){
			throw new IllegalArgumentException("Time cannot be negative");
		}
		totalMinutes = 0;
		add(h, m);
	}
	
	
	//Adds time to a TimeSpan
	public void add(int h, int m){
		if (h < 0 || m < 0){
			throw new IllegalArgumentException("Time cannot be negative");
		}
		totalMinutes += 60 * h + m;
		hours = totalMinutes / 60;
		minutes = totalMinutes % 60;
	}
	
	
	//Adds time from a given TimeSpan to another TimeSpan
	public void add(TimeSpan span){
		if (span == null){
			throw new IllegalArgumentException("Span is null");
		}
		add(span.hours, span.minutes);
		
	}
	
	
	//Subtracts a given amount of time from a Timespan
	public void subtract(TimeSpan span){
		if (span == null){
			throw new IllegalArgumentException("Span is null");
		}
		if (span.totalMinutes > this.totalMinutes){
			throw new IllegalArgumentException("Time cannot be negative");
		}
        int subTotalMinutes = this.totalMinutes - span.totalMinutes;
		hours = subTotalMinutes / 60;
		minutes = subTotalMinutes % 60;
	}

	
	//Scales a TimeSpan by a given factor
	public void scale(int factor){
		if (factor < 0){
			throw new IllegalArgumentException("Time must be positive");
		}
		this.totalMinutes = totalMinutes * factor;
		hours = this.totalMinutes / 60;
		minutes = this.totalMinutes % 60;
	}
}

//https://findanyanswer.com/goto/393388





