package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.List;

public class Problema {

	private String regla;
	private List<Object> objetos;
	
	
	
	public Problema(String regla, Object...listaObjetos) {
		objetos=new ArrayList<>();
		this.regla=regla;
		for (Object object : listaObjetos) {
			objetos.add(object);
		}
	}
	public String getRegla() {
		return regla;
	}
	public void setRegla(String regla) {
		this.regla = regla;
	}
	public List<Object> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<Object> objetos) {
		this.objetos = objetos;
	}
	
	
	
}
