package project.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.model.Place;
import project.services.PlaceService;

/**
 * Handles requests for the application home page.
 */
@Controller
@Component
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	PlaceService placeService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/placelist", method = RequestMethod.GET)
	public ModelAndView placeList(){
		logger.info("placelist logger..");
		List<Place> placeList = placeService.retrieveAllPlace();
		
		ModelAndView modelAndView = new ModelAndView("placelist");
		modelAndView.addObject("placelist", placeList);
		return modelAndView;
	}
	
	@RequestMapping(value = "/place", method = RequestMethod.GET)
	public ModelAndView placeInfo(HttpServletRequest request){
		logger.info("placelist logger..");
		
		int placeId = Integer.parseInt(request.getParameter("id"));
		Place placeInfo = placeService.retrievePlaceById(placeId);
		
		ModelAndView modelAndView = new ModelAndView("placeInfo");
		modelAndView.addObject("placeInfo", placeInfo);
		return modelAndView;
	}
	
}
