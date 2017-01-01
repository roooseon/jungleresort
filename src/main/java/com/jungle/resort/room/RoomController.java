package com.jungle.resort.room;

import java.security.Principal;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.jungle.resort.domain.Room;

@Controller
public class RoomController {
	@Autowired
	RoomService roomService;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/addroom", method = RequestMethod.GET)
	public String addRoom(@ModelAttribute("room") Room room) {
		return "AddRoom";
	}

	@RequestMapping(value = "/addroom", method = RequestMethod.POST)
	public String addRoom(@Valid Room room, BindingResult result, Model model) {
		String view = "redirect:/allroomslist";

		if (!result.hasErrors()) {
			try {
				roomService.addRoom(room);
			} catch (Exception e) {
				model.addAttribute("errorMessage", new String("Duplicate entry found"));
				view = "AddRoom";						
			}

		} else {
			view = "AddRoom";
		}
		return view;
	}
	
	@RequestMapping(value = "/updateroom/{id}", method = RequestMethod.GET)
	public String updateRoom(@ModelAttribute("room") Room room, @PathVariable("id") int id, Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		return "UpdateRoom";
	}

	@RequestMapping(value = "/updateroom/{id}", method = RequestMethod.POST)
	public String updateRoom(@Valid Room room, BindingResult result, Model model,  @PathVariable("id") int id) {
		room.setId(id);		
		String view = "redirect:/allroomslist";

		if (!result.hasErrors()) {
			try {
				roomService.addRoom(room);
			} catch (Exception e) {
				model.addAttribute("errorMessage", new String("Duplicate entry found"));
				view = "UpdateRoom";						
			}

		} else {
			view = "UpdateRoom";
		}
		return view;
	}
	
	
	@RequestMapping(value = "/availableroomslist", method = { RequestMethod.GET, RequestMethod.POST })
	public String availableRoomsList(Map<String, Object> model, Principal p, Model m) {
		model.put("availablerooms", roomService.getAllAvailableRoom());
		return "AvailableRoomsList";
	}

	@RequestMapping(value = "/allroomslist", method = { RequestMethod.GET })
	public String allRoomsList(Map<String, Object> model, Model m) {
		model.put("allrooms", roomService.getAllRoom());
		return "AllRoomsList";
	}

	@RequestMapping("/deleteroom/{id}")
	public String removeRoom(@PathVariable("id") int id) {
		roomService.deleteRoom(id);
		return "redirect:/allroomslist";
	}

}
