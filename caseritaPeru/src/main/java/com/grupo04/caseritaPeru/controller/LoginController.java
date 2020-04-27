package com.grupo04.caseritaPeru.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo04.caseritaPeru.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/login")
	public String cargarLoginFrm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		String url="";
		LOG.info("METODO: cargarLoginFrm() --- PARAMETROS: ERROR=" + error + " logout=" + logout);
		
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (!user.equals("anonymousUser")) {
            url="redirect:/"+ViewConstant.PRINCIPAL_FORM;
		} else {
			model.addAttribute("error", error);
			model.addAttribute("logout", logout); 
			url= ViewConstant.LOGIN_FORM;
		}
		return url;
	}

	@GetMapping({"/loginsuccess", "/" })
	public String loginCheck() {
		LOG.info("METODO loginCheck()");
		return "redirect:/"+ViewConstant.PRINCIPAL_FORM;
	}
	
	@GetMapping("/principal")
	public String principalFRM(Model model) {
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("usuario", usuario.getUsername());
		return ViewConstant.PRINCIPAL_FORM;
	}
	

}
