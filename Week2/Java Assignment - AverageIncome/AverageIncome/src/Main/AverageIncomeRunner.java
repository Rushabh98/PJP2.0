package Main;
import java.util.List;
import java.util.Scanner;

public class AverageIncomeRunner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Taking the path of input file from user
		//FORMAT: "C:\Users\admin\Desktop\PJP2.0\Assignments\Sample input file Assignment 3.csv"
		System.out.println("Enter path for input File: ");
		String inputFilePath = sc.nextLine();
		
		//Taking the path of output file from user
		//FORMAT: "C:\Users\admin\Desktop\PJP2.0\Assignments\Sample_output_file_Assignment_3.csv"
		System.out.println("Enter path for output File: ");
		String outputFilePath = sc.nextLine();
		
		//Reading the input CSV file
		List<UserData> userData = ReadCSVfile.extractDataFromCSV(inputFilePath);
		
		//Processing the data according to the given rules
		List<FinalUserData> finalUserData = EvaluateUserIncome.process(userData);
		
		//Writing the generated data to CSV file
		WriteCSVfile.write(finalUserData, outputFilePath);
		
		sc.close();
	}
}
