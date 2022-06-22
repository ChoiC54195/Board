<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
		function goDelete(idx){
			/* location.href="/web/boardDelete.do?idx="+idx; */
			location.href="${cpath}/boardDelete.do/${vo.idx}";			
		}
		function goUpdate(idx){
			location.href="${cpath}/boardUpdate.do/${vo.idx}";
		}
</script>
</head>
<body>
	<div class="container">
		<h2>Spring WEB MVC01</h2>
		<div class="panel-heading">SPRING BOARD</div>
		<div class="panel-body">
			<table class="table table-bordered">
				<tr>
					<td>제목</td>
					<td>${vo.title }</td>
				</tr>
				<tr>
					<%
						pageContext.setAttribute("newLine", "\n");
					%>
					<td>내용</td>
					<td>${fn:replace(vo.contents,newLine,"<br/>")}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${vo.writer }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${vo.indate }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button class="btn btn-primary btn-sm" onclick="goUpdate(${vo.idx})">수정</button>
						<button class="btn btn-danger btn-sm"
							onclick="goDelete(${vo.idx})">삭제</button>
						<button class="btn btn-success btn-sm"
							onclick="location.href='${cpath}/boardList.do'">리스트</button>
					</td>
				</tr>
			</table>
		</div>
		<div class="panel-footer">스프링 수업</div>
	</div>
</body>
</html>