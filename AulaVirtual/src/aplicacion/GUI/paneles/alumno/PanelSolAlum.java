package aplicacion.GUI.paneles.alumno;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.acciones.ActionCancelar;
import aplicacion.GUI.acciones.alumno.ActionEnviarSol;
import aplicacion.GUI.frame.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;

/**
 * Clase que implementa el panel que se muestra cuando un alumno quiere solicitar una asignatura.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelSolAlum extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Asignatura> listaAsig;
    private JTextField texto;
    
    public PanelSolAlum (Aplicacion ap){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		Asignatura[] lista_asig = new Asignatura[ap.getAsignaturas().size()];
 		int i = 0;
 		for (Asignatura asig: ap.getAsignaturas()) {
 			lista_asig[i] = asig;
 			i++;
 		}
 		this.listaAsig = new JComboBox<Asignatura>(lista_asig);
 		this.listaAsig.setPreferredSize(new Dimension(200,30));

        JLabel etiq = new JLabel("Asignaturas");
        etiq.setFont(new Font("Arial",12,18));
        etiq.setLabelFor(this.listaAsig);
        
        texto = new JTextField(30);
        JLabel comment = new JLabel ("Comentario");
        comment.setFont(new Font("Arial",12,18));
        texto.setPreferredSize(new Dimension((int)(Frame.WIDTH/23),(int)(Frame.HEIGHT/23)));
        comment.setLabelFor(texto);
        
        Button botonAcp = new Button ("Enviar");
        botonAcp.addActionListener(new ActionEnviarSol(this));
        botonAcp.setPreferredSize(new Dimension((int)Frame.WIDTH/20,(int)Frame.HEIGHT/35));
        Button botonCnr = new Button ("Cancelar");
        botonCnr.addActionListener(new ActionCancelar());
        botonCnr.setPreferredSize(new Dimension((int)Frame.WIDTH/18,(int)Frame.HEIGHT/35));
        
        this.add(etiq);
        this.add(this.listaAsig);
        this.add(comment);
        this.add(texto);
        this.add(botonAcp);
        this.add(botonCnr);
        
        layout.putConstraint(SpringLayout.NORTH, etiq, (int)(Frame.HEIGHT/4), SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, etiq, (int)(Frame.WIDTH/6), SpringLayout.WEST, this);
        
        layout.putConstraint(SpringLayout.WEST, this.listaAsig, 20, SpringLayout.EAST, etiq);
        layout.putConstraint(SpringLayout.NORTH, this.listaAsig, (int)(Frame.HEIGHT/4), SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.NORTH, comment, 25, SpringLayout.SOUTH, etiq);
        layout.putConstraint(SpringLayout.WEST, comment, (int)(Frame.WIDTH/6), SpringLayout.WEST, this);
        
        layout.putConstraint(SpringLayout.WEST, texto, 10, SpringLayout.EAST, comment);
        layout.putConstraint(SpringLayout.NORTH, texto, 15, SpringLayout.SOUTH, this.listaAsig);
        
        layout.putConstraint(SpringLayout.NORTH, botonCnr, 60, SpringLayout.SOUTH, texto);
        layout.putConstraint(SpringLayout.WEST, botonCnr, (int)(Frame.WIDTH/6), SpringLayout.WEST, this);
        
        layout.putConstraint(SpringLayout.WEST, botonAcp, 3, SpringLayout.EAST, botonCnr);
        layout.putConstraint(SpringLayout.NORTH, botonAcp, 60, SpringLayout.SOUTH, texto);
        
        this.setPreferredSize(new Dimension((int)Frame.WIDTH/3,(int)Frame.HEIGHT/3));
    }
    
    public String getComentario(){
    	return this.texto.getText(); 
    }
    
    public Asignatura getSeleccionada(){
    	return (Asignatura) this.listaAsig.getSelectedItem();
    }
    
}
