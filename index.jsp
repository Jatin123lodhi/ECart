<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/index.css">
  <title>ecart::home</title>
 </head>
 <body>

	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	
	<div id="banner">
		<img src="static/images/banner.jpg" id="id_banner"/>
	</div>
	<h1 id="id_categ">Categories</h1>
	<div class="main1">
		<div class='row1'>
			  <a href="view_product.do?product_id=17" id="product_nm">
				<img src="static/images/cc1.webp" class="prod_img"/>
			</a>  
		</div> 
		<div class='row1'>
		 <a href="view_product.do?product_id=16" id="product_nm">
			<img src="static/images/cc3.webp" class="prod_img"/>
		</a> 
		</div> 
		<div class='row1 shirt'>
			
				<img src="static/images/cc2.webp" class="prod_img"/>
			
		</div> 
		<div class='row2' style="width:650px;">
			<a href="view_product.do?product_id=16" id="product_nm">
				<img src="static/images/cc4.webp" class="prod_img"/>
			</a>
		</div> 
		<div class='row2' style="width:390px;">
			<a href="view_product.do?product_id=16" id="product_nm">
				<img src="static/images/cc5.webp" class="prod_img"/>
			</a>
		</div>
		<div class='row2' style="width:390px;">
			<a href="view_product.do?product_id=16" id="product_nm">
				<img src="static/images/cc6.webp" class="prod_img"/>
			</a>
		</div>
	</div>
	
	<div id="main2_head">
		<span>Top Seller</span>
	</div>

	<div id="main2">
		<div>1</div>
		<div>2</div> 
		<div>3</div> 
		<div>4</div> 
	</div>

	<div id="main3">
		<div>Banner</div>
		<div>Brands</div> 	 
	</div>
	<div id="main4_head">
		<h3>Brands & Products</h3>
	</div>

	<div id="main4">
		<div class="main4_div">1</div>
		<div class="main4_div">2</div> 
		<div class="main4_div">3</div> 	 
		<div class="main4_div">4</div> 	 
		<div class="main4_div">5</div> 	 
		<div class="main4_div">6</div> 	 
		<div class="main4_div">7</div> 	 
		<div class="main4_div">8</div> 	 
	</div>	
	
	<%@ include file="footer.jsp" %>
	<script src="static/js/index.js"></script>
 </body>
</html>
