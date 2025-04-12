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
				<c:if test="${sessionScope.auth eq 'admin'}">
				<li>
					<a class="nav-link" href="enter">Enter</a>
				</li>
				</c:if>
			</ul>
		</div>
		<div class="d-flex me-3">
		<c:choose>
			<c:when test="${sessionScope.auth eq 'admin'}">
			<a href="logout" class="btn btn-danger">Logout</a>
			</c:when>
			<c:otherwise>
			<a href="login" class="btn btn-primary">Login</a>
			</c:otherwise>
		</c:choose>
		</div>
	</nav>
	<section class="container-fluid p-3">
		<p class="h2">List of Comments</p>
		<table class="table my-3">
			<thead>
				<tr>
					<th scope="col" class="shrink-col">番号</th>
					<th scope="col" class="shrink-col">タイトル</th>
					<th scope="col" class="stretch-col">内容</th>
					<th scope="col" class="shrink-col">編集</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="comment" items="${list}">
				<tr>
					<th scope="row" class="align-middle">${comment.cno}</th>
					<td class="align-middle">${comment.title}</td>
					<td>${comment.content}</td>
					<td class="align-middle">
					<c:if test="${sessionScope.auth eq 'admin'}">
						<a href="edit?no=${comment.cno}" class="btn btn-secondary">編集</a>
						<a href="delete?no=${comment.cno}" class="btn btn-danger">削除</a>
					</c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>