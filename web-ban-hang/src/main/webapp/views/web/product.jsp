<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>

<html>
<head>
  <meta charset="UTF-8">
  <title>Thái minh</title>
</head>

<body>

	<div id="banner" class="carousel slide" data-ride="carousel">   
        <img src="<c:url value='/template/web/images/banner7.jpg'/>" alt="">
    </div>

    <!-- chia lưới -->   
       
    <div class="container my-chu">
        <h2 class="mb-5 mt-5 text-center">Các sản phẩm mới ra mắt</h2>
    </div>
    
    <div class="container my-5">
        <div class="row">
        <c:forEach var="item" items="${model}">
          <div class="col-md-4 col-sm-6 mb-3">
            <div class="card text-center my-border">
                <img class="card-img-top" src="<c:url value='/template/web/images/${item.codeImg}'/>" alt="">    
                      <h3 class="card-title my-chu ">${item.productName}</h3>
                      <h4 class="card-text my-chu"> giá: ${item.productPrice}đ</h4> 
                       <c:url var="detailURL" value="/chi-tiet">
						   <c:param name="id" value="${item.id}"/>															
				       </c:url>
                       <a data-toggle="tooltip" data-target="#modelId" class="btn btn-sm btn-info mx-2" href='${detailURL}'>Chi tiết</a>                     
                       <c:url var="cartURL" value="/gio-hang">
						  <c:param name="id" value="${item.id}"/>															
				       </c:url>
                       <a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2" href='${cartURL}'>Thêm và đi đến giỏ hàng</a> 
            </div>  
          </div>
        </c:forEach>	                 
        </div>
    </div>
    
    <!-- footer -->
    
</body>

</html>