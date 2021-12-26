<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/product.css">
  <link rel="stylesheet" href="static/css/breadcrum.css">
  <title>ecart::signin</title>
 </head>
 <body>
  <div>
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	<div class="container_body">
		<div id="breadcrum">
				<!-- <div><a href="seller_page.do" id="sellerAcc" class="bred">Seller Accounts </a>&nbsp;</div> /
				<div>&nbsp;<a href="" class="bred">Seller Dashboard</a>&nbsp;</div> /		
				<div>&nbsp;<a href="" class="bred">Products</a>&nbsp;</div>	 -->
		</div>
		<input type="hidden"  id="productId" value="${product.productId}"/>
		<h2 id="prod_name">${product.productName}</h2>
		<div id="main_box">
			<div id="pics">
				<div id="side_pics">
					 
				</div>
				<div id="focus_pic">
					 
				</div>

			</div>
			<div id="info">
				<div id="price">Price&nbsp; - Rs.${product.price*(100-product.discount)/100}</div>
				<!-- <div id="mrp">MRP&nbsp; - <s> Rs.${product.price}</s></div>
				<div id="seller">Seller&nbsp;- ${product.seller.sellerAccountName}</div> -->
				<div id="all_tabs">
					<div class="tabs desc">Description</div>
					<div class="tabs">Warranty</div>
					<div class="tabs">Shipment Details</div>
					<div class="tabs">Payment Details</div>
					<div class="tabs">Returning Policy</div>
					<div class="tabs">Discount</div>
				</div>
				<div id="details">
					<div class="odtl show">	
						${product.description}
					</div>	
					<div class="odtl hide">	
						${product.warranty}
					</div>	
					<div class="odtl hide">	
						${product.shipmentDetails}
					</div>	
					<div class="odtl hide">	
						${product.paymentDetails}
					</div>
					<div class="odtl hide">	
						${product.returningPolicy}
					</div>
					<div class="odtl hide">	
						${product.discount}%
					</div>
				</div>
				<table id="prod_point_tbl">
					<caption>Product Details</caption>

				</table>
			</div>
		</div>

	</div>

	<%@ include file="footer.jsp" %>
	<script src="static/js/product.js"></script>
  </div>
 </body>
</html>
