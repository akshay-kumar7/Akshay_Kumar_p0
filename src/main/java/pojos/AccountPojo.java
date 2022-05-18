package pojos;

public class AccountPojo {
	
	private String acc_type;
	private double acc_balance;
	private int acc_id;
	
	
	// Getters and Setters
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public double getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	// ToString Method
	@Override
	public String toString() {
		return "AccountPojo [acc_type=" + acc_type + ", acc_balance=" + acc_balance + ", acc_id=" + acc_id + "]";
	}

	// Default Constructor
	public AccountPojo() {
		super();
	}

	// Constructor Parameterized
	public AccountPojo(String acc_type, double acc_balance, int acc_id) {
		super();
		this.acc_type = acc_type;
		this.acc_balance = acc_balance;
		this.acc_id = acc_id;
	}
	
	
	

}
