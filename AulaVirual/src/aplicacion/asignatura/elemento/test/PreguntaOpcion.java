 package aplicacion.asignatura.elemento.test;


import java.util.ArrayList;
import java.util.List;

public abstract class PreguntaOpcion extends Pregunta {
	private List<Opcion> opciones = new ArrayList<Opcion>();
	
	public PreguntaOpcion(String enunciado, double valor, double penalizacion, boolean aleatoria, int numRespuestas, int numAciertos, int numFallos){
		super(enunciado,valor, penalizacion,aleatoria,numRespuestas,numAciertos,numFallos);
	}
	
	public void anadirOpcion(Opcion opcion){
		opciones.add(opcion);
		return;
	}
	
	public boolean eliminarOpcion(Opcion opcion){
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
