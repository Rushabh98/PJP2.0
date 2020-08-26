package Main;

import java.util.Scanner;

public class CollectOne {
	
	public static String ReturnDate() {
		Scanner sc= new Scanner(System.in);
		String date;
		System.out.println("Enter date in following format: dd-MM-yyyy");
		System.out.print("Enter date: ");
		date = sc.next();
		sc.close();
		return (new ValidateDate().validateDate(date)==false) ? null : date;
	}
	
	public static String ReturnPhrase() {
		Scanner sc= new Scanner(System.in);
		String phrase;
		System.out.print("Enter Phrase: ");
		phrase = sc.next();
		sc.close();
		return phrase;
	}
	
}
