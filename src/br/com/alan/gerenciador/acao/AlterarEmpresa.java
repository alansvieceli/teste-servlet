package br.com.alan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.modelo.Empresa;
 
public class AlterarEmpresa implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		int id = Integer.parseInt((String) req.getParameter("id"));		
		
		DB banco = new DB();
		Empresa empresa = banco.buscarEmpresa(id);
		empresa.setNome(nome);
		banco.alterandoEmpresa(empresa);
		
		return "redirect:unicaEntrada?acao=ListaEmpresas";		
	}
	
}
