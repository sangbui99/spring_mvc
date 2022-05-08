package com.webbanhang.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webbanhang.entity.ProductAddEntity;
import com.webbanhang.repository.ProductAddRepository;

@Component
public class CheckCartUtil {
	
	@Autowired
	private ProductAddRepository productAddRepository;
	
	public boolean check(Long productId, Long userId) {
		List<ProductAddEntity> productAddEntities = productAddRepository.findAll();		
		for (ProductAddEntity item: productAddEntities) {
			if (item.getProductadd().getId() == productId && item.getUseradd().getId() == userId) {
				return true;
			}else {
               
			}
		}			
		return false;
		
	}

}
