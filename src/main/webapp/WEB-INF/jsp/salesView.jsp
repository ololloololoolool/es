<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

	<head>
		<link href="/resources/css/allPage.css" rel="stylesheet" type="text/css">
		<meta name="color-scheme" content="light dark">
		<meta charset="UTF-8">
		<title>Vendite</title>
	</head>
	
	<body>
	
		<header></header>
		
		<main>
			
			<h1>PRODOTTI <span> VENDUTI</span></h1>
			
			<c:forEach items="${books}" var="book">
			
				libro ${book[0]} ha venduto ${book[1]} copie <br/>
			
			</c:forEach>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>