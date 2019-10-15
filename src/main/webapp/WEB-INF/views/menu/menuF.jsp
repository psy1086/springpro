  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Page Content -->
<div class="container">
	<header class="jumbotron my-4">
	</header>
	<h2>menuF</h2>
   <div class="row">
   <c:choose>
   	<c:when test="${empty menuList }">
   		Empty
   	</c:when>
   	<c:when test="${!empty menuList }">
   		<c:forEach var="menu" items="${menuList }">
   			
      			<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
       				<div class="card h-100">
          			<a href="fMenuView${pagination.makeQuery(pagination.criteria.page)}&menuId=${menu.menuId}"><img class="card-img-top" src="${pageContext.request.contextPath}/${menu.gbsThumbImg }" alt=""></a>
          			<div class="card-body">
            			<h4 class="card-title">
              			<a href="fMenuView${pagination.makeQuery(pagination.criteria.page)}&menuId=${menu.menuId}"><c:out value="${menu.menuTitle }" /></a>
            			</h4>
            			<p class="card-text"><c:out value="${menu.menuContent }" /></p> <hr />
            			<p class="card-text">
            				<c:out value="${menu.userId }" />
            				<img src="${pageContext.request.contextPath}/resources/content/view.png"><c:out value="${menu.menuViewCnt }" />
            			</p>
          			</div>
        		</div>
      		</div>
      		
   		</c:forEach>
   	</c:when>
   </c:choose>
</div>
    <!-- Pagination -->
    <ul class="pagination">
		<c:if test="${pagination.prev }">
			<li><a class="page-link" href="menuF${pagination.makeQuery(pagination.startPage-1) }">Prev</a></li>
		</c:if> 
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage }" var="idx">
			<li <c:out value="${pagination.criteria.page == idx ? 'class=active' : '' }" />>
				<a href="menuF${pagination.makeQuery(idx) }">${idx }</a>
			</li>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0 }">
			<li><a class="page-link" href="menuF${pagination.makeQuery(pagination.endPage+1) }">Next</a></li> 
		</c:if>
	</ul>
	<c:if test="${not empty login }">
		<a href="fWrtie"><button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2">Write</button></a>
	</c:if>
  </div>
