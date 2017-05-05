package aplicacion.GUI.general;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

import aplicacion.GUI.acciones.ActionSalir;
import aplicacion.GUI.paneles.alumno.PanelMatriculadas;
import aplicacion.GUI.paneles.profesor.PanelAsignaturas;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.TipoUsuario;

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
	private JPanel vacio;
	
	// TODO cambiar el diseño de la ventana, que es muy cutre
	private Frame (){
		super("Aula Virtual");
		this.setLayout(new BorderLayout());
		this.iniPaneles();
		this.vacio = new JPanel();
		
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
			this.repaint();
		} else if (panel == 1) {
			if (this.der != null) {
				this.der.setVisible(false);
			}
			this.add(nuevo,BorderLayout.CENTER);
			nuevo.setVisible(true);
			this.der = nuevo;
			this.repaint();
		}
	}
	
	/**
	 * Metodo para borrar el panel derecho.
	 */
	public void borrarDer () {
		if (this.der == null) {
			return;
		}
		this.der.setVisible(false);
		this.der = this.vacio;
		this.repaint();
		return;
	}
	
	/**
	 * Metodo que inicializa los paneles dependiendo del tipo de usuario.
	 */
	public void iniPaneles() {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO)) {
			cambiarPanel(new PanelMatriculadas(Aplicacion.getInstance().getUsuarioActual()), 0);
			cambiarPanel(new JPanel(), 1);
		} else if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			cambiarPanel(new PanelAsignaturas(Aplicacion.getInstance()), 0);
			cambiarPanel(new JPanel(), 1);
		}
	}
}
