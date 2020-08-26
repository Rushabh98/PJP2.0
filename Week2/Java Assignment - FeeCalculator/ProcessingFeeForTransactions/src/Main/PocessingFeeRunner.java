package Main;

import java.util.List;
import java.util.Scanner;

public class PocessingFeeRunner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking the path of input file from user
		// FORMAT: "C:\Users\admin\Desktop\PJP2.0\Assignments\Sample_Data_Fee_Calculator.csv"
		System.out.println("Enter path for input File: ");
		String inputFilePath = sc.nextLine();

		// Taking the path of output file from user
		// FORMAT: "C:\Users\admin\Desktop\PJP2.0\Assignments\Sample_Data_Fee_Calculator_output.csv"
		System.out.println("Enter path for output File: ");
		String outputFilePath = sc.nextLine();

		List<ClientData> clientData = ReadCSVfile.extractDataFromCSV(inputFilePath);
		clientData = EvaluateClientFees.process(clientData);

		List<FinalClientData> finalUserData = SortUserData.group(clientData);
		WriteCSVfile.write(finalUserData, outputFilePath);
		sc.close();
	}
}
