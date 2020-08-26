package Main;

import Background.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws ParseException, FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		LocalDateTime obj = LocalDateTime.now();
		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println("-".repeat(50));
		System.out.println("The current date and time is: " + obj.format(formatObj));
		System.out.println("-".repeat(50));
		int flag = 0, option;
		String[] dates, dateAndN;
		String date, phrase;

		while (flag == 0) {
			System.out.println("Select the operation to perform: ");
			System.out.println("1. Subtract 2 dates.");
			System.out.println("2. Add n days,months,weeks,years to a date.");
			System.out.println("3. Subtract n days,months,weeks,years from a date.");
			System.out.println("4. Get Day of Week for a date.");
			System.out.println("5. Get Week number for a date.");
			System.out.println("6. Translate natural phrases.");
			System.out.println("7. Quit.");

			option = sc.nextInt();
			System.out.println("Selected option: " + option);

			switch (option) {
			case 1:
				dates = CollectTwoDates.ReturnTwoDates();
				if (dates == null) {
					System.out.println("Invalid Date");
					break;
				}
				new SubtractTwoDates(dates);
				break;
			case 2:
				dateAndN = CollectDateAndN.ReturnDateAndN();
				if (dateAndN == null) {
					System.out.println("Invalid Date");
					break;
				}
				new AddToDate(dateAndN);
				break;
			case 3:
				dateAndN = CollectDateAndN.ReturnDateAndN();
				if (dateAndN == null) {
					System.out.println("Invalid Date");
					break;
				}
				new SubtractFromDate(dateAndN);
				break;
			case 4:
				date = CollectOne.ReturnDate();
				if (date == null) {
					System.out.println("Invalid Date");
					break;
				}
				new GetDayOfWeek(date);
				break;
			case 5:
				date = CollectOne.ReturnDate();
				if (date == null) {
					System.out.println("Invalid Date");
					break;
				}
				new GetWeekNumber(date);
				break;
			case 6:
				phrase = CollectOne.ReturnPhrase();
				new TranslatePhrase(phrase.toLowerCase());
				break;
			case 7:
				flag = 1;
				break;
			default:
				System.out.println("Invalid Option Selected");
				break;
			}
			System.out.println();
		}
		//sc.close();
	}
}
