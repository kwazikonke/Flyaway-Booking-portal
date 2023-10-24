package com.flyaway.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.dbconn.DbConnection;
import com.flyaway.models.Airlines;

public class AirlinesOps {

	private Connection conObj= null;
	
	public AirlinesOps() {
		conObj = DbConnection.getConnection();
	}
	 // Adding airline
		public String AddAirline (Airlines al) {
			String result = "Error";
			try {
				String sql = "Insert into Airlines(airlinesname,flightno) values(?,?)";
				PreparedStatement ps = conObj.prepareStatement(sql);
				
				ps.setString(1, al.getAirlinesname());
				ps.setString(2, al.getFlightno());
				
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
		
		// Deleting Airline
		
		public String DeleteAirline(int airlinesid) {
			String result ="Error";
			try {
				String sql= "Delete from Airlines where airlinesid=?";
				PreparedStatement ps = conObj.prepareStatement(sql);
				ps.setInt(1, airlinesid);
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
		public List<Airlines> ListAirlines(){
			List<Airlines> list = new ArrayList<Airlines>();
			
			Airlines al = null;
			
			try {
				String sql = "select * from Airlines";
				PreparedStatement ps = conObj.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					al = new Airlines();
					al.setAirlinesid(rs.getInt("airlinesid"));
					al.setAirlinesname(rs.getString("airlinesname"));
					al.setFlightno(rs.getString("flightno"));
					list.add(al);
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return list;
		}		
}
