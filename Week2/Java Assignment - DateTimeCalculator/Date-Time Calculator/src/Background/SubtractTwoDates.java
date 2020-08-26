package Background;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class SubtractTwoDates {
	
	String date1,date2;
	
	public SubtractTwoDates(String[] dates) {
		this.date1 = dates[0];
		this.date2 = dates[1];
		subtractDates();
	}
	
	public void subtractDates() {

		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date11 = LocalDate.parse(date1, formatObj);
		LocalDate date22 = LocalDate.parse(date2, formatObj);
		
		Period diff = Period.between(date11, date22); 

		System.out.print( "Difference "+ "between two dates is: "); 

		System.out.printf( "%d years, %d months"+ " and %d days ", 
				diff.getYears(), 
				diff.getMonths(), 
				diff.getDays()); 
	}
}
