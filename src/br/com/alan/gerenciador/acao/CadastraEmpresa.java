package br.com.alan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.modelo.Empresa;

public class CadastraEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);

		DB banco = new DB();
		banco.adicionarEmpresa(empresa);

		return "redirect:controlador?acao=ListaEmpresas";
	}
	
	@Override
	public boolean getProtegida() {
		return true;
	}

}
