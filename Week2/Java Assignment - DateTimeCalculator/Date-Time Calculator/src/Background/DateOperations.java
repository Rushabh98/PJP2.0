package Background;

public class DateOperations {
	
	public String DateJoiner(int day,int month,int year) {
		
		String date = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
		return date;
	}
	
	public int[] DateBreaker(String date) {
		int[] dateParts = new int[3];
		
		String[] dateStringParts = date.split("/");
		dateParts[0] = Integer.parseInt(dateStringParts[0]);
		dateParts[1] = Integer.parseInt(dateStringParts[1]);
		dateParts[2] = Integer.parseInt(dateStringParts[2]);
		return dateParts;
	}
}
