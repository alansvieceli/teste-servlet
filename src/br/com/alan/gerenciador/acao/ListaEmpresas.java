package br.com.alan.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DB banco = new DB();
		List<Empresa> lista = banco.getEmpresas();

		req.setAttribute("listaEmpresas", lista);

		return "forward:listaEmpresas.jsp";

	}

}
