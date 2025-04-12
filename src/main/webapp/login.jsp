<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="static/css/bootstrap.min.css" rel="stylesheet"/>
<link href="static/css/custom.css" rel="stylesheet"/>
<script src="static/js/bootstrap.min.js"></script>

<title>Portfolio-JSP</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Test Page</span>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="main">List</a>
				</li>
			</ul>
		</div>
	</nav>
	<section class="container-fluid p-3">
		<span class="h2">Login</span>
		<form class="mt-3" method="post" action="login" style="max-width:400px;">
			
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<input type="text" class="form-control" id="id" name="id"/>
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">Password</label>
				<input type="password" class="form-control" id="pw" name="pw"/>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
			<c:if test="${not empty loginError}">
				<span class="text-danger">${loginError}</span>
			</c:if>
		</form>
	</section>
</body>
</html>