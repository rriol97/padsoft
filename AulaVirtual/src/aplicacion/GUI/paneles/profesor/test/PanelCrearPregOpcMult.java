package aplicacion.GUI.paneles.profesor.test;



import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionCrearOpcMult;
import aplicacion.clases.elemento.test.Test;


	public class PanelCrearPregOpcMult extends PanelEnunciado{
		private static final long serialVersionUID = 1L;
		
		public PanelCrearPregOpcMult(Test t) {
			super(t);
			this.aceptar.addActionListener(new ActionCrearOpcMult(this,t));

			this.add(this.panelEnun);
			this.add(this.opciones);
			this.add(this.panel_botones);
			
			 SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
			
		}
		
	}


