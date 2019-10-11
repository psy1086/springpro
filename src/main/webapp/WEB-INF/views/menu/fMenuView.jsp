<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/border.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css">


<div class="container">
	<h1 class="mt-4 mb-3">menuFView
		<small>Subheading</small>
	</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item">
			<a href="home">Home</a>
		</li>
		<li class="breadcrumb-item active">View</li>
	</ol>
	<div class="container-fluid">
		<div class="row no-gutter">
			<form:form commandName="menuDTO" action="menuWriteAction" enctype="multipart/form-data">
				<div class="row">
					<div class="col-lg-6">
						<div class="inputArea">
							<img src="${pageContext.request.contextPath}/${menuDTO.gbsThumbImg }" class="oriImg"/>
						</div>
					</div>
					<div class="col-lg-6">
						<h2><form:input path="menuTitle" id="inputMenuTitle" placeholder="Title" class="menu-control" value="${menu.menuTitle }" readonly="true"/></h2>
						<p><form:textarea path="menuContent" class="menu-control" value="${menu.menuContent }" readonly="true" /></p>
					</div>
				</div>
	
				<h2>Our Team</h2>
				<div class="row">
					<div class="col-lg-4 mb-4">
						<div class="card h-100 text-center">
							<img class="card-img-top" src="http://placehold.it/750x450" alt="">
							<div class="card-body">
								<h4 class="card-title"><form:input path="menuSubFTitle" class="menu-control" value="${menu.menuSubFTitle }" readonly="true" /></h4>
								<h6 class="card-subtitle mb-2 text-muted">Position</h6>
								<p class="card-text"><form:textarea path="menuSubFContent" class="menu-control" value="${menu.menuSubFContent }" readonly="true" /></p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 mb-4">
						<div class="card h-100 text-center">
							<img class="card-img-top" src="http://placehold.it/750x450" alt="">
							<div class="card-body">
								<h4 class="card-title"><form:input path="menuSubSTitle" class="menu-control" value="${menu.menuSubSTitle }" readonly="ture" /></h4>
								<h6 class="card-subtitle mb-2 text-muted">Position</h6>
								<p class="card-text"><form:textarea path="menuSubSContent" class="menu-control" value="${menu.menuSubSContent }" readonly="true" /></p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 mb-4">
						<div class="card h-100 text-center">
							<img class="card-img-top" src="http://placehold.it/750x450" alt="">
							<div class="card-body">
								<h4 class="card-title"><form:input path="menuSubTTitle" class="menu-control" value="${menu.menuSubTTitle }" readonly="true" /></h4>
								<h6 class="card-subtitle mb-2 text-muted">Position</h6>
								<p class="card-text"><form:textarea path="menuSubTContent" class="menu-control" value="${menu.menuSubTContent }" readonly="true" /></p>
							</div>
						</div>
					</div>
				</div>
	
				<h2>Our Customers</h2>
				<div class="row">
					<form:textarea path="menuFootContent" class="menu-control" value="${menu.menuFootContent }" readonly="true" />
				</div>
				<div class="div-group">
					<a class="btn btn-lg btn-success btn-block text-uppercase font-weight-bold mb-2" href="menuF?page=${criteria.page }&perPageNum=${criteria.perPageNum}">back</a>
				</div>
				<div class="div-group">
					<c:if test="${menuDTO.userId eq login.userId}">
						<a class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" href="borderUpdate?borderId=${borderDTO.borderId }">update</a>
					</c:if>
				</div>
				<div class="div-group">
					<c:if test="${menuDTO.userId eq login.userId}">
						<a class="btn btn-lg btn-danger btn-block text-uppercase font-weight-bold mb-2" href="borderDelete?borderId=${borderDTO.borderId }" >delete</a>
					</c:if>
				</div>
			</form:form>
		</div>
	</div>
</div>

  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>