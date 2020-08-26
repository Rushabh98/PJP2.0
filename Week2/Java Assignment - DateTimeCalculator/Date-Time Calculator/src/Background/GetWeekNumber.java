package Background;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetWeekNumber {

		String date;
		public GetWeekNumber(String date) throws ParseException {
			this.date = date;
			getWeekNumber();
		}
		private void getWeekNumber() throws ParseException {
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date date1 = df.parse(date);

			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			int week = cal.get(Calendar.WEEK_OF_YEAR);
			System.out.println(week);
		}
		
	}