package project.dao;

import java.util.List;

import project.model.Place;

public interface PlaceDao {

	String SELECT_ALL_PLACES = "select id, name, category, rating, latitude, longitude from place";
	
	public List<Place> retrieveAllPlace();
	
}
