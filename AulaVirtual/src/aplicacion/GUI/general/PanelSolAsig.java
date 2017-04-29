package aplicacion.GUI.componentes;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.general.Frame;

public class PanelSolAsig extends JPanel {
    private JComboBox listaAsig;
    private JScrollPane scrollingAsig;
 
    
    public PanelSolAsig (String [] asig){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
  
        listaAsig = new JComboBox(asig);
        JLabel etiq = new JLabel("Asignaturas");
        etiq.setFont(new Font("Arial",12,18));
        scrollingAsig = new JScrollPane(listaAsig);
        scrollingAsig.setPreferredSize(new Dimension(200,30));
        JTextField texto = new JTextField(30);
        JLabel coment = new JLabel ("Comentario");
        coment.setFont(new Font("Arial",12,18));
        texto.setPreferredSize(new Dimension((int)(Frame.WIDTH/23),(int)(Frame.HEIGHT/23)));
        Button botonAcp = new Button ("Enviar");
        botonAcp.setPreferredSize(new Dimension((int)Frame.WIDTH/20,(int)Frame.HEIGHT/35));
        Button botonCnr = new Button ("Cancelar");
        botonCnr.setPreferredSize(new Dimension((int)Frame.WIDTH/18,(int)Frame.HEIGHT/35));
        
        this.add(etiq);
        this.add(scrollingAsig);
        this.add(coment);
        this.add(texto);
        this.add(botonAcp);
        this.add(botonCnr);
        
        layout.putConstraint(SpringLayout.NORTH,etiq,200 ,SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST,etiq ,200,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.WEST,scrollingAsig,20, SpringLayout.EAST,etiq);
        layout.putConstraint(SpringLayout.NORTH,scrollingAsig,200, SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.NORTH,coment,25, SpringLayout.SOUTH,etiq);
        layout.putConstraint(SpringLayout.WEST,coment,200,SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST,texto,10, SpringLayout.EAST,coment);
        layout.putConstraint(SpringLayout.NORTH,texto,15, SpringLayout.SOUTH,scrollingAsig);
        layout.putConstraint(SpringLayout.NORTH,botonCnr,60, SpringLayout.SOUTH,texto);
        layout.putConstraint(SpringLayout.WEST,botonCnr,500, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.WEST,botonAcp,3, SpringLayout.EAST,botonCnr);
        layout.putConstraint(SpringLayout.NORTH,botonAcp,60, SpringLayout.SOUTH,texto);
        
        this.setPreferredSize(new Dimension((int)Frame.WIDTH/3,(int)Frame.HEIGHT/3));
        this.setVisible(true);
        
    }
    
}

