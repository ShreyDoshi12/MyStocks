package edu.shrey;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import edu.shrey.LoginDAO;
@ManagedBean(name = "LoginClass")
@SessionScoped
public class LoginClass {
	private String username;
	private String password;
//	private String role;

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

//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

	public String dologin() {
		boolean result = LoginDAO.login(username, password);
        if (result == true) {

            return "login-success?faces-redirect=true";
        } else {
 
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Invalid Login!","Please Try Again!"));

            return "login_one";
        }
	}
     public void logout() throws java.io.IOException {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("login_one.xhtml");
    }
}
