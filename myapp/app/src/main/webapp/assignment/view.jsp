<%@ page import="bitcamp.myapp.vo.Assignment" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>


<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>비트캠프 5기</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<%
    Assignment assignment = (Assignment) request.getAttribute("assignment");
%>
<h1>과제</h1>

<form action='/assignment/update' method='post'>
    <div>
        번호: <input readonly type='text' name='no' value=<%=assignment.getNo()%>>
    </div>
    <div>
        제목: <input type='text' name='title' value=<%=assignment.getTitle()%>>
    </div>
    <div>
        내용: <textarea name='content'><%=assignment.getContent()%></textarea>
    </div>
    <div>
        마감일: <input type='date' name='deadline' value=<%=assignment.getDeadline()%>>
    </div>
    <button>변경</button>
    <a href='/assignment/delete?no=<%= assignment.getNo()%>'>삭제</a>
</form>

<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>