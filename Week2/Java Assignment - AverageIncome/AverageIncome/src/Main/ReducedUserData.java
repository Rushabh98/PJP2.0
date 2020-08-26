package Main;

public class ReducedUserData {
	//country or city
	private String place;
	private String gender;
	private Double usdAmount;
	
	public ReducedUserData(UserData data) {
		if(data.getCountry() == null)
			place = data.getCity();
		else
			place = data.getCountry();
		
		gender = data.getGender();
		
		if(data.getCurrency().equalsIgnoreCase("INR"))
			usdAmount = (data.getAmount())/CurrencyRates.INR;
		else if(data.getCurrency().equalsIgnoreCase("SGD"))
			usdAmount = (data.getAmount())/CurrencyRates.SGD;
		else if(data.getCurrency().equalsIgnoreCase("HKD"))
			usdAmount = (data.getAmount())/CurrencyRates.HKD;
		else if(data.getCurrency().equalsIgnoreCase("GBP"))
			usdAmount = (data.getAmount())/CurrencyRates.GBP;
		else
			usdAmount = data.getAmount();
		usdAmount = Math.round(usdAmount*100.0)/100.0;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getUsdAmount() {
		return usdAmount;
	}

	public void setUsdAmount(Double usdAmount) {
		this.usdAmount = usdAmount;
	}
	
}
