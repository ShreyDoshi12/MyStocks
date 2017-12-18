package DAO;

import java.sql.*;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dataconnect.DataConnect;

@SessionScoped
public class LoginDAO {

	public static boolean login(String username, String password, String role) {

		try {
			Connection con = DataConnect.getConnection();

			String sql = "SELECT ID,firstname,lastname,username,password,email,phoneno, role from userdb where username = ? and password = ? and role = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, role);
			ResultSet rs = st.executeQuery();
			System.out.println("Login Successful ");

			if (rs.next()) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("firstname",
						rs.getString("firstname"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lastname",
						rs.getString("lastname"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username",
						rs.getString("username"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("password",
						rs.getString("password"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email",
						rs.getString("email"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("phoneno",
						rs.getString("phoneno"));
				// System.out.println(rs.getString("username"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ID", rs.getString("ID"));
//				System.out.println("ID: " + rs.getString("ID"));

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
