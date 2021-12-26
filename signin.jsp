<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/form.css">
  <script src="https://www.google.com/recaptcha/api.js" async defer></script>
  <title>ecart::signin</title>
 </head>
 <body>
  <div id="container">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	<div class="container_body">
		<div class="form_box">
			<form action="signin.do" method="post">
				<table class="form_table">
					<caption>Login</caption>
					<tr>
						<td><input type="text" placeholder="Username/Email" class="input" name="unm_email"></td>		
					</tr>
					<tr>
						<td><input type="password" placeholder="Password" class="input" name="password"></td>		
					</tr>
					<tr align="center">
						<td >
							<div class="g-recaptcha capwidth" data-sitekey="6LeKxNwaAAAAAF-2RXheHRFx0CCX6_vPj_YgiDqk"></div>
						</td>
					</tr>					
					<tr>
						<td><input type="submit" value="Login" class="button"></td>		
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
