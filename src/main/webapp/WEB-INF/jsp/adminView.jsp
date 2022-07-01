<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

	<head>
		<link href="/resources/css/allPage.css" rel="stylesheet" type="text/css">
		<meta name="color-scheme" content="light dark">
		<meta charset="UTF-8">
		<title>Admin</title>
	</head>
	
	<body>
	
		<header></header>
		
		<main>
			
			<h1>OPERAZIONI <span> ADMIN</span></h1>

			<a href="<c:url value="/addBookView"/>">AGGIUNGI LIBRO</a>
			<a href="<c:url value="/salesView"/>">VENDITA PRODOTTI</a>
			<a href="<c:url value="/clientHistoryView"/>">ORDINI CLIENTI</a>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>