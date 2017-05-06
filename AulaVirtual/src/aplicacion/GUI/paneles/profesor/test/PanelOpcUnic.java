package aplicacion.GUI.paneles.profesor.test;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;


import aplicacion.clases.elemento.test.Opcion;
import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionAnadirOpcUnica;
import aplicacion.GUI.acciones.profesor.test.ActionEditarOpcUnic;
import aplicacion.GUI.acciones.profesor.test.ActionEliminarOpcUnic;
import aplicacion.GUI.acciones.profesor.test.ActionNuevaOpc;
import aplicacion.GUI.acciones.profesor.test.ActionVolverCrearPreg;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class PanelOpcUnic extends JPanel  {	
	private static final long serialVersionUID = 1L;

	private JList <Opcion> listaOpc;
	
	public PanelOpcUnic(OpcionUnica p, Test t){
		this.setLayout(new SpringLayout());
		
		JPanel panelOpc = new JPanel();
		panelOpc.setLayout(new SpringLayout());
		JButton botonOpc = new JButton("Anadir Opcion");
		botonOpc.addActionListener(new ActionNuevaOpc(p, t));
		panelOpc.add(botonOpc);
		
		Opcion[] arrayOpc = new Opcion[p.getOpciones().size()];
		int i = 0;
		for (Opcion o: p.getOpciones()) {
			arrayOpc[i] = o;
			i++;
		}
		listaOpc = new JList <Opcion> (arrayOpc);
		panelOpc.add(listaOpc);
		
        listaOpc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.add(panelOpc);
		
		SpringUtilities.makeCompactGrid(panelOpc,2,1,0,0,5,5);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, 0));
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionVolverCrearPreg(t));
		panelBotones.add(botonCancelar);
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionAnadirOpcUnica(p, t));
		panelBotones.add(botonAceptar);
		JButton eliminar = new JButton("Eliminar Opcion");
		eliminar.addActionListener(new ActionEliminarOpcUnic(this,t,p));
		panelBotones.add(eliminar);
		JButton editar = new JButton("Editar Opcion");
		editar.addActionListener(new ActionEditarOpcUnic(this,t,p));
		panelBotones.add(editar);
		
		this.add(panelBotones);
		
		SpringUtilities.makeCompactGrid(this,2,1,5,5,5,5);
	}


	public Opcion getSel() {
		return this.listaOpc.getSelectedValue();
	}
}
