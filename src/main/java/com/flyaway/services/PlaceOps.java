package com.flyaway.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.dbconn.DbConnection;
import com.flyaway.models.Places;

public class PlaceOps {
	
   private Connection conObj = null;
   
   public PlaceOps() {
	   conObj = DbConnection.getConnection();
   }
   
   // Adding source/destination
	public String AddNewSource (Places plc) {
		String result = "Error";
		try {
			String sql = "Insert into Places(placename,cityname,airportname) values(?,?,?)";
			PreparedStatement ps = conObj.prepareStatement(sql);
			
			ps.setString(1, plc.getPlacename());
			ps.setString(2, plc.getCityname());
			ps.setString(3, plc.getAirportname());
			
			int res = ps.executeUpdate();
			if (res>=1) {
				result = "Success";}
		}
		catch(Exception ex) {
			result= ex.getMessage();
			ex.printStackTrace();
		}
		return result;
	}
	
	// Deleting source/destination
	
	public String DeleteSource(int placeid) {
		String result ="Error";
		try {
			String sql= "Delete from Places where placeid=?";
			PreparedStatement ps = conObj.prepareStatement(sql);
			ps.setInt(1, placeid);
			int r =ps.executeUpdate();
			
			if (r>=1) {
				result="Success";
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result = ex.getMessage();
		}
		return result;
	}
	
	// List of Sources
	public List<Places> ListPlace(){
		List<Places> list = new ArrayList<Places>();
		
		Places plc = null;
		
		try {
			String sql = "select * from Places";
			PreparedStatement ps = conObj.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				plc = new Places();
				plc.setPlaceid(rs.getInt("placeid"));
				plc.setPlacename(rs.getString("placename"));
				plc.setCityname(rs.getString("cityname"));
				plc.setAirportname(rs.getString("airportname"));
				list.add(plc);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
