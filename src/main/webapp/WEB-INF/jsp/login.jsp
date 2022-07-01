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
		<title>Accedi</title>
	</head>
	
	<body>
	
		<header></header>
		
		<main>
			
			<h1>PORATALE DEL <span> LIBRO</span></h1>
			
			<c:if test="${blankField != null }">
				<p>riempire i campi</p>
			</c:if>
			
			<c:if test="${wrongPassword != null }">
				<p>credenziali errate</p>
			</c:if>
			
			<form:form action="/login/control" method="post" modelAttribute="loginData">
			
				<aside id="leftAside">
				
					<form:label path="nick" id="nickLabel">nickname</form:label>
					<form:input path="nick" cssClass="logInput" id="nickInput" placeholder="nick"/>
				
				</aside>			
				
				<aside id="rightAside">
				
					<form:label path="password" id="pswLabel">password</form:label>
					<form:password path="password" cssClass="logInput" id="pswInput" placeholder="psw"/>
				
				</aside>
				
				<input type="submit" value="INVIA" id="submit"/>
				
			</form:form>
			
		</main>
		
		<footer></footer>
	
	</body>
	
</html>