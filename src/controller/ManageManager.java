package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ManageManagerController")
@SessionScoped
public class ManageManager {
	private String username;
	private String password;
	private String role;
}
