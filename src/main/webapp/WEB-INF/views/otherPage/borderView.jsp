<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<span>
						<img src="${pageContext.request.contextPath}/resources/content/view.png">${borderDTO.borderView+1 }
						<a class="btn-lg font-wright-bold mb-2" href="javascript:like_func();"><img src="${pageContext.request.contextPath}/resources/content/like.png" id="like_img">${borderDTO.borderLike }</a>
					</span>
					
					<form:form commandName="borderDTO" action="borderUpdate">
						<div class="form-label-group">
							<form:input path="borderTitle" id="inputBorderTitle" placeholder="Title" class="boder-control" value="${list.borderTitle }" readonly="true"/>
							
						</div>
						<div class="form-label-group">
							<form:textarea path="borderContent" id="inputBorderContent" rows="20" class="boder-control" value="${list.borderContent }" readonly="true"/>
						</div>	
						<div class="div-group">
							<!-- <input type="button" class="btn btn-lg btn-success btn-block text-uppercase font-weight-bold mb-2" value="back" onClick="history.back(-1)"> -->
							<a class="btn btn-lg btn-success btn-block text-uppercase font-weight-bold mb-2" href="border?page=${criteria.page }&perPageNum=${criteria.perPageNum}">back</a>
							<%-- <input type="button" class="btn btn-lg btn-warning btn-block text-uppercase font-weight-bold bm-2" value="like" onClick="location.href='borderLike?borderId=${borderDTO.borderId}'"> --%>
							<%-- <a class="btn btn-lg btn-warning btn-block text-uppercase font-weight-bold mb-2" href="borderLike?borderId=${borderDTO.borderId }">Like</a> --%>
							<!-- <a href='javascript:like_func()' class="btn btn-lg btn-warning btn-block text-uppercase font-weight-bold mb-2">like</a> -->
							
						</div>	
						<div class="div-group">
							 <c:if test="${borderDTO.userId eq login.userId}">
								<a class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" href="borderUpdate?borderId=${borderDTO.borderId }">update</a>
								
							</c:if>
						</div>
						<div class="div-group">
							 <c:if test="${borderDTO.userId eq login.userId}">
								<a class="btn btn-lg btn-danger btn-block text-uppercase font-weight-bold mb-2" href="borderDelete?borderId=${borderDTO.borderId }" >delete</a>
							</c:if>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		/* function like_func() {
			var borderLike = ${like_img};
			
			if(borderLike>0) {
				console.log(borderLike);
				$("#borderLike").prop("src","/resouces/content/like2.png");
				$(".borderLike").prop('userId',borderLike)
			}
			else {
				console.log(borderLike);
				$("#borderLike").prop("src","/resouces/content/like.png");
				$(".borderLike").prop('userId', borderLike)
			}
			
			$(".borderLike").on("click", function() {
				var that = $(".borderLike");
				
				var sendData = {'borderId ' : '${borderDTO.borderId}', 'borderLike' : that.prop('userId')};
				$.ajax({
					url : 'borderLike',
					type : 'POST',
					data : sendData,
					success : function(data) {
						that.prop('userId',data);
						if(data==1) {
							$('#borderLike').prop("src","/resouces/content/like2.png");
						}
						else {
							$('#borderLike').prop("src","/resouces/content/like.png");
						}
					}
				});
			});
		} */
	</script>
	