package aplicacion.GUI.general;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

import aplicacion.GUI.componentes.PanelAsig;
import aplicacion.GUI.componentes.PanelAsig2;



public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private static Frame instance = new Frame();
	private JPanel derecha;
	
	private Frame(){
		super("Aula Virtual");
		this.setLayout(new BorderLayout());
		String []asig = {"Hola", "Adios"};
		JTree b = new JTree();
		PanelAsig pa = new PanelAsig (b);
		this.derecha = pa;
		PanelAsig2 pb = new PanelAsig2(asig);
		pa.setVisible(true);
		pb.setVisible(true);
		this.getContentPane().add(pa,BorderLayout.CENTER);
		this.getContentPane().add(pb,BorderLayout.WEST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	public static Frame getIntance(){
		return instance;
	}
	
	public void cambiarPanel (JPanel nuevo) {
		this.derecha.setVisible(false);
		nuevo.setVisible(true);
		this.add(nuevo,BorderLayout.CENTER);
		this.repaint();
	}
}
