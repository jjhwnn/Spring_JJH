<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img src="/spring0201/resources/googlelogo.png"><br>
<img src="/spring0201/img/googlelogo.png"> <%-- 디렉토리를 스프링에 알려줘야 한다 --%>
</body>
</html>
