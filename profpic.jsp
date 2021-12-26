<%@ page import="models.User" %>
<%@ page import="models.City" %>
 
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/form.css">
  <link rel="stylesheet" href="static/css/address.css">
  <link rel="stylesheet" href="static/css/profile_pic.css">
  <title>ecart::home</title>
 </head>
 <body>
  <div id="container">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	<div id="profpic_outer_div">
		<div class="form_box">
			<form action="profpic.do" method="post" enctype="multipart/form-data" >
				<table id="signup_table">
					<caption>Profile Pic</caption>
					<tr>
						<td>
							<input type="file" name="profpic" class="input" id="profpic_fld"> 
						</td>		
					</tr>
					  
					<tr>
						<td>
							<input type="submit" value="Upload" id="signup_btn">&nbsp;&nbsp;&nbsp; 
							<a href="index.jsp" class="button">Skip</a>
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
