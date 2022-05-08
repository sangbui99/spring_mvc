package com.webbanhang.service;

import java.util.List;

import com.webbanhang.dto.CommentDTO;

public interface ICommentService {	
	List<CommentDTO> findAllByProductId(Long productId);
	CommentDTO save(CommentDTO dto);

}
