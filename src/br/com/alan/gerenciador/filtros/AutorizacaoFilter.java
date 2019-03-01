package br.com.alan.gerenciador.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alan.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/controlador")
public class AutorizacaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Autorização...");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String controle = request.getParameter("acao");
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

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		chain.doFilter(servletRequest, servletResponse);
	}

}
