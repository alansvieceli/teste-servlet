package br.com.alan.gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.models.Empresa;

/**
 * Servlet implementation class mostrarEmpresaServlet
 */
@WebServlet("/mostrarEmpresa")
public class mostrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt( (String) request.getParameter("id") );		
		DB banco = new DB();
		Empresa empresa = banco.buscarEmpresa(id);
		
		request.setAttribute("empresa", empresa);		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formEditarEmpresa.jsp");		
		requestDispatcher.forward(request, response);
	}


}
