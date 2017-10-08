import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "LoginClass")
@SessionScoped
public class LoginClass {
	private String uname;
	private String password;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String dologin() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uname", password);
		
				return "login-success";
			}


	// public String logout() {
	// HttpSession session = Util.getSession();
	// session.invalidate();
	// return "login_one";
	// }
	public void registration_one() {
	

	}
}
