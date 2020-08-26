package Background;

public class AddTwoDates {
	
	String date1,date2;
	
	public AddTwoDates(String[] dates) {
		this.date1 = dates[0];
		this.date2 = dates[1];
		addDates();
	}
	
	public void addDates() {
		
		DateOperations dateOperator = new DateOperations();
		
		int[] date1Parts = dateOperator.DateBreaker(date1);
		int[] date2Parts = dateOperator.DateBreaker(date2);
		String final_date="Added given 2 dates";
		
		System.out.println(final_date);
	}
	
}
