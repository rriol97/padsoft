package aplicacion.GUI.Alumno;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

import aplicacion.GUI.Profesor.PanelAsigImp;
import aplicacion.GUI.Profesor.PanelSolPendientes;
import aplicacion.GUI.acciones.ActionSalir;
import aplicacion.clases.Alumno;
import aplicacion.clases.Aplicacion;

/**
 * Clase que implementa la venta principal de la aplicacion.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private static Frame instance = new Frame();
	private JPanel der;
	private JPanel izq;
	
	// TODO cambiar el diseño de la ventana, que es muy cutre
	private Frame (){
		super("Aula Virtual");
		this.setLayout(new BorderLayout());
		
		if (Aplicacion.getInstance().getUsuarioActual() instanceof Alumno){
			this.der = null;
			this.izq = new PanelMatriculadas(Aplicacion.getInstance().getUsuarioActual());
			this.izq.setVisible(true);
			this.getContentPane().add(this.izq, BorderLayout.WEST);
		}
		
		else{
			this.der = new PanelAsigImp();
			this.izq = new PanelSolPendientes();
			this.getContentPane().add(this.der, BorderLayout.EAST);
			this.getContentPane().add(this.izq, BorderLayout.WEST);
			
		}
		
		JButton salir = new JButton("Cerrar Sesion");
		this.getContentPane().add(salir,BorderLayout.NORTH);
		salir.addActionListener(new ActionSalir());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	
	public static Frame getIntance(){
		return instance;
	}
	
	/**
	 * Metodo para cambiar uno de los paneles de la ventana por otro nuevo.
	 * @param nuevo Panel que se quiere mostrar en la ventana.
	 * @param panel Indicador del panel que va a ser sustituido por nuevo.
	 */
	public void cambiarPanel (JPanel nuevo, int panel) {
		if (nuevo == null) {
			return;
		}
		
		if (panel == 0) {
			if (this.izq != null) {
				this.izq.setVisible(false);
			}
			nuevo.setVisible(true);
			this.add(nuevo,BorderLayout.WEST);
			this.izq = nuevo;
		} else if (panel == 1) {
			if (this.der != null) {
				this.der.setVisible(false);
			}
			this.add(nuevo,BorderLayout.CENTER);
			nuevo.setVisible(true);
			this.der = nuevo;
		}
	}
	
	public void cambiarPanel(){
		this.der.setVisible(false);
		this.repaint();
	}
}
