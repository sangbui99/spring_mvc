package com.webbanhang.service;

import java.util.List;

import com.webbanhang.dto.ProductAddDTO;

public interface IProductAddService {

	ProductAddDTO save(Long productId, Long userId);
	List<ProductAddDTO> findAll(Long userId);
	void deleteByProduct(long[] ids);
}
