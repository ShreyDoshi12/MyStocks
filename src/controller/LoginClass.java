package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.LoginDAO;

@ManagedBean(name = "LoginClass")
@SessionScoped
public class LoginClass {
	private String ID;
	private String username;
	private String password;
	private String role;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneno;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	

	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String dologin() {
		boolean result = LoginDAO.login(username, password, role);
		 this.ID =   (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ID");
		 this.firstname =  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("firstname");
		 this.lastname =  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lastname");
		 this.username =  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
		 this.password =  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("password");
		 this.email =  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
		 this.phoneno =  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("phoneno");
		
		if (result == true) {
			if (this.getRole().equals ("admin")) {
				
				return "admindash";
			} else if (this.getRole().equals ("manager")) {
				
				return "managerdash";
			} else {
				
				return "userdash";
			}
		}

		// String username = (String)
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().set("username");
		// return "login-success?faces-redirect=true";
		else {

			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!", "Please Try Again!"));

			return "login_one";
		}

	}

	public void logout() throws java.io.IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().redirect("login_one.xhtml");
	}

	
}
