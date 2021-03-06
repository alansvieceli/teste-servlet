package br.com.alan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {

	String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	boolean getProtegida();

}
