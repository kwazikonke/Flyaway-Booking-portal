package com.flyaway.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flyaway.dbconn.DbConnection;
import com.flyaway.models.Registration;

import jakarta.websocket.Session;

public class RegistrationOps {

	private Connection conObj = null;
	
	public RegistrationOps() {
		conObj = DbConnection.getConnection();
	}
	
	// Registering New Memeber
	public String NewRegistration (Registration reg) {
		String result = "Error";
		try {
			String sql = "Insert into Registration(firstname,lastname,email,phone,password) values(?,?,?,?,?)";
			PreparedStatement ps = conObj.prepareStatement(sql);
			
			ps.setString(1, reg.getFirstname());
			ps.setString(2, reg.getLastname());
			ps.setString(3, reg.getEmail());
			ps.setString(4, reg.getPhone());
			ps.setString(5, reg.getPassword());
			
			int res = ps.executeUpdate();
			if (res>=1) {
				result = "Success";
			}
			
		}
		catch(Exception ex) {
			result= ex.getMessage();
			ex.printStackTrace();
		}
		return result;
	}
	// Check  Users
	public Registration CheckUser(String uname, String pswd) {
		Registration reg =null;
		try {
			PreparedStatement ps = conObj.prepareStatement("select * from Registration where email=? and pwd=?");
			ps.setString(1, uname);
			ps.setString(2, pswd);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				reg= new Registration();
				reg.setRegistrationid(rs.getInt("registrationid"));
				reg.setFirstname(rs.getString("firstname"));
				reg.setFirstname(rs.getString("firstname"));
				reg.setLastname(rs.getString("lastname"));
				reg.setEmail(rs.getString("email"));
				reg.setPhone(rs.getString("phone"));
				reg.setPassword(rs.getString("password"));

			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return reg;
	}
	
	
}
