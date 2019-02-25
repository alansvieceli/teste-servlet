package br.com.alan.gerenciador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;

/**
 * Servlet implementation class removerEmpresaServlet
 */
@WebServlet("/removerEmpresa")
public class removerEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( (String) request.getParameter("id") );
		
		DB banco = new DB();
		banco.removerEmpresa(id);
		
		response.sendRedirect("listaEmpresas");
		
	}

}
