package br.com.alan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;

public class RemoveEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt((String) req.getParameter("id"));
		DB banco = new DB();
		banco.removerEmpresa(id);

		return "redirect:controlador?acao=ListaEmpresas";
	}

	@Override
	public boolean getProtegida() {
		return true;
	}

}
