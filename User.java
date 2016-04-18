public class User {
	private String username;
	private String password;
	private String accounttype;
	
	public User() {
		this.username = "CSC200";
		this.password = "123456";
		this.accounttype = "Administrator";
	}
	
	public User(String username, String password, String accounttype) {
		this.username = username;
		this.password = password;
		this.accounttype = accounttype;
	}
	
	public void setUsername(String _username) {
		this.username = _username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String _password) {
		this.password = _password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setAccountType(String _accounttype) {
		this.accounttype = _accounttype;
	}
	
	public String getAccountType() {
		return this.accounttype;
	}
	
	public String toString() {
		return "Username: " + this.username +
				"\nPassword: " + this.password +
				"\nAccount Type: " + this.accounttype;
	}
}
