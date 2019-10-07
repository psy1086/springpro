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
					<img src="${pageContext.request.contextPath}/resources/content/like2.png">${borderDTO.replyCnt }
				</span>
				<form:form commandName="borderDTO" action="borderUpdate">
					<div class="form-label-group">
						<form:input path="borderTitle" id="inputBorderTitle" placeholder="Title" class="boder-control" value="${list.borderTitle }" readonly="true"/>
					</div>
					<div class="form-label-group">
						<form:textarea path="borderContent" id="inputBorderContent" rows="20" class="boder-control" value="${list.borderContent }" readonly="true"/>
					</div>	
					<div class="div-group">
						<a class="btn btn-lg btn-success btn-block text-uppercase font-weight-bold mb-2" href="border?page=${criteria.page }&perPageNum=${criteria.perPageNum}">back</a>
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

		<!-- Reply Form {s} -->
			<c:if test="${not empty login }">

					<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
						<div class="row">
							<div class="col-sm-10">
								<textarea name="replyContent" id="replyContent" class="form-control" rows="3" placeholder="댓글을 입력해 주세요"></textarea>
							</div>
							<div class="col-sm-2">
								<input type="text" name="borderId" class="form-control" id="borderId" value="${borderDTO.borderId}" readonly>
								<input name="userId" class="form-control" id="userId" value="${login.userId }" readonly></input>
								<button type="button" class="btn btn-sm btn-primary replyWrite" id="replyWrite" style="width: 100%; margin-top: 10px">Write</button>
							</div>
						</div>
	
					</div>

			</c:if>
			<!-- Reply Form {e} -->
			<!-- Reply List {s}-->
			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
				<h6 class="border-bottom pb-2 mb-0">Reply list</h6>
				<div id="replyList"></div>
			</div> 
			<!-- Reply List {e}-->
	</div>
</div>

<script>
	function showReplyList() {
		var url ="replyList";
		var paramData = {"borderId":"${borderDTO.borderId}"};
		var borderId = ${borderDTO.borderId};
		
		$.ajax({
			type:'POST',
			url : url,
			data : paramData,
			dataType : 'json',
			success : function(result) {
				var htmls = "";
				if(result.length < 1) {
					htmls += "등록된 댓글이 없습니다";
				}else {
					$(result).each(function(){
						htmls += '<div class="media text-muted pt-3" id="replyId' + this.replyId + '">';
	                    htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
						htmls += '<title>Placeholder</title>';
						htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
						htmls += '<text x="50%" fill="#007bff" by=".3em">32x32</text>';
						htmls += '</svg>';
						htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
	                    htmls += '<span class="d-block">';
	                    htmls += '<strong class="text-gray-dark">' + this.userId + '</strong>';
	                    htmls += '<span style="padding-left: 7px; font-size: 9pt">';
	                   	htmls += this.replyId
	                   	htmls += borderId
	                    htmls += '<a href="javascript:void(0)" onclick="replyUpdate(' + this.replyId + ', \'' + this.userId + '\', \'' + this.replyContent + '\' )" style="padding-right:5px">수정</a>';
	                    htmls += '<a href="javascript:void(0)" onclick="replyDelete(' + this.replyId + ',\'' + borderId + '\')" >삭제</a>';
	                    htmls += '</span>';
	                    htmls += '</span>';
	                    htmls += this.replyContent;
	                    htmls += '</p>';
	                    htmls += '</div>';
					});
				}
				$("#replyList").html(htmls);
			}
		});
	}
	
	$(function(){
	    
		showReplyList();
	    
	});
	
	//Reply Write
	$(document).on('click','#replyWrite', function() {
		var writeUrl = "replyWrite";
		
		var replyContent = $('#replyContent').val();
		var userId = $('#userId').val();
		
		var paramData = JSON.stringify({"replyContent" : replyContent,
				"userId" : userId,
				"borderId" : "${borderDTO.borderId}"
			});
		var headers = {"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"};
		$.ajax({
			url : writeUrl,
			headers : headers,
			data : paramData,
			type : 'POST',
			dataType : 'text',
			success : function(result) {
				showReplyList();
				
				$('#replyContent').val('');
			},
			error : function(error) {
				console.log("Error :" + error);
			}
		});
		
	});
	
	//Reply Update
	function replyUpdate(replyId, userId, replyContent){
		var htmls = "";
		htmls += '<div class="media text-muted pt-3" id="replyId' + replyId + '">';
		htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
		htmls += '<title>Placeholder</title>';
		htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
		htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
		htmls += '</svg>';
		htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
		htmls += '<span class="d-block">';
		htmls += '<strong class="text-gray-dark">' + userId + '</strong>';
		htmls += '<span style="padding-left: 7px; font-size: 9pt">';
		htmls += '<a href="javascript:void(0)" onclick="replyUpdateAction(' + replyId + ', \'' + userId + '\')" style="padding-right:5px">저장</a>';
		htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';
		htmls += '</span>';
		htmls += '</span>';		
		htmls += '<textarea name="editContent" id="editContent" class="form-control" rows="3">';
		htmls += replyContent;
		htmls += '</textarea>';
		
		htmls += '</p>';
		htmls += '</div>';
		
		$('#replyId' + replyId).replaceWith(htmls);
		$('#replyId' + replyId + ' #editContent').focus();
	}
	
	function replyUpdateAction(replyId, userId) {
		var updateUrl = "replyUpdate"
		var replyEditContent = $('#editContent').val();
		var paramData = JSON.stringify({"replyContent": replyEditContent, "replyId": replyId
		});
		
		var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
		
		$.ajax({
			url: updateUrl
			, headers : headers
			, data : paramData
			, type : 'POST'
			, dataType : 'text'
			, success: function(result){
                console.log(result);
				showReplyList();
			}
			, error: function(error){
				console.log("에러 : " + error);
			}
		});
	}
	
	function replyDelete(replyId,borderId){
		console.log("replyId : " + replyId);
		console.log("borderId : " + borderId);
		var paramData ={"replyId":replyId,
				"borderId" : borderId};
		var deleteUrl = "replyDelete";
		$.ajax({
			url: deleteUrl
			, data : paramData
			, type : 'POST'
			, dataType : 'text'
			, success: function(result){
				showReplyList();
			}
			, error: function(error){
				console.log("에러 : " + error);
			}
		});
	}
	
</script>
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
 	<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<%-- 	<script src="<c:url value="/resources/vendor/jquery/handlebars-v4.3.1.js" />>"></script>    --%>