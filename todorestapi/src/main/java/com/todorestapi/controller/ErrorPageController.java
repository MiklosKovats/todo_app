package com.todorestapi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

@Controller
public class ErrorPageController implements ErrorController {

	private static final String ERR_PATH = "/error";
	private ErrorAttributes errorAttributes;
		
	public ErrorPageController(ErrorAttributes errorAttributes) {	
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping(ERR_PATH)
	public String error(Model model, HttpServletRequest request) {		
		ServletWebRequest sWRequest = new ServletWebRequest(request);
		Map<String, Object> error = this.errorAttributes.getErrorAttributes(sWRequest, true);
		
		model.addAttribute("timestamp", error.get("timestamp"));
		model.addAttribute("error", error.get("error"));
		model.addAttribute("message", error.get("message"));
		model.addAttribute("path", error.get("path"));
		model.addAttribute("status", error.get("status"));
		
		return "error";
	}
	
	public String getErrorPath() {
		return ERR_PATH;
	}
	
}
