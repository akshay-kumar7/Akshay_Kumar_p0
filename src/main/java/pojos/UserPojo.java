package pojos;

public class UserPojo {

	// Private Variables
	private String userName;
	private String pwd;
	private int userId;
	private String userFirstName;
	private String userLastName;

	// Default Constructor
	public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor Parameterized
	public UserPojo(String userName, String pwd, int userId, String userFirstName, String userLastName) {
		super();
		this.userName = userName;
		this.pwd = pwd;
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}

	// Getters and Setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	// ToString Method
	@Override
	public String toString() {
		return "UserPojo [userName=" + userName + ", pwd=" + pwd + ", userId=" + userId + ", userFirstName="
				+ userFirstName + ", userLastName=" + userLastName + "]";
	}

}
