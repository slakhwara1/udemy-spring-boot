<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>

	<head>
		<title> Company Home page </title>
	</head>
	
	<body>
		
		<h2> Company Home page Yooo</h2>
		<hr>
		Welcome to the company home page
		
		<p>
		
			User : <security:authentication property="principal.username"/>
			<br> <br>
			Role (s) : <security:authentication property="principal.authorities"/>
		
		</p>
		
		<security:authorize access="hasRole('MANAGER')">
		
			<hr>
		
				<p>
					<a href="${ pageContext.request.contextPath }/leaders">Leadership  meeting</a>
					(Only for manager peeps)
				</p>

		</security:authorize>
		

		<security:authorize access="hasRole('ADMIN')">
		
			<hr>
			
				<p>
					<a href="${ pageContext.request.contextPath }/systems">IT Systems meeting</a>
					(Only for Admin peeps)
				</p>
			
		</security:authorize>
			
		
		<hr>
		
		<form:form action="${ pageContext.request.contextPath }/logout" method="POST">
		
			<input type="submit" value="Logout">
		
		</form:form>
	
	</body>

</html>