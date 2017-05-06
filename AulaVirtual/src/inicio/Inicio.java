package inicio;



import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.login.FrameLogin;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;


public class Inicio {
	public static void main(String[] args) throws InvalidEmailAddressException, FailedInternetConnectionException {
		FrameLogin.getInstance();
		Controlador.getInstance();
	}
}
