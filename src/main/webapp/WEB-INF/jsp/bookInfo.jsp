<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

	<head>
		<link href="/resources/css/allPage.css" rel="stylesheet" type="text/css">
		<meta name="color-scheme" content="light dark">
		<meta charset="UTF-8">
		<title>Info</title>
	</head>
	
	<body>
	
		<header></header>
		
		<main>
			
			<h1>INFO <span> LIBRO</span></h1>
			
			<p>
				${book.isbn} <br/>
				${book.titolo} <br/>
				${book.autore} <br/>
				${book.editore} <br/>
				${book.genere} <br/>
				<fmt:formatNumber type = "currency"
					value = "${book.prezzo - (book.prezzo * book.sconto / 100)}"/>
			</p>
			
			<form action="/cart/add" method="post">
				
				<input type="number" max="${book.copie}" min="1" name="copie" value="1"/>
				
				<input type="hidden" name="isbn" value="${book.isbn}"/>
				
				<input type="submit" value="CARRELLIZZA" id="submit"/>
				
			</form>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>