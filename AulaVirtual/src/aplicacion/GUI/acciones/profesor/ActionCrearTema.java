package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAsigProf;
import aplicacion.GUI.profesor.PanelCrearTema;
import aplicacion.clases.Asignatura;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ActionCrearTema implements ActionListener {

	private Asignatura asig;
	private PanelCrearTema panel;
	
	public ActionCrearTema(Asignatura asig, PanelCrearTema p){
		this.asig = asig;
		this.panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.panel.getNombre().equals("")){
			JOptionPane.showMessageDialog(this.panel,"Introduzca el nombre del tema");
			return;
		} 
		
		if (this.panel.getSelec().equals("Visible")){
			try {
				Controlador.getInstance().crearTema(this.panel.getNombre(),true,asig);
			} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
		} else {
			try {
				Controlador.getInstance().crearTema(this.panel.getNombre(),false,asig);
			} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
		}
		
		Frame.getIntance().cambiarPanel(new PanelAsigProf(asig), 1);
	}

}
