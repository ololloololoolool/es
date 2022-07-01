<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

	<head>
		<link href="/resources/css/allPage.css" rel="stylesheet" type="text/css">
		<meta name="color-scheme" content="light dark">
		<meta charset="UTF-8">
		<title>Aggiungi</title>
	</head>
	
	<body>
	
		<header></header>
		
		<main>
			
			<h1>AGGIUNGI <span> LIBRO</span></h1>

			<form:form action="/admin/book/add" method="post" modelAttribute="book">
			
				<form:label path="isbn">ISBN</form:label>
				<form:input path="isbn"/>
				
				<form:label path="titolo">Titolo</form:label>
				<form:input path="titolo"/>
				
				<form:label path="autore">Autore</form:label>
				<form:input path="autore"/>
				
				<form:label path="editore">Editore</form:label>
				<form:input path="editore"/>
				
				<form:label path="prezzo">Prezzo</form:label>
				<form:input path="prezzo"/>
				
				<form:label path="genere">Genere</form:label>
				<form:input path="genere"/>
				
				<form:label path="copie">Copie</form:label>
				<form:input path="copie"/>
				
				<form:label path="sconto">Sconto</form:label>
				<form:input path="sconto"/>
			
				<input type="submit" value="INVIA"/>
			
			</form:form>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>