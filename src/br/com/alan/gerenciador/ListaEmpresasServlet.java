package br.com.alan.gerenciador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/empresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String retornaJSON(List<Empresa> listaEmpresas, HttpServletResponse resp) {
		Gson gson = new Gson();
		String json = gson.toJson(listaEmpresas);
		resp.setContentType("application/json");
		return json;
	}

	private String retornaXML(List<Empresa> listaEmpresas, HttpServletResponse resp) {
		XStream xstrem = new XStream();
		xstrem.alias("empresa", Empresa.class);
		String xml = xstrem.toXML(listaEmpresas);

		resp.setContentType("application/xml");
		return xml;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Empresa> listaEmpresas = new DB().getEmpresas();

		String controle = req.getParameter("acao");
		String accept = req.getHeader("Accept");
		String retorno;

		if ((controle != null) && controle.equals("xml")) {
			retorno = retornaXML(listaEmpresas, resp);
		} else if ((accept != null) && accept.endsWith("xml")) {
			retorno = retornaXML(listaEmpresas, resp);
		} else {
			retorno = retornaJSON(listaEmpresas, resp);
		}

		resp.getWriter().println(retorno);

	}

}
