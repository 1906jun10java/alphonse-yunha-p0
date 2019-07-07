package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.bean.Offer;
import com.revature.util.ConnFactory;

public class OfferDAOImpl implements OfferDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void viewOffers() throws SQLException {
		Connection conn = ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PENDDINGOFFER");
		Offer o = null;
		while (rs.next()) {
			o = new Offer(rs.getInt(2), rs.getInt(3), rs.getDouble(4));
			o.setOfferId(rs.getInt(1));
		}
	}

	public void createNewOffer(Offer o) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "INSERT INTO PENDINGOFFER VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, o.getOfferId());
		ps.setInt(2, o.getUserId());
		ps.setInt(3, o.getCar_Id());
		ps.setDouble(4, o.getOffer_price());
		ps.executeUpdate();
	}

	public void deleteOffers(Offer o) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "DELETE FROM PENDINGOFFER WHERE CAR_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, o.getCar_Id());
		ps.executeUpdate();
	}
}
