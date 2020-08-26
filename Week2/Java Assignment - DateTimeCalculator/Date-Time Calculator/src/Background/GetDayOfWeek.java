package Background;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetDayOfWeek {
	String date;
	public GetDayOfWeek(String date) {
		this.date = date;
		getDayOfWeek();
	}
	private void getDayOfWeek() {
		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date1 = LocalDate.parse(date, formatObj);
		
		System.out.println(date1.getDayOfWeek());
	}
	
}
