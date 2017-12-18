package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import controller.ManagerProfile;
import controller.UserProfile;
import dataconnect.DataConnect;

public class UserProfileDAO {
	public static ArrayList<UserProfile> getUserProfile() {
		// TODO Auto-generated method stub
		try {
			Connection con = DataConnect.getConnection();
			String sql = "Select FROM userdb(firstname, lastname, email, password, username, phoneno) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			ArrayList<UserProfile> up = new ArrayList<UserProfile>();
			ResultSet rs = st.executeQuery();
			boolean request = false;
			if (rs.next()) {
				UserProfile gt = new UserProfile();
				gt.setFirstname(rs.getString("firstname"));
				gt.setLastname(rs.getString("lastname"));
				gt.setEmail(rs.getString("email"));
				gt.setPassword(rs.getString("password"));
				gt.setUsername(rs.getString("username"));
				gt.setPhoneno(rs.getString("phoneno"));
				up.add(gt);
				request = true;
				rs.close();
				con.close();
			}
			if (request) {
				return up;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			return null;
		}
	}

	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
