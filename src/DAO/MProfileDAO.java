package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import controller.ManagerProfile;
import controller.RegistrationClass;
import dataconnect.DataConnect;

public class MProfileDAO {

	public static ArrayList<RegistrationClass> getRegistrationClass(String role) {
		// TODO Auto-generated method stub
		try {
			Connection con = DataConnect.getConnection();
			 PreparedStatement ps = con.prepareStatement("SELECT firstname,email,phoneno,username,lastname from userdb where role=manager");
				ps.setString(1, role);
			
			
			ArrayList<RegistrationClass> rc = new ArrayList<RegistrationClass>();
			ResultSet rs = ps.executeQuery();
			boolean request = false;
			if (rs.next()) {
				RegistrationClass gt = new RegistrationClass();
				gt.setFirstname(rs.getString("firstname"));
				gt.setLastname(rs.getString("lastname"));
				gt.setEmail(rs.getString("email"));
				gt.setPassword(rs.getString("password"));
				gt.setUsername(rs.getString("username"));
				gt.setphoneno(rs.getString("phoneno"));
				rc.add(gt);
				request = true;
			}
				if(request){
				rs.close();
				con.close();
				return rc;
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

