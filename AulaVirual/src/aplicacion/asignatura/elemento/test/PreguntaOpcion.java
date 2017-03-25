 package aplicacion.asignatura.elemento.test;


import java.util.ArrayList;
import java.util.List;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;

public abstract class PreguntaOpcion extends Pregunta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Opcion> opciones = new ArrayList<Opcion>();
	
	public PreguntaOpcion(String enunciado, double valor, double penalizacion, boolean aleatoria){
		super(enunciado, valor, penalizacion, aleatoria);
	}
	
	public boolean anadirOpcion(Opcion opcion){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return opciones.add(opcion);
	}
	
	public boolean eliminarOpcion(Opcion opcion){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return opciones.remove(opcion);
	}

	@Override
	public String toString() {
		String res = "";
		res = res+ super.toString();
		for (Opcion opc:opciones){
			res = res +"\t"+ opc.toString() + "\n";
		}
		return res;
	}
	
	
}
