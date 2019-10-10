<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/border.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css">

<!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">menuFView
      <small>Subheading</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="home">Home</a>
      </li>
      <li class="breadcrumb-item active">About</li>
    </ol>
<form:form commandName="menuDTO" action="menuWriteAction" enctype="multipart/form-data">
    <!-- Intro Content -->
    <div class="row">
      <div class="col-lg-6">
        <div class="inputArea">
			 <div class="select_img">
				<img src="${menu.gdsImg }" class="oriImg" />
			</div>
		</div>
      </div>
      <div class="col-lg-6">
        <h2><form:input path="menuTitle" id="inputMenuTitle" placeholder="Title" class="menu-control" value="${menu.menuTitle }" readonly="true"/></h2>
        <p><form:textarea path="menuContent" class="menu-control" value="${menu.menuContent }" readonly="true" />
        </p>
      </div>
    </div>
    <!-- /.row -->

    <!-- Team Members -->
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
    <!-- /.row -->

    <!-- Our Customers -->
    <h2>Our Customers</h2>
    <div class="row">
     	<form:textarea path="menuFootContent" class="menu-control" value="${menu.menuFootContent }" readonly="true" />
    </div>
    <!-- /.row -->
    <a class="btn btn-lg btn-success btn-block text-uppercase font-weight-bold mb-2" href="menuF?page=${criteria.page }&perPageNum=${criteria.perPageNum}">back</a>
</form:form>
  </div>
  <!-- /.container -->
      <!-- Bootstrap core JavaScript -->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>