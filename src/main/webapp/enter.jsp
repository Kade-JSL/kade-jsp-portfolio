<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String auth = (String) session.getAttribute("auth");
	if(!"admin".equals(auth)) {
		response.sendRedirect("login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
<link href="/static/css/custom.css" rel="stylesheet"/>
<script src="/static/js/bootstrap.min.js"></script>

<title>Portfolio-JSP</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Test Page</span>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link" aria-current="page" href="main">List</a>
				</li>
				<li>
					<a class="nav-link active" href="enter">Enter</a>
				</li>
			</ul>
		</div>
		<div class="d-flex me-3">
			<a href="logout" class="btn btn-danger">Logout</a>
		</div>
	</nav>
	<section class="container-fluid p-3">
		<span class="h2">Enter a Comment</span>
		<form class="mt-3" method="post" action="enter" style="max-width:800px;">
			
			<div class="mb-3">
				<label for="title" class="form-label">タイトル</label>
				<input type="text" class="form-control" id="title" name="title"/>
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">内容</label>
				<textarea class="form-control" id="content" name="content"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">作成</button>
		</form>
	</section>
</body>
</html>