<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}

.dataRow > div:first-child {
	border-bottom: 1px dotted #ddd;
} 
</style>
</head>
<body>
<div class="container">
	<!-- 페이지 제목 줄 -->
	<div class="row">
		<div class="col-md-12">
			<h2>게시판 리스트</h2>		
		</div>
	</div>
	<!-- 페이지 제목 줄의 끝-->
	
	<!-- 데이터 표시 줄 -->
	<div class="row">
		<div class="col-md-12">
			<!-- 리스트 -->
			<div class="list-group">
				<c:forEach items="${list}" var="vo">
					<div class="list-group-item dataRow">
						<div>
							<strong><span class="no">${vo.no}</span>.${vo.title}</strong>
							<span class="badge pull-right">${vo.hit}</span>
						</div>
						<div>
							<span>${vo.writer}</span>
							<span class="pull-right">
								<fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd"/>
							</span>
						</div>
					</div>
				</c:forEach>
			</div>		
		</div>
	</div>
	<!-- 데이터 표시 줄의 끝 -->
	
	<!-- 페이지 처리 -->
	<div class="row">
		<div class="col-md-4" style="padding: 20px">
			<div class="btn-group">
			  <button type="button" class="btn btn-default" id="writeBtn">등록</button>
			  <button type="button" class="btn btn-default" id="refalshBtn">새로고침</button>
			</div>
		</div>
		<div class="col-md-8 pull-right text-right">
			<pageNav:pageNav listURI="list.do" pageObject="${pageObject}" />
		</div>
	</div>
	<!-- 페이지 처리 끝-->
	
	
</div>
</body>
</html>