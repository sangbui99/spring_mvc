<%@ page import="com.webbanhang.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark my-menu">
	<div class="container">
		<a class="navbar-brand" href="#"> <img
			src="<c:url value='/template/web/images/logo1.png'/>" width="120px"
			alt="">
		</a>
		<button class="navbar-toggler d-lg-none " type="button"
			data-toggle="collapse" data-target="#mainmenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon "></span>
		</button>
		<div class="collapse navbar-collapse my-navbar" id="mainmenu">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
				    href="<c:url value='/trang-chu'/>">Trang chủ</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value='/gioi-thieu'/>">Giới thiệu</a></li>
				<li class="nav-item dropdown">
                    <a class="nav-link" href="#" data-toggle="dropdown">Sản phẩm</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="<c:url value='/san-pham?price=up'/>">Chọn theo giá tăng dần</a>
                        <a class="dropdown-item" href="<c:url value='/san-pham?price=down'/>">Chọn hàng giá giảm dần</a>
                    </div>
                </li>
				<li class="nav-item "><a class="nav-link"
					href="<c:url value='/gio-hang'/>">Giỏ hàng</a></li>
					
				<security:authorize access="isAnonymous()">	
				<li class="nav-item "><a class="nav-link"
					href="<c:url value='/dang-nhap'/>">Đăng nhập/Đăng ký</a></li>
				</security:authorize>
							
				<security:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="#">Wellcome
							<%=SecurityUtils.getPrincipal().getUsername()%></a></li>
					<li class="nav-item "><a class="nav-link"
					href="<c:url value='/thoat'/>">Đăng xuất</a></li>
				</security:authorize>
			</ul>

			<form class="form-inline my-2 my-lg-0" action="<c:url value='/chi-tiet'/>" method="get">
				<input class="form-control mr-sm-2" name="name" type="text"
					placeholder="Tìm kiếm">
				<button class="btn btn-outline-dark bg-danger my-2 my-sm-2"
					type="submit">Tìm kiếm</button>
			</form>
		</div>
	</div>
</nav>