package com.jungle.resort.exceptions;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(MultipartException.class)
	String handleFileException(Model model, Exception ex) {
		// return your json insted this string.
		model.addAttribute("errorMessage", new String("File size exceeded"));
	    return "redirect:/addroom/servererror";
	}
}
