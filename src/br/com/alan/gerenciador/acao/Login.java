package br.com.alan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alan.gerenciador.fake.db.DB;
import br.com.alan.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		DB banco = new DB();
		Usuario usuario = banco.existeUsuario(login, senha);

		if (usuario != null) {
			req.setAttribute("usuarioLogado", usuario);	
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:controlador?acao=ListaEmpresas";
		}

		return "redirect:controlador?acao=LoginForm";
	}

	@Override
	public boolean getProtegida() {
		return false;
	}

}
