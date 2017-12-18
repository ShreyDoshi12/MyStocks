package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import dataconnect.DataConnect;

public class ManageManagerDAO {
	public static boolean manager(String username, String role){
	
	 try {
		 Connection con = DataConnect.getConnection();
         String sql = "INSERT INTO userdb(username, role) VALUES(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, role);
			ResultSet rs = st.executeQuery(sql);
			
	
			if (rs.next()) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username",rs.getString("username"));
				con.close();
				return true;
			}
	 }catch (Exception e){
		 e.printStackTrace();
		 return false;
	 }
	return false;
	}

	
}
