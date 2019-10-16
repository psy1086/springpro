<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user.css">

  <div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">Reset Password</h3>
              <form:form commandName="userDTO" action="rePasswordAction">
				<div class="form-label-group">
              		<form:input path="userId" name="userId" id="inputId" class="form-control" value="${userDTO.getUserId()}" readonly="true"/>
              		<label for="inputId">Id</label>
              	</div>
              	${userDTO.getUserId() }
				<div class="form-label-group">
              		<form:password path="userPassword" name="userPassword" id="inputPassword" class="form-control" placeholder="Password"/>
              		<label for="inputPassword">Password</label>
              	</div>
              	
              	<input type="submit" class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" value="Reset Password">
              	<div class="text-center">
	              	<a class="small" href="register">Create an Account!</a>
	              	<a class="small" href="userLogin">Already have an account? Login!</a>
	            </div>
              </form:form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
