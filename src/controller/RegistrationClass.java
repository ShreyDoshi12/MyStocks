package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.EditProfileDAO;
import DAO.MProfileDAO;
import DAO.ManageManagerDAO;
import DAO.ManagerProfileDAO;
import DAO.RegisterDAO;
import DAO.UserProfileDAO;

/**
 * @author shrey
 *
 */
@ManagedBean(name = "RegistrationClass")
@SessionScoped
public class RegistrationClass {

	private String firstname;
	private String lastname;
	private String phoneno;
	private String email;
	private String username;
	private String password;
	private String role;
	private String fees;

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

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

	public String UserLog() {
		RegisterDAO.registration(firstname, lastname, phoneno, email, username, password, role,fees);
		return "registration-success";
	}

	public String ManageManager() {
		ManageManagerDAO.manager(username, role);
		return "admindash";

		// System.out.println("Hello manager");
		// boolean result = ManageManager.manager(username, role);
		// if (role.equals ("manager")) {
		//
		// return "admindash";
	}
	public String EditLog() {
		System.out.println("HEllo");
		 EditProfileDAO.edit(firstname, lastname, phoneno, email, username, password);
		 return "update-success";

	}
	public ArrayList<RegistrationClass> viewm() {
		return MProfileDAO.getRegistrationClass(role);
	}

}
