<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/form.css">
  <link rel="stylesheet" href="static/css/signup.css">

  <script src="https://www.google.com/recaptcha/api.js" async defer></script>
  <title>ecart::signup</title>
 </head>
 <body>
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	<div class="container_body">
		<%@ include file="error.jsp"%>
		<div class="form_box">
			<form action="signup.do" method="post">
				<table class="form_table">
					<caption>Create account</caption>
					
					<tr>
						<span class="userNm_err hide">Only alphabet and numeric characters allowed...!</span>	
						<td><input type="text" placeholder="UserName" class="input unm" name="username" minlength="5" maxlength="30"></td>		
					</tr>
					<tr>
						<span class="eml_err hide">*invalid email</span>	
						<td><input type="text" placeholder="Email" class="input eml" name="email"></td>		
					</tr>
					<tr>
						<span class="pass_err hide">*password and repassword should match</span>
						<td><input type="password" placeholder="Password" class="input pwd" name="password" minlength="4" maxlength="12"></td>		
					</tr>
					<tr>
						<span class="repass_err hide">*password and repassword should match</span>	
						<td><input type="password" placeholder="Repassword" class="input rpwd" name="repassword" minlength="4" maxlength="12"></td>		
					</tr>
					<tr>
						<td colspan="2" align="center">
							<div class="g-recaptcha capwidth" data-sitekey="6LeKxNwaAAAAAF-2RXheHRFx0CCX6_vPj_YgiDqk"></div>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="Signup" class="button"></td>		
					</tr>
				</table>
			</form>
		</div>
		
	</div>
	
	<%@ include file="footer.jsp" %>

  <script src="static/js/signup.js"> </script>
 </body>
</html>
