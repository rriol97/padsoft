package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelSolPendientes;
import aplicacion.GUI.paneles.profesor.PanelSolProf;
import aplicacion.clases.Aplicacion;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ActionDenegarSol implements ActionListener {
	private PanelSolProf vista;
	
	public ActionDenegarSol (PanelSolProf vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Controlador.getInstance().denergarSol(vista.getSolicitud().getAsignatura(), vista.getSolicitud());
			Frame.getInstance().borrarDer();
			Frame.getInstance().cambiarPanel(new PanelSolPendientes(Aplicacion.getInstance()), 1);
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}
	}
}
