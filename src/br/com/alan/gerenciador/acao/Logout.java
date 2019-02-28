package br.com.alan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession sessao = req.getSession();
		//sessao.removeAttribute("usuarioLogado");
		sessao.invalidate();

		return "redirect:controlador?acao=LoginForm";
	}

	@Override
	public boolean getProtegida() {
		return false;
	}

}
