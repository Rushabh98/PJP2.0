package Background;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TranslatePhrase {

	public TranslatePhrase(String phrase) {
		Map<String, String> translations = new HashMap<>();
		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		translations.put("today", LocalDate.now().format(formatObj).toString());
		translations.put("tomorrow", LocalDate.now().plusDays(1).format(formatObj).toString());
		translations.put("yesterday", LocalDate.now().minusDays(1).format(formatObj).toString());
		translations.put("day-after-tomorrow", LocalDate.now().plusDays(2).format(formatObj).toString());
		translations.put("day-before-yesterday", LocalDate.now().minusDays(2).format(formatObj).toString());
		
		translations.put("last-week", LocalDate.now().minusWeeks(1).format(formatObj).toString());
		translations.put("last-month", LocalDate.now().minusMonths(1).getMonth().toString());
		translations.put("last-year", Integer.toString(LocalDate.now().minusYears(1).getYear()));
		
		translations.put("next-week", LocalDate.now().plusWeeks(1).format(formatObj).toString());
		translations.put("next-month", LocalDate.now().plusMonths(1).getMonth().toString());
		translations.put("next-year", Integer.toString(LocalDate.now().plusYears(1).getYear()));
		
		System.out.println(translations.get(phrase));
	}

}
