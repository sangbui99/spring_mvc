package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.converter.CommentConverter;
import com.webbanhang.dto.CommentDTO;
import com.webbanhang.entity.CommentEntity;
import com.webbanhang.entity.ProductEntity;
import com.webbanhang.entity.UserEntity;
import com.webbanhang.repository.CommentRepository;
import com.webbanhang.repository.ProductRepository;
import com.webbanhang.repository.UserRepository;
import com.webbanhang.service.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentConverter commentConverter;
	
	@Override
	public List<CommentDTO> findAllByProductId(Long productId) {
		List<CommentDTO> commentDTOs = new ArrayList<>();
		List<CommentEntity> commententities = commentRepository.findAll();
		for (CommentEntity item: commententities) {	
			if (item.getProduct().getId() == productId) {
				CommentDTO commentDTO = commentConverter.toDto(item);
				commentDTOs.add(commentDTO);
			}			
		}
		return commentDTOs;
	}

	@Override
	@Transactional
	public CommentDTO save(CommentDTO commentDTO) {
		CommentEntity commentEntity = new CommentEntity();	
		ProductEntity productEntity = productRepository.findOne(commentDTO.getProductId());
		UserEntity  userEntity = userRepository.findOne(commentDTO.getUserId());
		
		commentEntity = commentConverter.toEntity(commentDTO, productEntity, userEntity);
		    return commentConverter.toDto(commentRepository.save(commentEntity));
		
	}

}
