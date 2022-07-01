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
		<title>Ordini</title>
	</head>
	
	<body>
	
		<header></header>
		
		<main>
			
			<h1> STORICO <span> ORDINI</span></h1>
			
			<c:forEach items="${ordini}" var="ordine">
			
				in data
				${ordine.dataOrdine.getDayOfMonth()}/${ordine.dataOrdine.getMonthValue()}/${ordine.dataOrdine.getYear()}
				hai speso
				<fmt:formatNumber type = "currency" value ="${ordine.totale}"/>
				per acquistare: <br/>
				<c:forEach items="${ordine.libri}" var="libro">
			
					${libro.libro.titolo}
					di ${libro.libro.autore} x ${libro.quantita}
					pagando
					<fmt:formatNumber type = "currency" value =
						"${ libro.prezzoInFaseDiAcquisto -
							(libro.prezzoInFaseDiAcquisto * libro.scontoInFaseDiAcquisto / 100) }"/>
					a pezzo 
					
					<br/>
					
				</c:forEach>
			
				<br/>
				<br/>
			
			</c:forEach>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>