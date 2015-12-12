package project.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import project.controller.HomeController;
import project.dao.PlaceDao;
import project.model.Place;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

@Repository
public class PlaceDaoImpl extends JdbcDaoSupport implements PlaceDao {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	public PlaceDaoImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public List<Place> retrieveAllPlace() {
		logger.info("Start retrieveAllPlace:");
		try {
			List<Place> placeList = getJdbcTemplate().query(SELECT_ALL_PLACES, new ResultSetExtractor<List<Place>>() {
				@Override
				public List<Place> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Place> placeList = new ArrayList<Place>();
					while (rs.next()) {
						Place place = new Place();
						place.setId(rs.getInt("id"));
						place.setName(rs.getString("name"));
						place.setCategory(rs.getString("category"));
						place.setRating(rs.getDouble("rating"));
						place.setLatitude(rs.getDouble("latitude"));
						place.setLongitude(rs.getDouble("longitude"));						
						placeList.add(place);
					}
					return placeList;
				}
			});
			return placeList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
