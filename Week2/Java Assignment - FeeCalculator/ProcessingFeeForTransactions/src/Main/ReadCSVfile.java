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
	public static List<ClientData> extractDataFromCSV(String inputFilePath) {
		List<ClientData> clientData = new ArrayList<ClientData>();
		try {
			File inputF = new File(inputFilePath);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

			clientData = br.lines().skip(1).map(extractData).collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		return clientData;
	}

	private static Function<String, ClientData> extractData = (line) -> {
		String[] row = line.split(",");
		ClientData cd = new ClientData();

		if (row[0] != null && row[0].trim().length() > 0) {
			cd.setTransaction_id(row[0]);
		}
		if (row[1] != null && row[1].trim().length() > 0) {
			cd.setClient_id(row[1]);
		}
		if (row[2] != null && row[2].trim().length() > 0) {
			cd.setSecurity_id(row[2]);
		}
		if (row[3] != null && row[3].trim().length() > 0) {
			cd.setTransaction_type(row[3]);
		}
		if (row[4] != null && row[4].trim().length() > 0) {
			cd.setDate(row[4]);
		}
		if (row[5] != null && row[5].trim().length() > 0) {
			cd.setMarket_val(row[5]);
		}
		if (row[6] != null && row[6].trim().length() > 0) {
			cd.setPriority(row[6]);
		}
		return cd;
	};
}

//        Collections.sort(transactions, new Comparator<Transaction>(){
//
//        	  public int compare(Transaction o1, Transaction o2)
//        	  {
//        		  if(o1.client_id-o2.client_id == 0)
//        			  if(o1.tr_type.compareTo(o2.tr_type) == 0)
//        				  return o1.date.compareTo(o2.date);
//        			  else
//        				  return o1.tr_type.compareTo(o2.tr_type);
//        		  else
//        			  return o1.client_id-o2.client_id;
//        	  }
//        	});
//        
//        for(int i=0;i<transactions.size();i++)
//        {
//        	Transaction tr = transactions.get(i);
//        	System.out.print(tr.client_id);
//        	System.out.print(" , " + tr.tr_type);
//        	System.out.print(" , " + tr.date + "\n");
//        }
//	}
//}
//
////ArrayList<Integer> IntradayTransactions = new ArrayList<Integer>();
////HashMap<String, IntraDayTransaction> checkIntraDay = new HashMap<String, IntraDayTransaction>();
////
////for(int i=0;i<transactions.size();i++)
////{
////	Transaction temp = transactions.get(i);
////	IntraDayTransaction itr = new IntraDayTransaction(temp.tr_type, temp.tr_id);
////	
////	String temp_key = temp.client_id + temp.security_id + temp.date;
////	if(checkIntraDay.containsKey(temp_key))
////	{
////		
////	}
////		checkIntraDay.put(temp_key, itr);        	
////}