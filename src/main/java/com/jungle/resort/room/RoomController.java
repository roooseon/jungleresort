package com.jungle.resort.room;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/addroom/servererror", method = RequestMethod.GET)
	public String addRoom(@ModelAttribute("room") Room room, Model model, @RequestParam String errorMessage) {
		model.addAttribute("imageType", errorMessage);
		return "AddRoom";
	}

	public boolean checkJPEG(MultipartFile tempImg) {
		String fileName = tempImg.getContentType().toLowerCase();
		return fileName.equals("image/jpg") || fileName.equals("image/jpeg") || fileName.equals("image/png");
	}

	@RequestMapping(value = "/addroom", method = RequestMethod.POST)
	public String addRoom(@Valid Room room, BindingResult result, Model model, @RequestParam MultipartFile tempImg,
			Exception exception) throws IOException {

		String view = "AddRoom";

		if (tempImg.getSize() <= 2097152) {
			if (checkJPEG(tempImg)) {

				room.setImage(tempImg.getBytes());

				if (!result.hasErrors()) {
					try {
						roomService.addRoom(room);
						view = "redirect:/allroomslist";
					} catch (Exception e) {
						model.addAttribute("errorMessage", new String("Duplicate entry found"));
						
					}

				} 
			} else {
				model.addAttribute("imageType", new String("Select a file in .jpg, .jpeg or .png format"));
				
			}
		} else {
			model.addAttribute("imageType", new String("File size exceeded"));
			
		}
		
		return view;
	}

	@RequestMapping(value = "/updateroom/{id}", method = RequestMethod.GET)
	public String updateRoom(@ModelAttribute("room") Room room, @PathVariable("id") int id, Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		return "UpdateRoom";
	}

	@RequestMapping(value = "/updateroom/{id}", method = RequestMethod.POST)
	public String updateRoom(@Valid Room room, BindingResult result, Model model, @PathVariable("id") int id, @RequestParam MultipartFile tempImg,
			Exception exception) throws IOException {

		
		room.setId(id);

		String view = "AddRoom";

		if (tempImg.getSize() <= 2097152) {
			if (checkJPEG(tempImg)) {

				room.setImage(tempImg.getBytes());

				if (!result.hasErrors()) {
					try {
						roomService.addRoom(room);
						view = "redirect:/allroomslist";
					} catch (Exception e) {
						model.addAttribute("errorMessage", new String("Duplicate entry found"));
						//view = "AddRoom";
					}

				} 
			} else {
				model.addAttribute("imageType", new String("Select a file in .jpg, .jpeg or .png format"));
				//view = "AddRoom";
			}
		} else {
			model.addAttribute("imageType", new String("File size exceeded"));
			//view = "AddRoom";

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
