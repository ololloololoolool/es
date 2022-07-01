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
		<title>Carrello</title>
	</head>
	
	<body>
	
		<header></header>
		
		<main>
			
			<h1> <span> CARRELLO</span></h1>
			
			<c:set var="total" value="0"></c:set>
			
			<c:forEach items="${books}" var="book">
			
				<p>
					"${book.libro.titolo}" scritto da ${book.libro.autore}. x${book.quantita}. Prezzo:
					<fmt:formatNumber type = "currency" value =
						"${ ( book.libro.prezzo - (book.libro.prezzo * book.libro.sconto / 100) ) * book.quantita}"/>
						<br/>
					<c:set var="total" value="${total + ( book.libro.prezzo - (book.libro.prezzo * book.libro.sconto / 100) ) * book.quantita }"></c:set>
					<a href="<c:url value="/cart/remove/${book.id}"/>">ELIMINA</a>
				</p>
			</c:forEach>
			
			<c:if test="${not empty books}">
				<p>Totale: ${total}</p>
				
				<a href="<c:url value="/shop"/>">ACQUISTA</a>
			</c:if>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>