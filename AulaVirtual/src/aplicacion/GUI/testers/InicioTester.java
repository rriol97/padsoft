package aplicacion.GUI.testers;

import javax.swing.JPanel;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.general.PanelAsig;
import aplicacion.GUI.general.PanelMatriculadas;
import aplicacion.GUI.login.FrameLogin;
import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;
import aplicacion.clases.elemento.Apuntes;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;


public class InicioTester {
	public static void main(String[] args) throws InvalidEmailAddressException, FailedInternetConnectionException {
		FrameLogin.getInstance();
		Frame f = Frame.getIntance();
		
		Alumno alum = new Alumno("1234", "1234", "correo", "nombre", "apellidos");
		Asignatura asig = new Asignatura("CIREL");
		Solicitud sol = new Solicitud("Texto de solicitud", alum, asig);
		alum.enviarSolicitud(sol);
		asig.aceptarSolicitud(sol);
		
		asig.anadirElemento(new Apuntes("Apuntes 1", true, "Testo de apuntes", asig));
		
		JPanel izq = new PanelMatriculadas(alum);
		JPanel der = new PanelAsig(asig);
		f.cambiarPanel(izq, 0);
		f.cambiarPanel(der, 1);
		
		new Controlador(f);
		
	}
}
