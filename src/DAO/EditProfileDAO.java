package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;

import controller.ManagerProfile;
import dataconnect.DataConnect;

public class EditProfileDAO {
	public static boolean edit(String firstname, String lastname, String phoneno, String email, String username,
			String password) {
		try {
        Connection conn = DataConnect.getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE userdb SET firstname=?,lastname=?, email=?, phoneno=?, username=?, password=? WHERE ID=? ");
        
        String ID = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ID");
        ps.setString(1, firstname); 
        ps.setString(2, lastname);
        ps.setString(3, email);
        ps.setString(4, phoneno);
        ps.setString(5, username);
        ps.setString(6, password);
        ps.setString(7, ID);
//        System.out.println(ID);
//        System.out.println("firstname:" + firstname);
//        System.out.println("lastname:" + lastname);
//        System.out.println("username:" + username);
//        System.out.println("email:" + email);
//        System.out.println("phoneno:" + phoneno); 
//        System.out.println("password:" + password);
        
        int rs = ps.executeUpdate();
        System.out.println(rs);
        if(rs>0){
        	return true;
        }
 	}catch (Exception e) {
 		System.out.println("" +e);
 		return false;
	}
return false;

		    
	}
}

