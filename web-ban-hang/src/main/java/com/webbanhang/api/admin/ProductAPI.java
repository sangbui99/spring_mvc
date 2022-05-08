package com.webbanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.ProductDTO;
import com.webbanhang.service.IProductAddService;
import com.webbanhang.service.IProductService;

@RestController(value = "productAPIOfAdmin")
public class ProductAPI {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductAddService productAddService;
	
	@PostMapping("/api/product")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return productService.save(productDTO);
	}
	
	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		return productService.save(productDTO);
	}
	
	@DeleteMapping("/api/product")
	public void deleteProduct(@RequestBody long[] ids) {
		productAddService.deleteByProduct(ids);
		productService.delete(ids);
	}
}