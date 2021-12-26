<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/form.css">
  <link rel="stylesheet" href="static/css/add_new_product.css">
  <link rel="stylesheet" href="static/css/breadcrum.css">
  <title>ecart::home</title>
 </head>
 <body>
  <div id="container">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	
	<div id="breadcrum">
		<div><a href="seller_page.do" id="sellerAcc" class="bred">SellerAccounts</a></div> 
		
		<span>&nbsp;&nbsp;/&nbsp;&nbsp;</span>

		<div>
			<a class="bred" href="seller_dashboard.do?seller_id=${seller.sellerId}&seller=${seller.sellerAccountName}">${seller.sellerAccountName}</a>
		</div>
		
		<span>&nbsp;&nbsp;/&nbsp;&nbsp;</span>
		
		<div><a href="" id="new_pro" class="bred">Adding New Product</a></div> 
	
	</div>

	<div id="steps">
		<ul id="step_list">
			<li class="sel">1</li>  &nbsp;&nbsp;----&nbsp;&nbsp;
			<li>2</li>	&nbsp;&nbsp;----&nbsp;&nbsp;
			<li>3</li>	&nbsp;&nbsp;----&nbsp;&nbsp;
			<li>4</li>	&nbsp;&nbsp;----&nbsp;&nbsp;
			<li>5</li>	&nbsp;&nbsp;----&nbsp;&nbsp;
			<li>6</li>	&nbsp;&nbsp;----&nbsp;&nbsp;
			<li>7</li>	&nbsp;&nbsp;----&nbsp;&nbsp;
			<li>8</li>	
		</ul>
	</div>
	
	<div class="container_body">
		<div id="add_new_prod_outer_div">
			<div id="step1_box" class="form_box step_box">
				<form>
					<table class="form_table">
						<caption>New Product</caption>
						<tr>
							<td>
								<select name="category_id" >
									<option value="0">Select Product Category</option>
									<c:forEach var="category" items="${categories}">
										<option value="${category.categoryId}">${category.category}</option>	
									</c:forEach>
								</select>
							
							</td>		
						</tr>
						<tr>
							<td><input type="text" placeholder="Product Name" class="input" name="product_name"></td>		
						</tr>
						<tr>
							<td><input type="number" placeholder="Quantity" class="input" name="quantity" minlength="1"></td>		
						</tr>
						<tr>
							<td><input type="number" placeholder="Price" class="input" name="price" minlength="1"></td>		
						</tr>
						<tr>
							<td><input type="number" placeholder="Discount (%)" class="input" name="discount" minlength="1"></td>		
						</tr>
						<tr>
							<td><input type="submit" value="Save Product" class="button"></td>		
						</tr>
					</table>
				</form>
			</div>
		</div> 
		<div id="prod_desc_outer_div hide">
			<h2 class="product_title hide">Title of the product</h2>
			<div id="step2_box" class=" hide step_box form_box ">
			<form>
				<table class="form_table">
					<caption>Product Description</caption>
					<tr>
						
						<td><textarea cols="30" rows="12" name="description"></textarea></td>		
					</tr>

					<tr>
						<td><input type="submit" value="Save Product" class="button"></td>		
					</tr>
				</table>
			</form>
		</div>
		</div>
		<div id="prod_warr_outer_div hide">
			<h2 class="product_title hide">Title of the product</h2>
			<div id="step3_box" class=" hide step_box form_box">
				<form>
					<table class="form_table">
						<caption>Product Warranty</caption>
						<tr>
							<td><textarea cols="30" rows="12" name="warranty"></textarea></td>		
						</tr>
						<tr>
							<td><input type="submit" value="Save Product" class="button"></td>		
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="prod_retur_pol_outer_div hide">
			<h2 class="product_title hide">Title of the product</h2>
			<div id="step4_box" class=" step_box form_box hide">
				
				<form>
					<table class="form_table">
						<caption>Product Returning Policy</caption>
						<tr>
							
							<td><textarea cols="30" rows="12" name="returning_policy"></textarea></td>		
						</tr>
						<tr>
							<td><input type="submit" value="Save Product" class="button"></td>		
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="prod_ship_detail_outer_div hide">
			<h2 class="product_title hide">Title of the product</h2>
			<div id="step5_box" class="hide step_box form_box">
				<form>
					<table class="form_table">
						<caption>Product Shipment Details</caption>
						<tr>
							<td><textarea cols="30" rows="12" name="shipment_details"></textarea></td>		
						</tr>
						<tr>
							<td><input type="submit" value="Save Product" class="button"></td>		
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="prod_pay_detail_outer_div hide">
			<h2 class="product_title hide">Title of the product</h2>
			<div id="step6_box" class="step_box form_box hide">
				<form>
					<table class="form_table">
						<caption>Product Payment Details</caption>
						<tr>
							
							<td><textarea cols="30" rows="12" name="payment_details"></textarea></td>		
						</tr>
						<tr>
							<td><input type="submit" value="Save Product" class="button"></td>		
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="prod_poi_details_outer_div hide">
			<h2 class="product_title hide">Title of the product</h2>
			<div id="step7_box" class="step_box form_box hide">
				<form>
					<table class="form_table">
						<caption>Product Pointwise Details</caption>
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>Tile</th>
								<th>Description</th>
							</tr>
						</thead>
						<tfoot>
							<tr>		
								<td colspan="3" align="center"><input type="submit" value="Save Details" class="button"><img id="add" src="static/images/add2.png"></td>	
							</tr>
						</tfoot>
						<tbody id="tbody_part">
							<tr>
								<td class="col1">1.</td>
								<td ><input type="text"  class="col2"></td>
								<td ><textarea rows="3" cols="22" class="col3" ></textarea></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<div id="prod_pic_outer_div hide">
			<h2 class="product_title hide"></h2>
			<div id="step8_box" class="hide step_box form_box">
				<form action="product_pic_upload.do" method="post" enctype="multipart/form-data">
					<table class="form_table">
						<caption>Product Pics</caption>
						<tbody id="upload_filed_box">
							<tr>
								<td>1. <input type="file" name="product_pic" class="input_file"><td>	
							</tr>
						</tbody>
						<tr colspan="2" align="center">
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Upload pics" class="button"><span><img class="button1"src="static/images/add2.png" id="add_btn"></span>
							</td>		
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
	<input type="hidden" id="product_id" value="">
	<script src="static/js/add_product.js"></script>
	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
