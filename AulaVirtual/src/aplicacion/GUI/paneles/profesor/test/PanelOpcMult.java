package aplicacion.GUI.paneles.profesor.test;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionAnadirOpcMult;
import aplicacion.GUI.acciones.profesor.test.ActionEditarOpcMult;
import aplicacion.GUI.acciones.profesor.test.ActionEliminarOpcMult;
import aplicacion.GUI.acciones.profesor.test.ActionNuevaMult;
import aplicacion.GUI.acciones.profesor.test.ActionVolverCrearPreg;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Test;

public class PanelOpcMult extends JPanel {
	private static final long serialVersionUID = 1L;
	private JList <Opcion> listaOpc;
	
	public PanelOpcMult(OpcionMultiple p, Test t){
	this.setLayout(new SpringLayout());
		
		JPanel panelOpc = new JPanel();
		panelOpc.setLayout(new SpringLayout());
		JButton botonOpc = new JButton("Anadir Opcion");
		botonOpc.addActionListener(new ActionNuevaMult(p, t));
		panelOpc.add(botonOpc);
		
		Opcion[] arrayOpc = new Opcion[p.getOpciones().size()];
		int i = 0;
		for (Opcion o: p.getOpciones()) {
			arrayOpc[i] = o;
			i++;
		}
		listaOpc = new JList <Opcion> (arrayOpc);
		panelOpc.add(listaOpc);
		
		this.add(panelOpc);
		
		SpringUtilities.makeCompactGrid(panelOpc,2,1,0,0,5,5);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, 0));
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionVolverCrearPreg(t));
		panelBotones.add(botonCancelar);
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionAnadirOpcMult(p, t));
		panelBotones.add(botonAceptar);
		JButton eliminar = new JButton("Eliminar Opcion");
		eliminar.addActionListener(new ActionEliminarOpcMult(this,t,p));
		panelBotones.add(eliminar);
		JButton editar = new JButton("Editar Opcion");
		editar.addActionListener(new ActionEditarOpcMult(this,t,p));
		panelBotones.add(editar);
		
		this.add(panelBotones);
		
		SpringUtilities.makeCompactGrid(this,2,1,5,5,5,5);
	}

	public Opcion getSel() {
		return this.listaOpc.getSelectedValue();
	}
}
