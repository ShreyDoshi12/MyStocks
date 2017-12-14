package edu.shrey;
import java.sql.*;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
public class LoginDAO {
	public static boolean login(String username, String password) {

		try {

			String hostName = "localhost";
			String portNumber = "3306";
			String databaseName = "icsi518_server";
			String userName = "root";
			String pwd = "shrey12";

			String myurl = "jdbc:mysql://" + hostName + ":" + portNumber + "/" + databaseName;

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(myurl, userName, pwd);

			String sql = "select username from userdb where username = ? AND password = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
//			st.setString(3, role);
			ResultSet rs = st.executeQuery();
			System.out.println("Login Successful loginDAO");
	
			if (rs.next()) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username",rs.getString("username"));
				System.out.println(rs.getString("username"));
				//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", rs.getString("id"));
				//System.out.println("id: " + rs.getString("id"));
				con.close();
				return true;
			}
		} catch (Exception e) {
			System.err.println("Try again   " + e.getMessage());
			return false;
		} finally {
	
		}
		return false;
	}
}
