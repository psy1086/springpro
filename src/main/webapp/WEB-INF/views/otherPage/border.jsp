<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">

<div class="container">
	<header class="jumbotron my-4">
	</header>
	<h2>Border</h2>
	${userId}
	<table class="table talbe-hover">
		<thead>
			<tr>
				<th>Num</th>
				<th>Title</th>
				<th>Id</th>
				<th>Date</th>
				<th>Like</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty borderList }">
					<tr>
						<td colspan="5">Empty</td>
					</tr>
				</c:when>
				<c:when test="${!empty borderList }">
					<c:forEach var="list" items="${borderList }">
						<tr>
							<td><c:out value="${list.borderId }" /></td>
							<td><c:out value="${list.borderTitle }" /></td>
							<td><c:out value="${list.userId }" /></td>
							<td><c:out value="${list.borderDate }"/></td>
							<td><c:out value="${list.borderLike }"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>
		<a class="page-link" href="#">Aff</a> 
		<a class="page-link" href="#">Next</a> 
	<a href="borderWrite"><button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2">Write</button></a>
</div>