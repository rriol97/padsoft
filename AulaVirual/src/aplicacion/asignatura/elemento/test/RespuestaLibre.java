package aplicacion.asignatura.elemento.test;

public class RespuestaLibre extends Pregunta{

	private String solucion;
	
	public RespuestaLibre(String enunciado, double valor, double penalizacion, boolean aleatoria, int numRespuestas, int numAciertos,int numFallos, String solucion){
		super(enunciado,valor,penalizacion,aleatoria,numRespuestas,numAciertos,numFallos);
		this.solucion = solucion;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	@Override
	public String toString() { 
		String res = "";
		res = res+ super.toString();
		res = res+"\n"+"Respuesta Libre:";
		return res;
	}
	
}
