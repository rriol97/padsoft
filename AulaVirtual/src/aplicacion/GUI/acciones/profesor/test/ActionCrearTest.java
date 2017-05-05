package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearTest;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ActionCrearTest implements ActionListener {
	private PanelCrearTest p;
	private Asignatura asig;
	private Tema tema;
	
	public ActionCrearTest(PanelCrearTest p, Asignatura asig, Tema tema){
		this.p = p;
		this.asig = asig;
		this.tema = tema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (this.p.getNombre().equals("")){
			JOptionPane.showMessageDialog(this.p,"Introduzca el nombre de test");
		}
		else if (p.getFechaIni()==null){
			JOptionPane.showMessageDialog(this.p,"Introduzca la fecha de inicio");
		}
		
		else if (p.getFechaFin()==null){
			JOptionPane.showMessageDialog(this.p,"Introduzca la fecha de fin");
		}
		
		else if (this.p.getPeso()==null){
			JOptionPane.showMessageDialog(this.p,"Introduzca el peso del Test en la asignatura");
		}
		
		else if (this.p.getVpd()==null){
			JOptionPane.showMessageDialog(this.p,"Introduzca el valor por defecto de cada pregunta");
		}
		
		else{
			Test t;
			try {
				t = Controlador.getInstance().nuevoTest(this.p.getNombre(),this.p.getSelec(),this.asig,this.p.getFechaIni(),this.p.getFechaFin(),this.p.getOrden(),this.p.getPeso(),this.p.getVpd(), this.tema);
				Frame.getInstance().cambiarPanel(new PanelAnadirPregunta(t), 1);
			} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
			
		}
	}

}
