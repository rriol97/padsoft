package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelSolPendientes;
import aplicacion.GUI.profesor.PanelSolProf;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Solicitud;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ActionAceptarSol implements ActionListener {
	private PanelSolProf vista;
	private Solicitud sol;
	
	public ActionAceptarSol (PanelSolProf vista,Solicitud sol) {
		this.vista = vista;
		this.sol = sol;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Controlador.getInstance().aceptarSol(sol.getAsignatura(),sol);
			Frame.getIntance().borrarDer();
			Frame.getIntance().cambiarPanel(new PanelSolPendientes(Aplicacion.getInstance()), 1);
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}

	}
}
