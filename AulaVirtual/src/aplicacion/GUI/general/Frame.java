package aplicacion.GUI.general;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

import aplicacion.GUI.acciones.ActionSalir;
import aplicacion.clases.Aplicacion;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private static Frame instance = new Frame();
	private JPanel der;
	private JPanel izq;
	
	private Frame (){
		super("Aula Virtual");
		this.setLayout(new BorderLayout());
		this.der = null;
		this.izq = new PanelMatriculadas(Aplicacion.getInstance().getUsuarioActual());
		JButton salir = new JButton("Cerrar Sesión");
		this.izq.setVisible(true);
		this.getContentPane().add(this.izq, BorderLayout.WEST);
		this.getContentPane().add(salir,BorderLayout.NORTH);
		salir.addActionListener(new ActionSalir());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	public static Frame getIntance(){
		return instance;
	}
	
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
