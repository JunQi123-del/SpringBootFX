package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LoginPageJPA")
public class LoginModel implements Serializable {
	
	@Id
	@Column(name="login_id")
	private String loginID;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String emailAddress;
	
//	@Column(name="first_name")
//	private String firstName;
//	
//	@Column(name="last_name")
//	private String LastName;
//	
//	@Column(name="date_of_birth")
//	@Temporal(TemporalType.DATE)
//	private Calendar DOB;
	
//	public String getLoginID() {
//		return loginID;
//	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	
//	public String getLastName() {
//		return LastName;
//	}
//	
//	public void setLastName(String lastName) {
//		LastName = lastName;
//	}
//
//	public Calendar getDOB() {
//		return DOB;
//	}
//
//
//
//	public void setDOB(Calendar dOB) {
//		DOB = dOB;
//	}



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
