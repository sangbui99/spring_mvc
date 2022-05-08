package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.CategoryDTO;
import com.webbanhang.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(entity.getId());
		categoryDTO.setCategoryCode(entity.getCategoryCode());
		categoryDTO.setCategoryName(entity.getCategoryName());
		return categoryDTO;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryCode(dto.getCategoryCode());
		categoryEntity.setCategoryName(dto.getCategoryName());
		return categoryEntity;
	}
}