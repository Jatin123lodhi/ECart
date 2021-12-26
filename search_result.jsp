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
  <link rel="stylesheet" href="static/css/search_result.css">


  <script src="https://www.google.com/recaptcha/api.js" async defer></script>
 
  <title>ecart::signup</title>
 </head>
 <body>
	<%@ include file="header.jsp" %>
		
	<%@ include file="menu.jsp" %>
	<div id="container">
		
		
		<input type="hidden" id="search_key" value="${param.search}">
		
		<div id="outer_box">
			<div id="msg">Items added succussfully</div>
			<div id="dashboard_info">
				<div id="allprods_ttl">Search Results for -  </div>
				<div id="blk1" class="info_div">
					<div id="no_rec">No record found</div>	
					
				</div>
				
			</div>
		</div>
		

		
		
	</div>
	<%@ include file="footer.jsp" %>
  <script src="static/js/search_result.js"> </script>
 </body>
</html>
