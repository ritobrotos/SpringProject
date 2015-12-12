package project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.dao.PlaceDao;
import project.model.Place;
import project.services.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	PlaceDao placeDao;
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Place> retrieveAllPlace() {
		return placeDao.retrieveAllPlace();
//		return new ArrayList<Place>();
	}
}
