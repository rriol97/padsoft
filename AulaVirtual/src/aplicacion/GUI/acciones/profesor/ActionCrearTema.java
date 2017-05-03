package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAsigProf;
import aplicacion.GUI.profesor.PanelCrearTema;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ActionCrearTema implements ActionListener {

	private PanelCrearTema panel;
	private Asignatura asig;
	private Tema tema;
	
	public ActionCrearTema(PanelCrearTema p, Asignatura asig, Tema tema){
		this.asig = asig;
		this.panel = p;
		this.tema = tema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.panel.getNombre().equals("")){
			JOptionPane.showMessageDialog(this.panel,"Introduzca el nombre del tema");
			return;
		} 
		
		if (this.panel.getSelec().equals("Visible")){
			try {
				Controlador.getInstance().crearTema(this.panel.getNombre(),true,asig, this.tema);
			} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
		} else {
			try {
				Controlador.getInstance().crearTema(this.panel.getNombre(),false,asig, this.tema);
			} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
		}
		
		Frame.getIntance().cambiarPanel(new PanelAsigProf(asig), 1);
	}

}
