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
 * Servlet implementation class NovaEmpreServlet
 */
@WebServlet("/cadastrarEmpresa")
public class cadastrarEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = -1998402053064365712L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		
		DB banco = new DB();
		banco.adicionarEmpresa(empresa);
	
		resp.sendRedirect("listaEmpresas");
		
	}

}
