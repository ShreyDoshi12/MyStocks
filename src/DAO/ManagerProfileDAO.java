package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import controller.ManagerProfile;
import dataconnect.DataConnect;

public class ManagerProfileDAO {

	public static ArrayList<ManagerProfile> getManagerProfile(String role) {
		// TODO Auto-generated method stub
		try {
			Connection con = DataConnect.getConnection();
			 PreparedStatement ps = con.prepareStatement("SELECT firstname,email,phoneno,username,lastname from userdb where role=manager");
				ps.setString(1, role);
			
			
			ArrayList<ManagerProfile> mp = new ArrayList<ManagerProfile>();
			ResultSet rs = ps.executeQuery();
			boolean request = false;
			if (rs.next()) {
				ManagerProfile gt = new ManagerProfile();
				gt.setFirstname(rs.getString("firstname"));
				gt.setLastname(rs.getString("lastname"));
				gt.setEmail(rs.getString("email"));
				gt.setPassword(rs.getString("password"));
				gt.setUsername(rs.getString("username"));
				gt.setPhoneno(rs.getString("phoneno"));
				mp.add(gt);
				request = true;
			}
				if(request){
				rs.close();
				con.close();
				return mp;
			}else{
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
