<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/app.css"rel="stylesheet"
	type="text/css"></link>
<title>Merchandise Tracking System</title>
</head>
<body class="security-app">
	<div class="details">
	<h2>Merchandise Tracking System</h2>
	</div>
	<div class="lc-block">		
		<div class="alert-danger">
			<h3>You do not have permission to access this page!</h3>
                        <img src="css/Hal9000.webp" height="100px" border="5" />
                        <audio autoplay><source src="css/cantdo.mp3" type="audio/mpeg"></audio>
		</div>
		<form action="logout" method="post" >
			<input type="submit" class="button red big" value="Sign in as different user" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>		
	</div>
        <jsp:include page="topBanner.jsp" />
</body>
</html>