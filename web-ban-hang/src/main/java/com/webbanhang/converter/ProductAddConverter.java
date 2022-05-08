package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.entity.ProductAddEntity;
import com.webbanhang.entity.ProductEntity;
import com.webbanhang.entity.UserEntity;

@Component
public class ProductAddConverter {

	public ProductAddDTO toDto(ProductAddEntity entity) {
		ProductAddDTO productAddDTO = new ProductAddDTO();
		productAddDTO.setId(entity.getId());
		productAddDTO.setProductName(entity.getProductName());
		productAddDTO.setNumberAdd(entity.getNumberAdd());
		productAddDTO.setNumberShopp(entity.getNumberShopp());
		productAddDTO.setCodeImg(entity.getCodeImg());
		productAddDTO.setProductPrice(entity.getProductPrice());
		productAddDTO.setUserId(entity.getUseradd().getId());
		productAddDTO.setProductId(entity.getProductadd().getId());
		return productAddDTO;
	}
	
	public ProductAddEntity toEntity(ProductAddDTO dto) {
		ProductAddEntity productAddEntity = new ProductAddEntity();	
		productAddEntity.setProductName(dto.getProductName());
		productAddEntity.setNumberAdd(dto.getNumberAdd());
		productAddEntity.setNumberShopp(dto.getNumberShopp());
		productAddEntity.setCodeImg(dto.getCodeImg());
		productAddEntity.setProductPrice(dto.getProductPrice());
		return productAddEntity;
	}
	
	public ProductAddEntity toBetweenEntity(ProductEntity entity, ProductAddEntity productAddEntity, UserEntity  userEntity) {
		Long a = (long) 1;
		Long b = (long) 0;
		productAddEntity.setProductName(entity.getProductName());
		productAddEntity.setNumberAdd(a);
		productAddEntity.setNumberShopp(b);
		productAddEntity.setCodeImg(entity.getCodeImg());
		productAddEntity.setProductPrice(entity.getProductPrice());	
		productAddEntity.setUseradd(userEntity);
		productAddEntity.setProductadd(entity);
		return productAddEntity;
	}
}
