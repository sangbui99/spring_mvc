package com.webbanhang.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String passWord;

	@Column(name = "phoneemail")
	private String phoneEmail;
	
	@Column
	private Integer status;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), 
								  inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<RoleEntity> roles = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<CommentEntity> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "useradd")
	private List<ProductAddEntity> productAdd = new ArrayList<>();
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhoneEmail() {
		return phoneEmail;
	}

	public void setPhoneEmail(String phoneEmail) {
		this.phoneEmail = phoneEmail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<ProductAddEntity> getProductAdd() {
		return productAdd;
	}

	public void setProductAdd(List<ProductAddEntity> productAdd) {
		this.productAdd = productAdd;
	}
	
	
}