package br.com.alan.gerenciador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.acao.AlterarEmpresa;
import br.com.alan.gerenciador.acao.CadastraEmpresa;
import br.com.alan.gerenciador.acao.ListaEmpresas;
import br.com.alan.gerenciador.acao.MostraEmpresa;
import br.com.alan.gerenciador.acao.RemoveEmpresa;

@WebServlet("/unicaEntrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String controle = request.getParameter("acao");

		if (controle.equals("listaEmpresas")) {			
			ListaEmpresas listaEmpresa = new ListaEmpresas();
			listaEmpresa.executa(request, response);

		} else if (controle.equals("removeEmpresa")) {			
			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			removeEmpresa.executa(request, response);			

		} else if (controle.equals("mostraEmpresa")) {
			MostraEmpresa mostraEmpresa = new MostraEmpresa();
			mostraEmpresa.executa(request, response);
			
		} else if (controle.equals("cadastraEmpresa")) {
			CadastraEmpresa cadastraEmpresa = new CadastraEmpresa();
			cadastraEmpresa.executa(request, response);
			
		} else if (controle.equals("alterarEmpresa")) {
			AlterarEmpresa alterarEmpresa = new AlterarEmpresa();
			alterarEmpresa.executa(request, response);
			
		}
		
		

	}

}
