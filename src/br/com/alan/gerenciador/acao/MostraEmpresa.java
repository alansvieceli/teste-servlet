package br.com.alan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt((String) req.getParameter("id"));
		DB banco = new DB();
		Empresa empresa = banco.buscarEmpresa(id);

		req.setAttribute("empresa", empresa);

		return "forward:formEditarEmpresa.jsp";
	}

}
