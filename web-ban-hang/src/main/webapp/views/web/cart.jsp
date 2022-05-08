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

    <div class="container py-5">
        <h2 class="mb-5">Giỏ hàng của bạn</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th><input type="checkbox" id="checkAll"></th>
                    <th>STT</th>
                    <th>Tên Sản phẩm</th>
                    <th>Ảnh Sản phẩm</th>
                    <th>Số Lượng Mua</th>
                    <th>Giá Sản phẩm</th>
                    <th>Số lượng đã mua</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${model.listResult}">
                <tr>
                    <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                    <td>${item.id}</td>
                    <td>${item.productName}</td>
                    <td>                   
                        <img src="<c:url value='/template/web/images/${item.codeImg}'/>" alt="" width="80">
                    </td>                 
                    <td>
                        <input type="number" style="width:60px; text-align: center;" value="0">
                    </td>
                    <td>${item.productPrice}</td>
                    <td>${item.numberShopp}</td>
                    <td>
                        <c:url var="detailURL" value="/chi-tiet">
						    <c:param name="id" value="${item.productId}"/>															
				        </c:url>
                        <a data-toggle="tooltip" data-target="#modelId" class="btn btn-sm btn-success mx-2" href='${detailURL}'>Chi tiết sản phẩm</a>
                        <!-- <a href="" class="btn btn-sm btn-success mx-2">Mua hàng</a>
                        <a href="" class="btn btn-sm btn-danger mx-2 my-2">Hủy đơn hàng</a> -->
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <hr>
        <div class="row">
            <div class="col-md-7">
                <form class="form-inline">
                    <div class="form-group">
                        <input type="text" name="" style="width:250px" class="form-control" placeholder="Mã giảm giá">
                    </div>
                    <button class=" btn btn-success">Áp dụng </button>
                </form>
            </div>
            <div class="col-md-5">
                <h4>Tổng tiền: 230.000đ</h4>
                <p>
                    Shipper: 50.000đ
                </p>
                <h3>Thanh toán: 280.000đ</h3>
                <button class=" btn btn-success">Đi đến thanh toán</button>
            </div>
        </div>
    </div>
</body>

</html>