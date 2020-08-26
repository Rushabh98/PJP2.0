package Main;

import java.util.Scanner;

public class CollectTwoDates {

	public static String[] ReturnTwoDates() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter date in following format: dd-MM-yyyy");
		String[] dates = new String[2];
		for(int i=0;i<2;i++) {
			System.out.print("Enter date"+(i+1)+":");
			dates[i] = sc.next();
			if(!new ValidateDate().validateDate(dates[i]))
				return null;
		}
		System.out.println("date1:"+dates[0]);
		System.out.println("date2:"+dates[1]);
		sc.close();
		return dates;
	}

	
	
}
