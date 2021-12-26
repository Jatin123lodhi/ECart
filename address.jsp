<%@ page import="models.User" %>
<%@ page import="models.City" %>
 
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/address.css">
  <link rel="stylesheet" href="static/css/form.css">
  
  <title>ecart::home</title>
 </head>
 <body>
  <div id="container">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	<div id="address_outer_div">
		<div class="form_box">
			<form action="address.do" method="post">
				<table id="signup_table">
					<caption>Address Info</caption>
					<tr>
						<td>
							<textarea placeholder="Enter your Address" name="address" rows="5" cols="30" maxlength="500" class="input_normal"	id="address">${address.address}</textarea>
						</td>		
					</tr>
					<tr>
						<td>
							<input type="hidden" name="city_id"  id="city_id">
							<input type="text" name="city" class="input" placeholder="City" autocomplete="off" id="city" value="${address.city.city}" >
							<div id="srch_res"></div> 
						</td>		
					</tr>
					<tr>
						<td><input type="text" name="pin" value="${address.pin}" placeholder="Pin" class="input"></td>		
					</tr>
		
					<tr>
						<td>
							<input type="submit" value="Save" id="signup_btn">&nbsp;&nbsp;&nbsp; 
							<a href="profpic.do" class="button">Skip</a>
						</td>
						
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
  </div>

  <script src="static/js/address.js"></script>
 </body>
</html>
