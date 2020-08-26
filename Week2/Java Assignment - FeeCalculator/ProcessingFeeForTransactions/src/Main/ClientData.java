package Main;

public class ClientData {
	private String transaction_id;
	private String client_id;
	private String security_id;
	private String transaction_type;
	private String date;
	private Double market_val;
	private String priority;
	private int processing_fee;

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String tr_id) {
		this.transaction_id = tr_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getSecurity_id() {
		return security_id;
	}

	public void setSecurity_id(String security_id) {
		this.security_id = security_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String tr_type) {
		this.transaction_type = tr_type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getMarket_val() {
		return market_val;
	}

	public void setMarket_val(String market_val) {
		this.market_val = Double.parseDouble(market_val);
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getProcessing_fee() {
		return processing_fee;
	}

	public void setProcessing_fee(int processing_fee) {
		this.processing_fee = processing_fee;
	}
}
