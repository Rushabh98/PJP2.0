package Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadCSVfile {
	
	public static List<UserData> extractDataFromCSV(String inputFilePath) {
		List<UserData> userData = new ArrayList<UserData>();
		try {
			File inputF = new File(inputFilePath);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

			userData = br.lines().skip(1).map(extractData).collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		return userData;
	}

	private static Function<String, UserData> extractData = (line) -> {
		String[] row = line.split(",");
		UserData userData = new UserData();
		
		if (row[0] != null && row[0].trim().length() > 0) {
			userData.setCity(row[0]);
		}
		if (row[1] != null && row[1].trim().length() > 0) {
			userData.setCountry(row[1]);
		}
		if (row[2] != null && row[2].trim().length() > 0) {
			userData.setGender(row[2]);
		}
		if (row[3] != null && row[3].trim().length() > 0) {
			userData.setCurrency(row[3]);
		}
		if (row[4] != null && row[4].trim().length() > 0) {
			userData.setAmount(Double.valueOf(row[4]));
		}
		return userData;
	};
}
