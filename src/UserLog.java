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
	public String firstname;
	public String lastname;
	public String email;
	public String password;
	public String username;
	public String phoneno;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String register() {
		try {

			String hostName = "localhost";
			String portNumber = "3306";
			String databaseName = "icsi518_server";
			String userName = "root";
			String password = "shrey12";

			// HttpSession hs= Util.getSession();
			// Setup the DataSource object
			String myurl = "jdbc:mysql://" + hostName + ":"+ portNumber + "/"+ databaseName;
			// System.out.println(jdbc:mysql://localhost:3306/userDb);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(myurl, userName, password);

			// Get a connection object

			// Get a prepared SQL statement

			String sql = "INSERT INTO userDb(firstnameuserDb, lastnameuserDb,emailuserDb,passuserDb, usernameuserDb, phonenouserDb) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, this.firstname);
			st.setString(2, this.lastname);
			st.setString(3, this.email);
			st.setString(4, this.password);
			st.setString(5, this.username);
			st.setString(6, this.phoneno);

			// Execute the statement
			st.execute();
			System.out.println("Registration Successfully");
			con.close();
			// Iterate through results
			// if (rs.next()) {
			// System.out.println("First Name is: " +
			// rs.getString("firstnameuserDB"));
			// this.firstname = rs.getString("firstnameuserDB");
			//
			// System.out.println("Last Name is: " +
			// rs.getString("lastnameuserDB"));
			// this.lastname = rs.getString("lastnameuserDB");
			//
			// System.out.println("email is: " + rs.getString("emailuserDB"));
			// this.email = rs.getString("emailuserDB");
			//
			// System.out.println("password is: " + rs.getString("passuserDB"));
			// this.firstname = rs.getString("passuserDB");
			//
			// System.out.println("Username is: " +
			// rs.getString("usernameuserDB"));
			// this.firstname = rs.getString("usernameuserDB");
			//
			// System.out.println("Phonenumber is: " +
			// rs.getString("phonenouserDB"));
			// this.firstname = rs.getString("phonenouserDB");
			return "registration-success";

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {

		}
		return "result";
	}

	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
