package br.com.alan.gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.acao.Acao;

@WebServlet("/controlador")
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String controle = request.getParameter("acao");
		String path = null;

		String nomeDaClasse = "br.com.alan.gerenciador.acao." + controle;

		try {
			Class classe = Class.forName(nomeDaClasse); // faz o import da classe
			Acao acao = (Acao) classe.newInstance();
			
			boolean usuarioNaoEstaLogado = request.getSession().getAttribute("usuarioLogado") == null;
			boolean EhUmaAcaoProtegida = acao.getProtegida();
			if (EhUmaAcaoProtegida && usuarioNaoEstaLogado) {
				response.sendRedirect("controlador?acao=LoginForm");
				return;
			}
			
			path = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] url = path.split(":");
		if (url[0].equals("forward")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + url[1]);
			requestDispatcher.forward(request, response);
		} else if (url[0].equals("redirect")) {
			response.sendRedirect(url[1]);
		}

	}

}
