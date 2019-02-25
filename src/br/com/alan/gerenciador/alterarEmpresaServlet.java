package br.com.alan.gerenciador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.models.Empresa;

/**
 * Servlet implementation class alterarEmpresaServlet
 */
@WebServlet("/alterarEmpresa")
public class alterarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int id = Integer.parseInt((String) request.getParameter("id"));		
		
		DB banco = new DB();
		Empresa empresa = banco.buscarEmpresa(id);
		empresa.setNome(nome);
		banco.alterandoEmpresa(empresa);
		
		response.sendRedirect("listaEmpresas");
	}

}
