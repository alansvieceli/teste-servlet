<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/controlador" var="linkControlador" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Titulo</title>
</head>
<body>
	<form action="${linkControlador}" method="post">
		<input type="hidden" name="acao" value="CadastraEmpresa"> Nome
		(POST): <input type="text" name="nome"> <input type="submit"
			title="Cadastrar">
	</form>

	<p>
		<a href="/gerenciador/controlador?acao=ListaEmpresas">Lista de Empresas</a>
	</p>
	
	<p>
		<a href="/gerenciador/empresas">Lista de Empresas (JSON)</a>
	</p>
	
	<p>
		<a href="/gerenciador/empresas?acao=xml">Lista de Empresas (XML)</a>
	</p>
</body>
</html>