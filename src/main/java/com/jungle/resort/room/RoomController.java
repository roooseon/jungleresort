package com.jungle.resort.room;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jungle.resort.domain.Room;

@Controller
public class RoomController {
	@Autowired
	RoomService roomService;
	
//	@Autowired
//	ServletContext servletContext;
	
	//@ResponseBody
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String start(){
	
		System.out.println("You are here");
		return "login";
	}
}
