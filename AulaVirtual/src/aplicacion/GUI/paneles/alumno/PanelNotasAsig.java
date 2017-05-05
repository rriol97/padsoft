package aplicacion.GUI.paneles.alumno;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.Resolucion;

public class PanelNotasAsig extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelNotasAsig(Alumno alum, Asignatura asig) {
		this.setLayout(new SpringLayout());
		
		for(Test t: asig.getTests()) {
			String nota = "Nota en el test: " + t.getNombre();
			Resolucion res = alum.encontrarResolucion(t);
			if (res == null) {
				nota = nota + " - 0.0";
			} else {
				nota = nota + " - " + res.getNota();
			}
			
			JLabel etiqueta_nota = new JLabel(nota);
			this.add(etiqueta_nota);
		}
		
		double notaFinal;
		notaFinal = asig.calcularNotaAsig(alum);
	
		JLabel etiqueta_notaFinal = new JLabel("Nota final: " + notaFinal);
		this.add(etiqueta_notaFinal);
		
		JButton boton_volver =  new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(asig));
		
		SpringUtilities.makeGrid(this, asig.getTests().size() + 2, 1, 5, 5, 5, 5);
	}

}
