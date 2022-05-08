package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.converter.ProductAddConverter;
import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.entity.ProductAddEntity;
import com.webbanhang.entity.ProductEntity;
import com.webbanhang.entity.UserEntity;
import com.webbanhang.repository.ProductAddRepository;
import com.webbanhang.repository.ProductRepository;
import com.webbanhang.repository.UserRepository;
import com.webbanhang.service.IProductAddService;
import com.webbanhang.util.CheckCartUtil;

@Service
public class ProductAddService implements IProductAddService{
	
	@Autowired
	private ProductAddRepository productAddRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductAddConverter productAddConverter;
	
	@Autowired
	private CheckCartUtil checkCartUtil;
	
	@Override
	@Transactional
	public ProductAddDTO save(Long productId, Long userId) {
		ProductAddEntity productAddEntity = new ProductAddEntity();	
			ProductEntity productEntity = productRepository.findOne(productId);
			UserEntity  userEntity = userRepository.findOne(userId);
			if (checkCartUtil.check(productId, userId)) {
				return null;
			} else {
				productAddEntity = productAddConverter.toBetweenEntity(productEntity, productAddEntity, userEntity);
			    return productAddConverter.toDto(productAddRepository.save(productAddEntity));
			}
				
			
	}

	@Override
	public List<ProductAddDTO> findAll(Long userId) {
		List<ProductAddDTO> productAddDTOs = new ArrayList<>();
		List<ProductAddEntity> productAddEntities = productAddRepository.findAll();
		for (ProductAddEntity item: productAddEntities) {
			if (item.getUseradd().getId() == userId) {
				ProductAddDTO productAddDTO = productAddConverter.toDto(item);
				productAddDTOs.add(productAddDTO);
			}
		}
		return productAddDTOs;
	}

	@Override
	@Transactional
	public void deleteByProduct(long[] ids) {
		List<ProductAddEntity> productAddEntities = productAddRepository.findAll();
		for (ProductAddEntity item: productAddEntities) {
			for (long id: ids) {
				if (item.getProductadd().getId() == id) {
					productAddRepository.delete(item.getId());
				}
			}
			
		}
	}	

}
