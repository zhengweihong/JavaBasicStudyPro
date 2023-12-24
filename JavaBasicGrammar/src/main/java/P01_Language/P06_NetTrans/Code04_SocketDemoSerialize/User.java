package P01_Language.P06_NetTrans.Code04_SocketDemoSerialize;

import java.io.*;

public class User implements Serializable {
	private static final long serialVersionUID = 8029118529111728904L;
	
	private String username;
	private String password;
	
	//构造-无参必须写
	public User() {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
