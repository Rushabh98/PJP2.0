package Background;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SubtractFromDate {
	
	String date;
	long n;
	String option;
	public SubtractFromDate(String[] dateAndN) {
		this.date = dateAndN[0];
		this.n = Long.parseLong(dateAndN[1]);
		this.option = dateAndN[2];
		subtractFromDate();
	}
	private void subtractFromDate() {
		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date1 = LocalDate.parse(date, formatObj);
		LocalDate final_date;
		if(option.toLowerCase().contains("day")) {
			final_date = date1.minusDays(n);
		}
		else if(option.toLowerCase().contains("week")) {
			final_date = date1.minusWeeks(n);
		}
		else if(option.toLowerCase().contains("month")) {
			final_date = date1.minusMonths(n);
		}
		else{
			final_date = date1.minusYears(n);
		}
		System.out.println("Date after subtracting " + n +" " +  option+": " +final_date.format(formatObj));
	}
	
}
