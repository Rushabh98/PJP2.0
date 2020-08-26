package Background;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddToDate {
	String date;
	long n;
	String option;
	public AddToDate(String[] dateAndN) {
		this.date = dateAndN[0];
		this.n = Long.parseLong(dateAndN[1]);
		this.option = dateAndN[2];
		addToDate();
	}
	private void addToDate() {
		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date1 = LocalDate.parse(date, formatObj);
		LocalDate final_date;
		if(option.toLowerCase().contains("day")) {
			final_date = date1.plusDays(n);
		}
		else if(option.toLowerCase().contains("week")) {
			final_date = date1.plusWeeks(n);
		}
		else if(option.toLowerCase().contains("month")) {
			final_date = date1.plusMonths(n);
		}
		else{
			final_date = date1.plusYears(n);
		}
		System.out.println("Date after adding " + n +" " +  option+": " +final_date.format(formatObj));
	}
}
