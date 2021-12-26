<!-- <div id="header">
	<img src="static/images/logo.png" id="logo">
	<span id="auth_ctrl_box">
		<a href="signin.do">Sin-In</a>
		<a href="signup.do">Sin-Up</a>
		<a href="#">Sign-Out</a>
	</span>
</div> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
		<span id="wlc_user">
			<c:if test="${user!=null}">
				Welcome ${user.userName}
			</c:if>
		</span>
		<a href="index.jsp"><img src="static/images/home1.png" id="home"/></a>
		<span id="ecart_ttl"><a href="index.jsp">E-Cart</a></span>
		<c:choose>	
			<c:when test="${user==null}">
				<span id="icon"><img src="static/images/prof1.png" id="img1"/><img src="static/images/cart5.png" id="img2"/></span>
				<span id="cartNo">1</span>
			</c:when>
			<c:otherwise>
				<span id="icon"><img src="static/images/cart5.png" id="img1"/><img src="showprofpic.do" id="img3"/></span>
			</c:otherwise>
		</c:choose>

		
		
		<span id="img"><a href="index.jsp"><img src="static/images/logo1.png"/></a></span>
		<div id="slogan">Anything you want | Everything we have</div>
		<c:choose>	
			<c:when test="${user==null}">
				<span id="register"><a href="signup.jsp">Register</a> | <a href="signin.jsp">Login</a></span>
			</c:when>
			<c:otherwise>
				<span id="register"><a href="signup.jsp">Register</a> | <a href="signout.do">Logout</a></span>
			</c:otherwise>
		</c:choose>
		
		
		
</div>