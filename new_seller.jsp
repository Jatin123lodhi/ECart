<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/form.css">
  <link rel="stylesheet" href="static/css/add_new_product.css">
  <link rel="stylesheet" href="static/css/breadcrum.css">
  <link rel="stylesheet" href="static/css/new_seller.css">

  <title>ecart::signin</title>
 </head>
 <body>
  <div id="container">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	<div id="breadcrum">
				<div><a href="seller_page.do" id="sellerAcc" class="bred">Seller Accounts </a>&nbsp;</div> /
				<div>&nbsp;<a href="" class="bred">New Seller Account</a>&nbsp;</div> /
				<!-- <div>&nbsp;&nbsp;<a href="" class="bred"></a>&nbsp;&nbsp;</div> --> 	
					
	</div>
	<div class="container_body">
		
		<div class="form_box">
			<form action="new_seller.do" method="post" id="newSeller_form">
				<table class="form_table">
					<caption>Create New Seller Account</caption>
					<tr>
						<td><input type="text" placeholder="Account Name" class="input" name="account_name"></td>		
					</tr>
				
					<tr>
						<td><input type="submit" value="Create" class="button"></td>		
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
