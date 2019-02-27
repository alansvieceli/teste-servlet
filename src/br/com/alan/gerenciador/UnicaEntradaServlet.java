package br.com.alan.gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		String path = null;

		if (controle.equals("listaEmpresas")) {
			ListaEmpresas listaEmpresa = new ListaEmpresas();
			path = listaEmpresa.executa(request, response);

		} else if (controle.equals("removeEmpresa")) {
			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			path = removeEmpresa.executa(request, response);

		} else if (controle.equals("mostraEmpresa")) {
			MostraEmpresa mostraEmpresa = new MostraEmpresa();
			path = mostraEmpresa.executa(request, response);

		} else if (controle.equals("cadastraEmpresa")) {
			CadastraEmpresa cadastraEmpresa = new CadastraEmpresa();
			path = cadastraEmpresa.executa(request, response);

		} else if (controle.equals("alterarEmpresa")) {
			AlterarEmpresa alterarEmpresa = new AlterarEmpresa();
			path = alterarEmpresa.executa(request, response);

		}

		String[] url = path.split(":");
		if (url[0].equals("forward")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/"+url[1]);
			requestDispatcher.forward(request, response);
		} else if (url[0].equals("redirect")) {
			response.sendRedirect(url[1]);
		}

	}

}
