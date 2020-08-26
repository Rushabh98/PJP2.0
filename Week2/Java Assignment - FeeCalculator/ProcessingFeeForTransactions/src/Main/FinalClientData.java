package Main;

public class FinalClientData {
	
	private String client_id;
	private String transaction_type;
	private String transaction_date;
	private String priority;
	private int processing_fees;
	
	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getProcessing_fees() {
		return processing_fees;
	}

	public void setProcessing_fees(int processing_fees) {
		this.processing_fees = processing_fees;
	}

	public FinalClientData(String client_id, String transaction_type, String transaction_date, String priority,
			int processing_fees) {
		super();
		this.client_id = client_id;
		this.transaction_type = transaction_type;
		this.transaction_date = transaction_date;
		this.priority = priority;
		this.processing_fees = processing_fees;
	}
}
