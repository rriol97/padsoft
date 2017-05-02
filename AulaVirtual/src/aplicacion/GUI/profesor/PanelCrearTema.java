package aplicacion.GUI.profesor;



import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;

import aplicacion.GUI.acciones.profesor.ActionCrearTema;


import aplicacion.clases.Asignatura;

	public class PanelCrearTema extends PanelComun {
		private static final long serialVersionUID = 1L;
		
		public PanelCrearTema(Asignatura asig){
			super();
			this.setLayout(new SpringLayout());
			this.add(this.aux);
			JPanel panelVacio = new JPanel();
			this.add(panelVacio);
			this.add(panel_botones);
			this.aceptar.addActionListener(new ActionCrearTema(asig,this));
			
			SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
		}
		
		public String getSelec(){
			return (String) this.visibilidad.getSelectedItem();
		}
		
		public String getNombre(){
			return (String) this.text.getText();
		}
	}
	
