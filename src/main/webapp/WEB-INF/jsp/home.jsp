<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

	<head>
		<link href="/resources/css/allPage.css" rel="stylesheet" type="text/css">
		<meta name="color-scheme" content="light dark">
		<meta charset="UTF-8">
		<title>Cerca</title>
	</head>
	
	<body>
	
		<header>
			<a href="<c:url value="/cart"/>">CARRELLO</a>
			<a href="<c:url value="/history"/>">ORDINI</a>
			<c:if test="${isAdmin == true}">
				<a href="<c:url value="/adminPage"/>">AMMINISTRA</a>
			</c:if>
		</header>
		
		<main>
			
			<h1>RICERCA <span> LIBRO</span></h1>
			
			<c:if test="${allBlank != null }">
				<p>riempire almeno un campo</p>
			</c:if>

			<c:if test="${notExistingISBN != null }">
				<p>ERRORE. Libro insesistente</p>
			</c:if>
			
			<c:if test="${insufficientCredit != null }">
				<p>CREDITO INSUFFICIENTE. ORDINE ANNULLATO</p>
			</c:if>

			<form:form action="/book/search" method="post" modelAttribute="searchBookData" id="cercaLibroForm">
			
				<form:label path="titolo" cssClass="cercaLibroLabel">Titolo</form:label>
				<form:input path="titolo" cssClass="cercaLibroInput"/>
				
				<form:label path="autore" cssClass="cercaLibroLabel">Autore</form:label>
				<form:input path="autore" cssClass="cercaLibroInput"/>
				
				<form:label path="editore" cssClass="cercaLibroLabel">Editore</form:label>
				<form:input path="editore" cssClass="cercaLibroInput"/>
			
				<input type="submit" value="INVIA" id="submit"/>
			
			</form:form>

			<c:if test="${books != null}">
			
				<table>
					
					<tr>
						<th class="thDispari">ISBN</th>
						<th class="thPari">TITOLO</th>
						<th class="thDispari">AUTORE</th>
						<th class="thPari">EDITORE</th>
						<th class="thDispari">GENERE</th>
						<th class="thPari">N. COPIE</th> 
						<th class="thDispari">PREZZO</th>
					</tr>
					
					<c:forEach items="${books}" var="book">
					
						<tr>

							<td class="tdDispari">
							<a href="<c:url value="/book/isbn/${book.isbn}"/>">
							${book.isbn}
							</a>
							</td>
							
							<td class="tdPari">
							<a href="<c:url value="/book/isbn/${book.isbn}"/>">
							${book.titolo}
							</a>
							</td>
							
							<td class="tdDispari">
							<a href="<c:url value="/book/isbn/${book.isbn}"/>">
							${book.autore}
							</a>
							</td>
							
							<td class="tdPari">
							<a href="<c:url value="/book/isbn/${book.isbn}"/>">
							${book.editore}
							</a>
							</td>
							
							<td class="tdDispari">
							<a href="<c:url value="/book/isbn/${book.isbn}"/>">
							${book.genere}
							</a>
							</td>
							
							<td class="tdPari">
							<a href="<c:url value="/book/isbn/${book.isbn}"/>">
							${book.copie}
							</a>
							</td>
							
							<td class="tdDispari">
							<a href="<c:url value="/book/isbn/${book.isbn}"/>">
							${book.prezzo - ( book.prezzo * book.sconto / 100 )}
							</a>
							</td>
						
						</tr>
					
					</c:forEach>
									
				</table>
			
			</c:if>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>