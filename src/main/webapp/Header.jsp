<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CMail</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
		<div class="navbar-brand">CMail</div>
  <c:if test="${not empty sessionScope.userObject}">    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#" style="color:white;"> ${userObject.firstName} ${userObject.lastName}</a></li>
      <li><a href="LogoutController" style="color:white;"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
    </c:if>   
		 <c:if test="${empty sessionScope.userObject}">    
 	<ul class="nav navbar-nav navbar-right">
       <li><a href="/GMail/Login.jsp" style="color:white"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
    </ul>
     </c:if>
		
	</nav>