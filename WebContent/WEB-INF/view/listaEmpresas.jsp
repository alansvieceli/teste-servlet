<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alan.gerenciador.modelo.Empresa" %>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listas de Empresa (JSTL)</title>
</head>
<body>
	<c:if test="${not empty nomeEmpresa}">
		<p>Empresa <b>${ nomeEmpresa }</b> cadastrada com sucesso!</p> <br/>
	</c:if>
	
	Lista de empresas: <br/>

	<ul>
		<c:forEach items="${listaEmpresas}" var="empresa">		
			<li>${empresa.nome} - <fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}"/> | 
			<a href="/gerenciador/controlador?acao=MostraEmpresa&id=${empresa.id}">editar</a> | 
			<a href="/gerenciador/controlador?acao=RemoveEmpresa&id=${empresa.id}">remove</a> |</li>
		</c:forEach>		
	</ul>
	
	<a href='/gerenciador'>Voltar</a>
</body>
</html>