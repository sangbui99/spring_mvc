package com.webbanhang.dto;

public class ProductAddDTO extends AbstractDTO<ProductAddDTO>{
	
	private String productName;
	private Long numberAdd;
	private Long numberShopp;
	private String codeImg;
	private Long productPrice;
	private Long userId;
	private Long productId;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getNumberAdd() {
		return numberAdd;
	}
	public void setNumberAdd(Long numberAdd) {
		this.numberAdd = numberAdd;
	}
	public Long getNumberShopp() {
		return numberShopp;
	}
	public void setNumberShopp(Long numberShopp) {
		this.numberShopp = numberShopp;
	}
	public String getCodeImg() {
		return codeImg;
	}
	public void setCodeImg(String codeImg) {
		this.codeImg = codeImg;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
