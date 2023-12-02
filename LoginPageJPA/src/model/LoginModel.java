package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LoginPageJPA")
public class LoginModel implements Serializable {
	
	@Id
	@Column(name="login_id")
	private String loginID;
	
	@Column(name="password")
	private String password;
	
	
	
	public String getLoginID() {
		return loginID;
	}

	
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
