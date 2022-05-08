package com.webbanhang.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.service.IProductService;

@Controller(value = "productControllerOfWeb")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/san-pham", method = RequestMethod.GET)
	public ModelAndView productPage(@RequestParam(value = "price", required = false) String price) {		
		ModelAndView mav = new ModelAndView("web/product");	
		if (price != null) {			
			mav.addObject("model", productService.findAllPrice(price));		
		}
	    return mav;			
		
	}
}
