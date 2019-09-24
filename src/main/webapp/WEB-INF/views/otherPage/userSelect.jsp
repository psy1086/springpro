<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table talbe-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Pw</th>
				<th>name</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList }" var="user">
				<tr>
					<td>${user.userId }</td>
					<td>${user.userPassword }</td>
					<td>${user.userName } </td>
					<td>${user.userEmail }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
