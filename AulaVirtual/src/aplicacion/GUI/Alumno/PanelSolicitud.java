package aplicacion.GUI.Alumno;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.acciones.ActionCancelarSol;
import aplicacion.GUI.acciones.ActionEnviarSol;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;

/**
 * Clase que implementa el panel que se muestra cuando un alumno quiere solicitar una asignatura.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelSolicitud extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> listaAsig;
    private JScrollPane scrollingAsig;
    private JTextField texto;
 
    
    public PanelSolicitud (Aplicacion ap){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		String[] lista_asig = new String[ap.getAsignaturas().size()];
 		int i = 0;
 		for (Asignatura asig: ap.getAsignaturas()) {
 			lista_asig[i] = asig.getNombre();
 			i++;
 		}
 		this.listaAsig = new JComboBox<String>(lista_asig);
        
        JLabel etiq = new JLabel("Asignaturas");
        etiq.setFont(new Font("Arial",12,18));
        scrollingAsig = new JScrollPane(listaAsig);
        scrollingAsig.setPreferredSize(new Dimension(200,30));
        etiq.setLabelFor(scrollingAsig);
        
        texto = new JTextField(30);
        JLabel comment = new JLabel ("Comentario");
        comment.setFont(new Font("Arial",12,18));
        texto.setPreferredSize(new Dimension((int)(Frame.WIDTH/23),(int)(Frame.HEIGHT/23)));
        comment.setLabelFor(texto);
        
        Button botonAcp = new Button ("Enviar");
        botonAcp.addActionListener(new ActionEnviarSol(this));
        botonAcp.setPreferredSize(new Dimension((int)Frame.WIDTH/20,(int)Frame.HEIGHT/35));
        Button botonCnr = new Button ("Cancelar");
        botonCnr.addActionListener(new ActionCancelarSol());
        botonCnr.setPreferredSize(new Dimension((int)Frame.WIDTH/18,(int)Frame.HEIGHT/35));
        
        this.add(etiq);
        this.add(scrollingAsig);
        this.add(comment);
        this.add(texto);
        this.add(botonAcp);
        this.add(botonCnr);
        
        layout.putConstraint(SpringLayout.NORTH,etiq,200 ,SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST,etiq ,200,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.WEST,scrollingAsig,20, SpringLayout.EAST,etiq);
        layout.putConstraint(SpringLayout.NORTH,scrollingAsig,200, SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.NORTH,comment,25, SpringLayout.SOUTH,etiq);
        layout.putConstraint(SpringLayout.WEST,comment,200,SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST,texto,10, SpringLayout.EAST,comment);
        layout.putConstraint(SpringLayout.NORTH,texto,15, SpringLayout.SOUTH,scrollingAsig);
        layout.putConstraint(SpringLayout.NORTH,botonCnr,60, SpringLayout.SOUTH,texto);
        layout.putConstraint(SpringLayout.WEST,botonCnr,500, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.WEST,botonAcp,3, SpringLayout.EAST,botonCnr);
        layout.putConstraint(SpringLayout.NORTH,botonAcp,60, SpringLayout.SOUTH,texto);
        
        this.setPreferredSize(new Dimension((int)Frame.WIDTH/3,(int)Frame.HEIGHT/3));
        this.setVisible(true);
    }
    
    public String getComentario(){
    	return this.texto.getText(); 
    }
    
    public Asignatura getSeleccionada(Aplicacion ap){
    	for (Asignatura a: ap.getAsignaturas()){
    		if (a.getNombre().equals(this.listaAsig.getSelectedItem())){
    			return a;
    		}
    	}
    	
    	return null;
    }
    
}
