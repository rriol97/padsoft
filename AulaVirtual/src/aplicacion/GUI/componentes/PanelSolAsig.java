package aplicacion.GUI.componentes;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class PanelSolAsig extends JFrame {
    private JComboBox listaAsig;
    private JScrollPane scrollingAsig;
    private String[]asignaturas;
    
    public PanelSolAsig (String [] asig, String text){
    	super (text);
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
    	this.asignaturas = asig;
    	
        listaAsig = new JComboBox(this.asignaturas);
        JLabel etiq = new JLabel("Asignaturas");
        //etiq.setFont(new Font ("Arial",12,15));
        scrollingAsig = new JScrollPane(listaAsig);
        scrollingAsig.setPreferredSize(new Dimension(200,30));
        JTextField texto = new JTextField(30);
        JLabel coment = new JLabel ("Comentario");
        texto.setPreferredSize(new Dimension(5,50));
        Button botonAcp = new Button ("Aceptar");
        botonAcp.setPreferredSize(new Dimension(65,30));
        Button botonCnr = new Button ("Cancelar");
        botonCnr.setPreferredSize(new Dimension(65,30));
        
        this.add(etiq);
        this.add(scrollingAsig);
        this.add(coment);
        this.add(texto);
        this.add(botonAcp);
        this.add(botonCnr);
        
        layout.putConstraint(SpringLayout.WEST,etiq ,30,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.NORTH,etiq ,5,SpringLayout.SOUTH ,this);
        layout.putConstraint(SpringLayout.WEST,scrollingAsig,20, SpringLayout.EAST,etiq);
        layout.putConstraint(SpringLayout.NORTH,scrollingAsig,5, SpringLayout.SOUTH,this);
        layout.putConstraint(SpringLayout.NORTH,coment,25, SpringLayout.SOUTH,etiq);
        layout.putConstraint(SpringLayout.WEST,coment, 30,SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST,texto,10, SpringLayout.EAST,coment);
        layout.putConstraint(SpringLayout.NORTH,texto,15, SpringLayout.SOUTH,scrollingAsig);
        layout.putConstraint(SpringLayout.NORTH,botonCnr,60, SpringLayout.SOUTH,texto);
        layout.putConstraint(SpringLayout.WEST,botonCnr,350, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.WEST,botonAcp,5, SpringLayout.EAST,botonCnr);
        layout.putConstraint(SpringLayout.NORTH,botonAcp,60, SpringLayout.SOUTH,texto);
        
       
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
    		String[]data = {"Ricardo", "Adrian", "Alejo", "aaa", "bbb", "ccc", "ddddddddddddddd"};
            Runnable runner = new Runnable() {
                    public void run() {
                            int APP_WIDTH  = 500;
                            int APP_HEIGHT = 250;

                            // Ventana principal 
                            final PanelSolAsig frame = 
                                    new PanelSolAsig(data,"Solicitud de Asignaturas");
                                                                                            
                            frame.setSize(APP_WIDTH, APP_HEIGHT);
                            frame.setResizable(false);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                
                            frame.setVisible(true);                                                        
                    }
            };
            SwingUtilities.invokeLater(runner);                
    }
}

