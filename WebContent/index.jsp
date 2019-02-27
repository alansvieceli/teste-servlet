<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/unicaEntrada" var="linkNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Titulo</title>
</head>
<body>
	<form action="${linkNovaEmpresa}" method="post">
		<input type="hidden" name="acao" value="CadastraEmpresa"> Nome
		(POST): <input type="text" name="nome"> <input type="submit"
			title="Cadastrar">
	</form>

	<p>
		<a href="/gerenciador/controlador?acao=ListaEmpresas">Lista de Empresas</a>
	</p>
</body>
</html>