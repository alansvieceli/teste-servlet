package br.com.alan.gerenciador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.models.Empresa;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaEmpresas")
public class listaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DB banco = new DB();
		List<Empresa> lista = banco.getEmpresas();
		
		req.setAttribute("listaEmpresas", lista);		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/listaEmpresas.jsp");		
		requestDispatcher.forward(req, resp);

	}

}
