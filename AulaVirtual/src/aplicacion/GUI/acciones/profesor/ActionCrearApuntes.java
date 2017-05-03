package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAsigProf;
import aplicacion.GUI.profesor.PanelCrearApuntes;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ActionCrearApuntes implements ActionListener{

	private Asignatura asig;
	private Tema tema;
	private PanelCrearApuntes panel;
	
	public ActionCrearApuntes(PanelCrearApuntes p, Asignatura asig, Tema tema){
		this.panel = p;
		this.asig = asig;
		this.tema = tema;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.panel.getTitulo().equals("")){
			JOptionPane.showMessageDialog(this.panel,"Introduzca el nombre de los apuntes");
		}
		else if (this.panel.getContenido().equals("")){
			JOptionPane.showMessageDialog(this.panel,"Introduzca el texto de los apuntes");
		}
		else{
			if (this.panel.getSelec().equals("Visible") == true){
				try {
					Controlador.getInstance().crearApuntes(this.panel.getTitulo(),true,this.panel.getContenido(),this.asig, this.tema);
				} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
					e1.printStackTrace();
				}
			} else{
				try {
					Controlador.getInstance().crearApuntes(this.panel.getTitulo(),false,this.panel.getContenido(),this.asig, this.tema);
				} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
					e1.printStackTrace();
				}
			}
		
			Frame.getIntance().cambiarPanel(new PanelAsigProf(asig), 1);
		}
	}	

}
