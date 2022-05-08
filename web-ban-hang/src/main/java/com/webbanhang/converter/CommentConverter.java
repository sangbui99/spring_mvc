package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.CommentDTO;
import com.webbanhang.entity.CommentEntity;
import com.webbanhang.entity.ProductEntity;
import com.webbanhang.entity.UserEntity;

@Component
public class CommentConverter {

	public CommentDTO toDto(CommentEntity entity) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(entity.getId());
		commentDTO.setCommentContent(entity.getCommentContent());
		commentDTO.setProductId(entity.getProduct().getId());
		commentDTO.setUserId(entity.getUser().getId());
		commentDTO.setUserName(entity.getUser().getUserName());
		return commentDTO;
	}
	
	public CommentEntity toEntity(CommentDTO dto, ProductEntity productEntity, UserEntity  userEntity) {
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setCommentContent(dto.getCommentContent());
		commentEntity.setProduct(productEntity);
		commentEntity.setUser(userEntity);
		return commentEntity;
	}
}
