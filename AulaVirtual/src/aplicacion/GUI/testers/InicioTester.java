package aplicacion.GUI.testers;



import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.login.FrameLogin;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;


public class InicioTester {
	public static void main(String[] args) throws InvalidEmailAddressException, FailedInternetConnectionException {
		FrameLogin.getInstance();
		Controlador.getInstance();
		
	}
}
