package aplicacion.GUI.acciones.alumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.acciones.alumno.componentes.PanelPreg;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.alumno.PanelAsigAlum;
import aplicacion.GUI.paneles.alumno.PanelTestAlum;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.RespuestaLibre;
import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.Resolucion;
import aplicacion.clases.resolucion.Respuesta;

public class ActionRealizarTest implements ActionListener {
	private PanelTestAlum vista;
	private Test test;
	
	public ActionRealizarTest (PanelTestAlum vista, Test test) {
		this.vista = vista;
		this.test = test;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Resolucion res = new Resolucion(this.test, Aplicacion.getInstance().getAlumnoActual());
		for (Pregunta p: this.test.getPreguntas()) {
			for (PanelPreg panel: this.vista.getPaneles()) {
				if (p.equals(panel.getPregunta())) {
					Respuesta resp = new Respuesta(p);
					if (p instanceof RespuestaLibre) {
						resp.setRespuesta(panel.getRespuesta().getText());
					} else {
						for (Opcion opc: panel.getSeleccionadas()) {
							resp.anadirOpcion(opc);
						}
					}
					res.anadirRespuesta(resp);
					break;
				}
			}
		}
		Aplicacion.getInstance().getAlumnoActual().anadirResolucion(res);
		Frame.getIntance().cambiarPanel(new PanelAsigAlum(this.test.getAsignatura()), 1);
	}
}
