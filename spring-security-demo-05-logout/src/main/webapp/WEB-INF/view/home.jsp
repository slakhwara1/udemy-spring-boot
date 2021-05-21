<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<head>
		<title> Company Home page </title>
	</head>
	
	<body>
		
		<h2> Company Home page Yooo</h2>
		<hr>
		Welcome to the company home page
		
		<form:form action="${ pageContext.request.contextPath }/logout" method="POST">
		
			<input type="submit" value="Logout">
		
		</form:form>
	
	</body>

</html>