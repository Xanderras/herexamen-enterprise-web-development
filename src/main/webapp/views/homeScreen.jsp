<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filmfestival</title>
</head>
<body>
	<h1>Welkom bij het Filmfestival 2022</h1>
	<p>Hier is een lijst van alle genomineerde films:</p>
	<c:forEach var="film" items="${filmList}">
		<p><a href="filmfestival/${film}">${film}</a></p>
	</c:forEach>

</body>
</html>