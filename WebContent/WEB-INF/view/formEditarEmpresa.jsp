<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/controlador" var="linkAlterarEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>

	<form action="${linkAlterarEmpresa}" method="post">
		
		<input type="hidden" name="id" value="${empresa.id}">
		<input type="hidden" name="acao" value="AlterarEmpresa">
		Nome: <input type="text" name="nome" value="${empresa.nome}"> 
		Data Cadastro : <input type="text" name="data" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}"/>"> <br/>
		
		<input type="submit" title="Cadastrar">
	</form>


</body>
</html>