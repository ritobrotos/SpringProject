package project.dao;

import java.util.List;

import project.model.Place;

public interface PlaceDao {

	String SELECT_ALL_PLACES = "select id, name, category, rating, latitude, longitude from place";
	String SELECT_ALL_PLACES_BY_ID = "select id, name, category, rating, latitude, longitude from place WHERE id = ?";
	
	public List<Place> retrieveAllPlace();
	
	public Place retrievePlaceById(int placeId);
	
}
