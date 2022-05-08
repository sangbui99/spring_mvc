package com.webbanhang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productadd")
public class ProductAddEntity extends BaseEntity {
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "numberadd")
	private Long numberAdd;
	
	@Column(name = "numbershopp")
	private Long numberShopp;

	@Column(name = "codeimg")
	private String codeImg;
	
	@Column(name = "productprice")
	private Long productPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity useradd;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productadd;
	
	
	
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

	public UserEntity getUseradd() {
		return useradd;
	}

	public void setUseradd(UserEntity useradd) {
		this.useradd = useradd;
	}

	public ProductEntity getProductadd() {
		return productadd;
	}

	public void setProductadd(ProductEntity productadd) {
		this.productadd = productadd;
	}
	
	
}