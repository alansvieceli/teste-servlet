package br.com.alan.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 6517510955759485494L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		try (PrintWriter writer = resp.getWriter()) {
			writer.println("<html><body><h2>Olá...</h2></body></html>");
		} 
	}

}
