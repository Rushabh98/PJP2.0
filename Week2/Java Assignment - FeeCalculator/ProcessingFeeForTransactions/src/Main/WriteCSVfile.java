package Main;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class WriteCSVfile {
	public static void write(List<FinalClientData> finalClientData, String outputFilePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"));

			StringBuffer line = new StringBuffer();
			line.append("Clint_Id" + "," + "Transaction Type" + "," + "Transaction Date"
					+ "," + "Priority" + "," + "Processing Fee");
			bw.write(line.toString());
			bw.newLine();

			for (FinalClientData fcd : finalClientData) {
				line = new StringBuffer();
				line.append(fcd.getClient_id());
				line.append(",");
				line.append(fcd.getTransaction_type().trim().length() == 0 ? "" : fcd.getTransaction_type());
				line.append(",");
				line.append(fcd.getTransaction_date().trim().length() == 0 ? "" : fcd.getTransaction_date());
				line.append(",");
				line.append(fcd.getPriority());
				line.append(",");
				line.append(fcd.getProcessing_fees());
				line.append(",");

				bw.write(line.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (UnsupportedEncodingException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
