<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>
	<div class="container">
		<h2>Spring WEB MVC01</h2>
		<div class="panel-heading">SPRING BOARD</div>
		<form action="${cpath}/boardUpdate.do" method="post">
			<input type="hidden" name="idx" value="${vo.idx}">
			<div class="panel-body">
				<table class="table table-bordered">
					<tr>
						<td>제목</td>
						<td><input type="text" class="form-control" name="title"
							value="${vo.title}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows="7" class="form-control" name="contents">${vo.contents}</textarea></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" value="${vo.writer}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" class="btn btn-primary btn-sm">수정</button>
							<button type="reset" class="btn btn-danger btn-sm">취소</button>
							<button type="button" class="btn btn-success btn-sm" onclick="location.href='${cpath}/boardList.do'">리스트</button>
						</td>
					</tr>
				</table>

			</div>
		</form>
		<div class="panel-footer">스프링 수업</div>
	</div>
</body>
</html>