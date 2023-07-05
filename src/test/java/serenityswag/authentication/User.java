package serenityswag.authentication;

public enum User {

	STANDARD_USER("standard_user","secret_sauce","A standard user"),
	LOCKED_OUT_USER("locked_out_user","secret_sauce","A locked out user"),
	PROBLEM_USER("problem_user","secret_sauce","A problem user"),
	PERFORMANCE_GLITCH_USER("performance_glitch_user","secret_sauce","A performance glitch user");
	
	private final String username;
	private final String password;
	private final String Description;
	
	private User(String username, String password, String description) {
		this.username = username;
		this.password = password;
		Description = description;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	
	@Override
	public String toString()
	{
		return Description;
	}
	
}
