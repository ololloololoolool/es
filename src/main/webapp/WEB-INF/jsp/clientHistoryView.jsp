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
		<title>Ordini clienti</title>
	</head>
	
	<body>
	
		<header></header>
		
		<main>
			
			<h1>ORDINI <span> CLIENTI</span></h1>

			<form method="post" action="/admin/history">
				
				<label for="username">Username:</label>
				<input type="text" name="username"/>
				
				<input type="submit" value="INVIA"/>
				
			</form>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>