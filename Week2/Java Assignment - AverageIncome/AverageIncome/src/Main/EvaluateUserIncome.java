package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EvaluateUserIncome {
	public static List<FinalUserData> process(List<UserData> userData) {
		List<ReducedUserData> rud = new ArrayList<ReducedUserData>();
		List<FinalUserData> fud = new ArrayList<FinalUserData>();

		for (UserData ud : userData)
			rud.add(new ReducedUserData(ud));

		Map<String,Map<String,Double>> mappedGroupedData = rud.stream().collect(
				Collectors.groupingBy(ReducedUserData::getPlace, Collectors.groupingBy(ReducedUserData::getGender,
						Collectors.averagingDouble(ReducedUserData::getUsdAmount))));

		TreeMap<String, Map<String, Double>> sortedrud = new TreeMap<String, Map<String, Double>>();
		sortedrud.putAll(mappedGroupedData);

		for (String place : sortedrud.keySet()) {
			Map<String, Double> gen_avgIncome = sortedrud.get(place);

			for (String gen : gen_avgIncome.keySet()) {
				Double sal = gen_avgIncome.get(gen);
				sal = Math.round(sal*100.0)/100.0;
				fud.add(new FinalUserData(place, gen, sal));
			}
		}
		return fud;
	}
}
