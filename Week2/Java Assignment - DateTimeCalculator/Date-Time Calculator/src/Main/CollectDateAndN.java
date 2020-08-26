package Main;

import java.util.Scanner;

public class CollectDateAndN {
	
	public static String[] ReturnDateAndN() {
		Scanner sc= new Scanner(System.in);
		
		String[] dateAndN = new String[3];
		
		System.out.println("Enter date in following format: dd-MM-yyyy");
		System.out.print("Enter date: ");
		dateAndN[0] = sc.next();
		if(!new ValidateDate().validateDate(dateAndN[0]))
			return null;
		System.out.print("Enter n: ");
		dateAndN[1] = sc.next();
		System.out.print("Enter option: ");
		dateAndN[2] = sc.next();
		sc.close();
		return dateAndN;
	}
}
