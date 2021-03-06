package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.ManagerProfileDAO;

@ManagedBean(name = "managerprofile")
@SessionScoped
public class ManagerProfile {

	private String firstname;
	private String lastname;
	private String phoneno;
	private String email;
	private String username;
	private String password;
	public String role = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("role");

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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
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

	public ArrayList<ManagerProfile> viewmanagerprofile() {
		ArrayList<ManagerProfile> abs = new ArrayList<ManagerProfile>();
		System.out.println(abs);
		return ManagerProfileDAO.getManagerProfile(role);

	}

}
