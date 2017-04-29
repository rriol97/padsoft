package aplicacion.GUI.general;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.login.FrameLogin;


public class FrameTester {
	public static void main(String[] args) {
		FrameLogin.getInstance();
		Controlador c = new Controlador(Frame.getIntance());
		
	}
}
