package aplicacion.GUI.profesor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.ActionNuevaOpc;
import aplicacion.clases.elemento.test.OpcionUnica;

public class PanelOpcUnic extends JPanel {
	private JButton botonOpc;
	private PanelOpciones opc;
	
	public PanelOpcUnic(OpcionUnica r){
		
		this.setLayout(new SpringLayout());
		
		JPanel panelAux = new JPanel();
		panelAux.setLayout(new SpringLayout());
		botonOpc = new JButton("Anadir Opcion");
		
		panelAux.add(botonOpc);
		panelAux.setVisible(true);
		
		opc = new PanelOpciones(r);
		opc.setVisible(false);
		
		botonOpc.addActionListener(new ActionNuevaOpc(opc));
		
		this.add(panelAux);
		this.add(opc);
		SpringUtilities.makeCompactGrid(this,2,1,5,5,5,5);
	}
}
