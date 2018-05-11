<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 블로그 해더 -->
		<div id="header">
			 <h1><a href=""> ${blogVo.blogTitle}</a></h1>
			<ul>
				<!-- 로그인 전 메뉴 -->
				<c:choose>
				<c:when test="${authUser eq null}">
				<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
				</c:when>
				<c:otherwise>
				<!-- 로그인 후 메뉴 -->
				
				<li><a href="${pageContext.request.contextPath}/logoutBlogMain">로그아웃</a></li>
				<%-- <c:when test="${authUser eq blogVo.blogTitle}"> --%>
				<li><a href="${pageContext.request.contextPath}/${blogVo.id}/admin/basic">내블로그 관리</a></li>
			<%-- 	</c:when> --%>
				 	
				 </c:otherwise>
				 </c:choose>	
			</ul>
		</div>
		
		