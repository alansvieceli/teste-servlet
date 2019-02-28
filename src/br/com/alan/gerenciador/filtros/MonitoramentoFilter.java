package br.com.alan.gerenciador.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
//@WebFilter("/controlador") nao é possivel definir a ordem dos filter, pra isso usar web.xmlagora sim
public class MonitoramentoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Monitoramento...");

		String controle = request.getParameter("acao");
		long antes = System.currentTimeMillis();

		chain.doFilter(request, response); // segue a vida....

		long depois = System.currentTimeMillis();

		System.out.println("Tempo de execução (" + controle + "): " + (depois - antes));

	}

}
