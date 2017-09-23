import javax.faces.bean.ManagedBean;

@ManagedBean(name="LoginClass")
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
	public String loginKar(){
		if(this.uname.equals("admin")){
			if(this.password.equals("admin")){
				return "login-success";
			}
		}
		return "login-fail";
	}
	
	
}
