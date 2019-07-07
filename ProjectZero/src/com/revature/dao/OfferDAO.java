package com.revature.dao;

import java.sql.SQLException;

import com.revature.bean.Offer;

public interface OfferDAO {
	public void createNewOffer(Offer o) throws SQLException;
	
	public void viewOffers() throws SQLException;
	
	public void deleteOffers(Offer o) throws SQLException;
}