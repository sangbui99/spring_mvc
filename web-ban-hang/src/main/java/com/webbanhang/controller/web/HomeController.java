package com.webbanhang.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.service.IProductService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView showList() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("model1", productService.findAllWeb1());
		mav.addObject("model2", productService.findAllWeb2());
		mav.addObject("model3", productService.findAllWeb3());
		return mav;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "login", required = false) String login) {
		ModelAndView mav = new ModelAndView("web/login");
		if (login != null) {
			login = "Đăng nhập đã rồi mới được vào giỏ hàng";
			mav.addObject("login", login);
		}		
		return mav;
	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
