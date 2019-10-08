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
    <h1 class="mt-4 mb-3">About
      <small>Subheading</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="home">Home</a>
      </li>
      <li class="breadcrumb-item active">About</li>
    </ol>
<form>
    <!-- Intro Content -->
    <div class="row">
      <div class="col-lg-6">
        <div class="inputArea">
			 <input type="file" id="gdsImg" name="file" />
			 <div class="select_img"><img class="img-fluid rounded mb-4" src="http://placehold.it/750x450" alt=""></div>
			 
			 <script>
			  $("#gdsImg").change(function(){
			   if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) {
			     $(".select_img img").attr("src", data.target.result).width(750);        
			    }
			    reader.readAsDataURL(this.files[0]);
			   }
			  });
			 </script>
			 <%=request.getRealPath("/") %>
			</div>
        
      </div>
      <div class="col-lg-6">
        <h2><input name="menuTitle" id="inputMenuTitle" placeholder="Title" class="menu-control" /></h2>
        <p><textarea name="menuContent" id="inputMenuContent" placeholder="Content" cols="5" rows="10" class="menu-control"></textarea></p>
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
            <h4 class="card-title"><input name="menuSubFTitle" id="inputMenuTitle" placeholder="FirstSubTitle" class="menu-control" /></h4>
            <h6 class="card-subtitle mb-2 text-muted">Position</h6>
            <p class="card-text"><textarea name="menuSubFContent" id="inputMenuContent" placeholder="FirstSubContent" cols="5" rows="10" class="menu-control"></textarea></p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100 text-center">
          <img class="card-img-top" src="http://placehold.it/750x450" alt="">
          <div class="card-body">
            <h4 class="card-title"><input name="menuSubSTitle" id="inputMenuTitle" placeholder="SecondSubTitle" class="menu-control" /></h4>
            <h6 class="card-subtitle mb-2 text-muted">Position</h6>
            <p class="card-text"><textarea name="menuSubSContent" id="inputMenuContent" placeholder="SecondSubContent" cols="5" rows="10" class="menu-control"></textarea></p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100 text-center">
          <img class="card-img-top" src="http://placehold.it/750x450" alt="">
          <div class="card-body">
            <h4 class="card-title"><input name="menuSubTTitle" id="inputMenuTitle" placeholder="ThirdSubTitle" class="menu-control" /></h4>
            <h6 class="card-subtitle mb-2 text-muted">Position</h6>
            <p class="card-text"><textarea name="menuSubTContent" id="inputMenuContent" placeholder="ThirdSubContent" cols="5" rows="10" class="menu-control"></textarea></p>
          </div>
        </div>
      </div>
    </div>
    <!-- /.row -->

    <!-- Our Customers -->
    <h2>Our Customers</h2>
    <div class="row">
      <textarea name="menuFootContent" id="inputMenuContent" placeholder="FootterContent" cols="5" rows="10" class="menu-control"></textarea>
    </div>
    <!-- /.row -->
</form>
  </div>
  <!-- /.container -->
      <!-- Bootstrap core JavaScript -->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>