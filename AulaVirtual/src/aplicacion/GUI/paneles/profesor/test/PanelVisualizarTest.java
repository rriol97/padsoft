package aplicacion.GUI.paneles.profesor.test;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionSelEditarTest;
import aplicacion.GUI.acciones.profesor.test.ActionVerResolucion;
import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.componentes.PanelPregSol;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.Resolucion;

public class PanelVisualizarTest extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JList <Resolucion> listRes;
	
	public PanelVisualizarTest (Test t, Object padre) {
		this.setLayout(new SpringLayout());
		
		JPanel izq = new JPanel();
		izq.setPreferredSize(new Dimension((int)(4*Frame.WIDTH/6),(int)(Frame.HEIGHT/1.25)));
		izq.setLayout(new SpringLayout());
		
		JLabel etiqueta_nombre = new JLabel (t.getNombre());
		izq.add(etiqueta_nombre);
		
		for (Pregunta p: t.getPreguntas()) {
			PanelPregSol pps = new PanelPregSol(p);
			izq.add(pps);
		}
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		
		JButton boton_volver = new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(t.getAsignatura()));
		panel_botones.add(boton_volver);
		
		JButton boton_editar = new JButton("Editar");
		boton_editar.addActionListener(new ActionSelEditarTest(t, padre));
		panel_botones.add(boton_editar);
		
		izq.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(izq, t.getPreguntas().size() + 2, 1, 0, 0, 5, 5);
		this.add(izq);
		
		JPanel der = new JPanel();
		der.setLayout(new SpringLayout());
		der.setPreferredSize(new Dimension((int)(Frame.WIDTH/6),(int)(Frame.HEIGHT/1.25)));
		
		JLabel etiqueta_resoluciones = new JLabel ("Resoluciones");
		etiqueta_resoluciones.setFont(new Font("Arial",12,18));
        der.add(etiqueta_resoluciones);
		
		Resolucion[] arrayRes = new Resolucion[t.getResoluciones().size()];
		int i = 0;
		for (Resolucion res: t.getResoluciones()) {
			arrayRes[i] = res;
			i++;
		}
		this.listRes = new JList <Resolucion> (arrayRes);
		this.listRes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollingList = new JScrollPane(this.listRes);
		der.add(scrollingList);
		
		JButton boton_resolucion = new JButton("Ver resolucion");
		boton_resolucion.addActionListener(new ActionVerResolucion(this));
		der.add(boton_resolucion);
		
		SpringUtilities.makeCompactGrid(der, 3, 1, 0, 0, 5, 5);
		this.add(der);
		
		SpringUtilities.makeCompactGrid(this, 1, 2, 5, 5, 5, 5);
	}
	
	public Resolucion getSeleccion() {
		return this.listRes.getSelectedValue();
	}
}
