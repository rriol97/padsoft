package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelCrearTest;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ActionVolverAsigDeTest implements ActionListener{

	private Test t;
	private Tema r;
	
	public ActionVolverAsigDeTest(Test t, Tema r){
		this.t = t;
		this.r = r;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Controlador.getInstance().eliminarTest(t,r);
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}
		Frame.getIntance().cambiarPanel(new PanelCrearTest(t.getAsignatura(), this.r), 1);
	}

}
