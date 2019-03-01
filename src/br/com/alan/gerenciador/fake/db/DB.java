package br.com.alan.gerenciador.fake.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.alan.gerenciador.modelo.Empresa;
import br.com.alan.gerenciador.modelo.Usuario;

public class DB {

	public static int codigoEmpresa = 3;
	public static List<Empresa> listaEmpresas = new ArrayList<>();
	public static List<Usuario> listaUsuarios = new ArrayList<>();

	static {
		listaEmpresas.add(new Empresa(1, "Google"));
		listaEmpresas.add(new Empresa(2, "Facebook"));
		listaEmpresas.add(new Empresa(3, "Oracle"));		
		
		listaUsuarios.add(new Usuario("alan", "123456"));
		listaUsuarios.add(new Usuario("jaque", "456852"));
	}

	public void adicionarEmpresa(Empresa empresa) {
		codigoEmpresa++;
		empresa.setId(codigoEmpresa);
		listaEmpresas.add(empresa);
	}

	public void alterandoEmpresa(Empresa empresa) {
		// listaEmpresa.add(empresa);
	}

	public void removerEmpresa(int id) {
		Iterator<Empresa> it = listaEmpresas.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscarEmpresa(int id) {
		for (Empresa empresa : listaEmpresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(DB.listaEmpresas);
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
