package Main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateClientFees {

	public static List<ClientData> process(List<ClientData> clientData) {

		for (ClientData cd : clientData) {
			normalTransactionFees(cd);
		}
		IntradayTransactionFees(clientData);
		return clientData;
	}

	private static void normalTransactionFees(ClientData cd) {
		if (cd.getPriority().contains("Y"))
			cd.setProcessing_fee(500);
		else if (cd.getTransaction_type().equalsIgnoreCase("Sell") || cd.getTransaction_type().equalsIgnoreCase("Withdraw"))
			cd.setProcessing_fee(100);
		else
			cd.setProcessing_fee(50);
	}

	private static void IntradayTransactionFees(List<ClientData> clientData) {
		HashSet<String> intraDayTransIds = findIntraDayTrans(clientData);

		for (ClientData cd : clientData) {
			if (intraDayTransIds.contains(cd.getTransaction_id())) {
				cd.setProcessing_fee(cd.getProcessing_fee() + 10);
				intraDayTransIds.remove(cd.getTransaction_id());
			}
		}
	}

	private static HashSet<String> findIntraDayTrans(List<ClientData> clientData) {
		HashSet<String> buySellTransIds = new HashSet<String>();

		Map<String, String> buySellTrans = new HashMap<>();

		for (ClientData cd : clientData) {
			String key = cd.getClient_id() + "_" + cd.getSecurity_id() + "_" + cd.getDate();

			if (cd.getTransaction_type().contains("Buy")) {
				String findKey = key + "_Sell";

				if (buySellTrans.containsKey(findKey)) {
					String sellTransId = buySellTrans.get(findKey);
					String buyTransId = cd.getTransaction_id();

					buySellTransIds.add(sellTransId);
					buySellTransIds.add(buyTransId);
					buySellTrans.remove(findKey);
				} else {
					key += "_Buy";
					buySellTrans.put(key, cd.getTransaction_id());
				}
			} else if (cd.getTransaction_type().contains("Sell")) {
				String findKey = key + "_Buy";

				if (buySellTrans.containsKey(findKey)) {
					String buyTransId = buySellTrans.get(findKey);
					String sellTransId = cd.getTransaction_id();

					buySellTransIds.add(buyTransId);
					buySellTransIds.add(sellTransId);
					buySellTrans.remove(findKey);
				} else {
					key += "_Sell";
					buySellTrans.put(key, cd.getTransaction_id());
				}
			}
		}
		return buySellTransIds;
	}
}
