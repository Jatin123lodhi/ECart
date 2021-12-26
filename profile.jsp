<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/form.css">
  <link rel="stylesheet" href="static/css/profile.css">
  <title>ecart::profile</title>
 </head>
 <body>
  <div id="container">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	<div id="profile_outer_div">
		<div class="form_box">
			
			<form action="profile.do" method="post">
				<table class="form_table">
					<caption>User details</caption>
					<tr>
						<td><input type="text" value="${user.firstName}" name="firstname" placeholder="FirstName" class="input"></td>		
					</tr>
					<tr>
						<td><input type="text" value="${user.middleName}" name="middlename" placeholder="MiddleName" class="input"></td>		
					</tr>
					<tr>
						<td><input type="text" value="${user.lastName}" name="lastname" placeholder="LastName" class="input"></td>		
					</tr>
					<tr>
						<td><input type="number" value="${user.mobile}" name="mobile" placeholder="Mobile" class="input"></td>		
					</tr>
					<tr>
						<td><input type="date" value="${user.dob}" name="dob" placeholder="Date of Birth" class="input"></td>		
					</tr>
					<tr>
						<td>
							<input type="submit" value="Save" id="signup_btn">&nbsp;&nbsp;&nbsp; 
							<a href="address.do" class="button">Next</a>
						</td>
						
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
  </div>  
 </body>
</html>





