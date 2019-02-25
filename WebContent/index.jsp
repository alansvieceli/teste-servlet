<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/cadastrarEmpresa" var="linkNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Titulo</title>
</head>
<body>
	<p>
		<a href="/gerenciador/oi">Teste>></a>
	</p>
		
	<form action="${linkNovaEmpresa}" method="post">

		Nome (POST): <input type="text" name="nome"> <input type="submit"
			title="Cadastrar">
	</form>
	
	<p>
		<a href="/gerenciador/listaEmpresas">Lista de Empresas</a>
	</p>
</body>
</html>