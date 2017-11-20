
public class User {
	private String user;
	private String pass;
	private String name;
	
	public User(String user, String pass, String name) {
		this.user = user;
		this.pass = pass;
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
}