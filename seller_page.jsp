<!doctype html>
<%@ taglib prefix="app" uri="ecart_tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/seller_page.css">
  <link rel="stylesheet" href="static/css/add_new_product.css">
  <link rel="stylesheet" href="static/css/seller_dashboard.css">
  <link rel="stylesheet" href="static/css/breadcrum.css">
  <title>ecart::home</title>
  <style>
	#container{
		min-height:500px;

	}
	#seller_page_body{
		border:1px solid ;
		height: 700px;
		padding:10px;
	}
  </style>
 </head>
 <body>
	<%@ include file="header.jsp" %>

	<%@ include file="menu.jsp" %>
	<div id="container">
		
		<div id="breadcrum">
				<div><a href="seller_page.do" id="sellerAcc" class="bred">Seller Accounts </a>&nbsp;</div> / 	
				<a href="new_seller.do" id="add_btn">+ New Seller Account</a>
		</div>
		<c:choose>
			<c:when test="${empty sellers}">
				<h3 id="msg">No Seller Account Found</h3>
			</c:when>
			<c:otherwise>
				<table id="seller_box">
					<tr id="hd">
						<th>&nbsp;</th>
						<th>Seller Account</th>
						<th>Start Date</th>
					</tr>
					
					<c:forEach var="seller" items="${sellers}">
						<tr>
							<td class="center cl1">
								<input type="checkbox" name="seller_id" value="${seller.sellerId}">
							</td>
							<td class="center cl2">
								<a href="seller_dashboard.do?seller_id=${seller.sellerId}&seller=${seller.sellerAccountName}">${seller.sellerId} - ${seller.sellerAccountName} </a>
							</td>
							<td class="center cl3">${app:format(seller.startDate)}</td>
						</tr>
					</c:forEach>
				</table>				
			</c:otherwise>
		</c:choose>
	</div>

	<%@ include file="footer.jsp" %>
 </body>
</html>
