<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/border.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/border2.css">
<div class="container">
		<header class="jumbotron my-4">
		</header>
		<div class="container-fluid">
			<div class="row no-gutter">
				<div class="col-md-8 col-lg-6">
					<h3 class="login-heading mb-4">View</h3>
					<form:form commandName="borderDTO" action="borderUpdate">
						<div class="form-label-group">
							<form:input path="borderTitle" id="inputBorderTitle" placeholder="Title" class="boder-control" value="${list.borderTitle }" readonly="true"/>
							
						</div>
						<div class="form-label-group">
							<form:textarea path="borderContent" id="inputBorderContent" rows="20" class="boder-control" value="${list.borderContent }" readonly="true"/>
						</div>	
						<input type="button" class="btn btn-lg btn-danger btn-block text-uppercase font-weight-bold mb-2" value="Back" onClick="history.back(-1)">
						 <c:if test="${borderDTO.userId eq login.userId}">
						 	<input class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" value="Update">
							<a class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" href="borderUpdate?borderId=${borderDTO.borderId }">Update</a>
						</c:if>
					</form:form>
				</div>
			</div>
		</div>
	</div>