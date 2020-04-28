package com.grupo04.caseritaPeru.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo04.caseritaPeru.constant.ViewConstant;
import com.grupo04.caseritaPeru.entity.TM_UsuariosSC;
import com.grupo04.caseritaPeru.service.TM_UsuarioSCService;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@Autowired
	@Qualifier("tm_UsuarioSCServiceImpl")
	private TM_UsuarioSCService tm_UsuarioSCService;

	@GetMapping("/login")
	public String cargarLoginFrm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout,
			@RequestParam(name = "error2", required = false) String error2,
			@RequestParam(name = "msg", required = false) String msg) {
		String url = "";
		LOG.info("METODO: cargarLoginFrm() --- PARAMETROS: ERROR=" + error + " logout=" + logout);

		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (!user.equals("anonymousUser")) {
			url = "redirect:/" + ViewConstant.PRINCIPAL_FORM;
		} else {
			model.addAttribute("error", error);
			model.addAttribute("error2", error2);
			model.addAttribute("logout", logout);
			model.addAttribute("msg", msg);
			url = ViewConstant.LOGIN_FORM;
		}
		return url;
	}

	@GetMapping({ "/loginsuccess", "/" })
	public String loginCheck() {
		LOG.info("METODO loginCheck()");
		return "redirect:/" + ViewConstant.PRINCIPAL_FORM;
	}

	@GetMapping("/principal")
	public String principalFRM(Model model) {
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		model.addAttribute("usuario", usuario.getUsername());
		LOG.info("METODO: principalFRM() --- PARAMETROS: usuario=" + usuario.getUsername());

		return ViewConstant.PRINCIPAL_FORM;
	}

	@GetMapping("/addUsuFrm")
	public String registrarUsuarioFRM(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		String url = "";
		LOG.info("METODO: registrarUsuarioFRM() --- PARAMETROS: ERROR=" + error + " logout=" + logout);

		TM_UsuariosSC usuario = new TM_UsuariosSC();
		model.addAttribute("usuario", usuario);
		url = ViewConstant.REGISTRO_FORM;
		return url;
	}

	@PostMapping("/addUsu")
	public String addUsuario(@ModelAttribute(name = "usuario") TM_UsuariosSC usuario, Model model) {
//		LOG.info("METODO: registrarUsuarioFRM() --- PARAMETROS: usuario=" + usuario.toString());
		String url = "";
		usuario.setEstado(true);
		TM_UsuariosSC tm_usuario = tm_UsuarioSCService.save(usuario);

		if (tm_usuario != null) {
			url="redirect:/login?msg=1";
		}

		return url;
	}

}
