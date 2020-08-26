package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortUserData {
	public static List<FinalClientData> group(List<ClientData> clientData) {
		
		List<FinalClientData> finalClientData = new ArrayList<FinalClientData>();
		
		var groupedClientData = clientData.stream()
				.collect(Collectors.groupingBy(ClientData::getClient_id, Collectors.groupingBy(ClientData::getTransaction_type,
						Collectors.groupingBy(ClientData::getDate, Collectors.groupingBy(ClientData::getPriority,
						Collectors.groupingBy(ClientData::getProcessing_fee))))));
		
		var sortedClientData = new TreeMap<String,Map<String,Map<String,Map<String,Map<Integer,List<ClientData>>>>>>();
		sortedClientData.putAll(groupedClientData);
		
		for (var cid : sortedClientData.keySet()) {
			Map<String,Map<String,Map<String,Map<Integer,List<ClientData>>>>> m2 = sortedClientData.get(cid);
			for (var trty : m2.keySet()) {
				Map<String,Map<String,Map<Integer,List<ClientData>>>> m3 = m2.get(trty);
				for (var date : m3.keySet()) {
					Map<String,Map<Integer,List<ClientData>>> m4 = m3.get(date);
					for (var pri : m4.keySet()) {
						Map<Integer,List<ClientData>> m5 = m4.get(pri);
						for(var profees : m5.keySet()) {
							finalClientData.add(new FinalClientData(cid, trty, date, pri, profees));
						}
					}
				}
			}
		}

		return finalClientData;
	}
}
