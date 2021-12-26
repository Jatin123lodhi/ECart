<!doctype html>
<html lang="en">
 <head>
  <style>
		
  </style>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <!-- <link rel="stylesheet" href="static/css/form.css"> -->
  <link rel="stylesheet" href="static/css/add_new_product.css">
  <link rel="stylesheet" href="static/css/seller_dashboard.css">
  <link rel="stylesheet" href="static/css/breadcrum.css">


   
 
  <title>ecart::signup</title>
 </head>
 <body>
	<%@ include file="header.jsp" %>
		
	<%@ include file="menu.jsp" %>
	<div id="container">
		
		<div id="breadcrum">
				<div><a href="seller_page.do" id="sellerAcc" class="bred">Seller Accounts </a>&nbsp;</div> /
				<div>&nbsp;<a href="" class="bred">Seller Dashboard</a>&nbsp;</div> /	
				<div>&nbsp;<a href="" class="bred">All Products</a>&nbsp;</div> /	
				<a href="add_new_product.do" id="add_btn"> Add New Product +</a>	
		</div>
		<input type="hidden" id="seller_id" value="${seller.sellerId}">
		<div id="outer_box">
			<div id="dashboard">
				<div id="all_products" class="dashboard_tab active">All Products</div>
				<div id="orders" class="dashboard_tab inactive">Orders</div>
				<div id="prod_rtn" class="dashboard_tab inactive">Product Return</div>		
			</div>
			
			<div id="dashboard_info">
				
				<div id="blk1" class="info_div">
					
					<div id="no_rec">No record found</div>	
					
				</div>
				<div id="blk2" class="info_div hide">orders</div>
				<div id="blk3" class="info_div hide">product return</div>
			</div>
		</div>
		

		
		
	</div>
	<%@ include file="footer.jsp" %>
  <script src="static/js/seller_dashboard.js"> </script>
 </body>
</html>
