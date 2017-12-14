package edu.shrey;

import java.sql.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Driver;
import com.sun.net.httpserver.Authenticator.Failure;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

@ManagedBean(name = "userLog")
@SessionScoped
public class UserLog {

	public static boolean registration(String firstname, String lastname, String phoneno, String email, String username,
			String password, String role) {
		try {

			String hostName = "localhost";
			String portNumber = "3306";
			String databaseName = "icsi518_server";
			String userName = "root";
			String pwd = "shrey12";

			String myurl = "jdbc:mysql://" + hostName + ":" + portNumber + "/" + databaseName;

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(myurl, userName, pwd);

			String sql = "INSERT INTO userdb(firstname, lastname, email, password, username, phoneno, role) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, firstname);
			st.setString(2, lastname);
			st.setString(3, email);
			st.setString(4, password);
			st.setString(5, username);
			st.setString(6, phoneno);
			st.setString(7, role);
			st.execute();
			System.out.println("Registration Successfully");
			con.close();

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			return false;
		} finally {

		}
		return false;
	}

	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}