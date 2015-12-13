package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.model.ListContainer;
import project.model.Place;
import project.model.Response;
import project.services.PlaceService;

@Controller
@Component
@RequestMapping("/place")
public class PlaceRestController {

	private static final Logger logger = LoggerFactory.getLogger(PlaceRestController.class);

	@Autowired
	PlaceService placeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response placeList() {
		logger.info("placelist logger..");
		
		List<Place> placeList = placeService.retrieveAllPlace();
		ListContainer listResponse = new ListContainer();
		listResponse.setPlaceList(placeList);
		
		Response reponse = new Response(200, "OK", listResponse);
		return reponse;
	}
	
	@RequestMapping(value = "/info/{placeId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response placeInfo(@PathVariable int placeId) {
		logger.info("placeInfo logger..");
		
		Place placeInfo = placeService.retrievePlaceById(placeId);
		
		Response reponse = new Response(200, "OK", placeInfo);
		return reponse;
	}

}
