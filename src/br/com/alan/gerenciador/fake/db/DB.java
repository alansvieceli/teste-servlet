package br.com.alan.gerenciador.fake.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.alan.gerenciador.models.Empresa;

public class DB {

	public static int codigoEmpresa = 0;
	public static List<Empresa> listaEmpresa = new ArrayList<>();

	public void adicionarEmpresa(Empresa empresa) {
		codigoEmpresa++;
		empresa.setId(codigoEmpresa);
		listaEmpresa.add(empresa);
	}
	
	public void alterandoEmpresa(Empresa empresa) {		
		//listaEmpresa.add(empresa);
	}

	public void removerEmpresa(int id) {		
		Iterator<Empresa> it = listaEmpresa.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId() == id) {
				it.remove();				
			}
		}		
	}
	
	public Empresa buscarEmpresa(int id) {		
		for (Empresa empresa : listaEmpresa) {
			if (empresa.getId() == id) {
				return empresa;				
			}			
		}
		return null;
	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(DB.listaEmpresa);
	}

}
