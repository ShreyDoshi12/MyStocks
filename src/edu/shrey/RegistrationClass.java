package edu.shrey;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * @author shrey
 *
 */
@ManagedBean(name = "RegistrationClass")
public class RegistrationClass {

	private String firstname;
	private String lastname;
	private String phoneno;
	private String email;
	private String username;
	private String password;
	private String role;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getphoneno() {
		return phoneno;
	}

	public void setphoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String UserLog(){
		UserLog.registration(firstname, lastname, phoneno, email, username, password, role);
		return "registration-success";
	}
}
