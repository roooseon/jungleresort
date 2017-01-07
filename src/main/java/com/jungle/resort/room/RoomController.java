package com.jungle.resort.room;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jungle.resort.domain.Images;
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
	public String addRoom(@Valid Room room, BindingResult result, Model model,
			@RequestParam List<MultipartFile> tempImg2, Exception exception) throws IOException {

		String view = "AddRoom";
		boolean flagSize = false;
		boolean flagType = false;

		for (int i = 0; i < tempImg2.size(); i++) {
			MultipartFile tempImg23 = tempImg2.get(i);
			if (tempImg23.getSize() <= 2097152) {
				if (checkJPEG(tempImg23)) {
					Images image = new Images();
					image.setImage3(tempImg23.getBytes());
					room.getImage2().add(image);
				} else {
					System.out.println("Type not satisfied");
					flagType = true;
					break;
				}
			} else {
				System.out.println("File size exceeded");
				flagSize = true;
				break;
			}
		}
		if (!flagSize) {
			if (!flagType) {
				if (!result.hasErrors()) {
					try {
						roomService.addRoom(room);
						view = "redirect:/allroomslist";
					} catch (Exception e) {
						model.addAttribute("errorMessage", new String("Duplicate entry found"));
					}
				}
			} else {
				model.addAttribute("imageType2", new String("Select a file in .jpg, .jpeg or .png format"));
			}

		} else {
			model.addAttribute("imageType2", new String("File size exceeded"));

		}
		return view;
	}

	@RequestMapping(value = "/updateroom/{id}", method = RequestMethod.GET)
	public String updateRoom(@ModelAttribute("room") Room room, @PathVariable("id") int id, Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		return "UpdateRoom";
	}

	@RequestMapping(value = "/updateroom/{id}", method = RequestMethod.POST)
	public String updateRoom(@Valid Room room, BindingResult result, Model model,
			@RequestParam("uploadImage") List<MultipartFile> tempImg2, @PathVariable("id") int id, Exception exception)
			throws IOException {

		boolean flagSize = false;
		boolean flagType = false;
		String view = "UpdateRoom";

		System.out.println("======================");
		System.out.println(tempImg2.size());
		
		System.out.println("DEEEPENDRA");
		room.setId(id);
		
		if (tempImg2.size() == 0) {
			room.setImage2(roomService.getRoomById(id).getImage2());
		}

		else {
			for (int i = 0; i < tempImg2.size(); i++) {
				MultipartFile tempImg23 = tempImg2.get(i);
				if (tempImg23.getSize() <= 2097152) {
					if (checkJPEG(tempImg23)) {
						Images image = new Images();
						image.setImage3(tempImg23.getBytes());
						room.getImage2().add(image);
					} else {
						System.out.println("Type not satisfied");
						flagType = true;
						break;
					}
				} else {
					System.out.println("File size exceeded");
					flagSize = true;
					break;
				}
			}
		}
		if (!flagSize) {
			if (!flagType) {
				if (!result.hasErrors()) {
					try {
						roomService.addRoom(room);
						view = "redirect:/allroomslist";
					} catch (Exception e) {
						model.addAttribute("errorMessage", new String("Duplicate entry found"));
					}
				}
			} else {
				model.addAttribute("imageType2", new String("Select a file in .jpg, .jpeg or .png format"));
			}

		} else {
			model.addAttribute("imageType2", new String("File size exceeded"));
		}
		return view;
	}

	@RequestMapping(value = "/availableroomslist", method = { RequestMethod.GET, RequestMethod.POST })
	public String availableRoomsList(Map<String, Object> model, Principal p, Model m) {
		model.put("availablerooms", roomService.getAllAvailableRoom());
		return "AvailableRoomsList";
	}

	@RequestMapping(value = "/allroomslist", method = { RequestMethod.GET })
	public String allRoomsList(Map<String, Object> model, Model m) throws UnsupportedEncodingException {
		byte[] encodeBasee64;
		String base64EncodeImage;
		for (Room room : roomService.getAllAvailableRoom()) {
			for (Images image : room.getImage2()) {
				encodeBasee64 = Base64.encode(image.getImage3());
				base64EncodeImage = new String(encodeBasee64, "UTF-8");
				image.setEncodeImage3(base64EncodeImage);
			}
		}

		model.put("allrooms", roomService.getAllRoom());
		return "AllRoomsList";
	}

	@RequestMapping("/deleteroom/{id}")
	public String removeRoom(@PathVariable("id") int id) {
		roomService.deleteRoom(id);
		return "redirect:/allroomslist";
	}

}
