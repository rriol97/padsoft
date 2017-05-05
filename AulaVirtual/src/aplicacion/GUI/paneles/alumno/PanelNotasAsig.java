package aplicacion.GUI.paneles.alumno;

import java.awt.Font;

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
		
		JLabel etiqueta_titulo = new JLabel("Nota final:");
		etiqueta_titulo.setFont(new Font("Arial",12,18));
		this.add(etiqueta_titulo);
		
		for(Test t: asig.getTests()) {
			String nota = t.getNombre() + ": ";
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
		this.add(boton_volver);
		
		SpringUtilities.makeGrid(this, asig.getTests().size() + 3, 1, 5, 5, 5, 5);
	}

}
