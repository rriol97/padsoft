package aplicacion.GUI.componentes;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class PanelSolAsig extends JPanel implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
    private JList listOne;
    private JScrollPane scrollingListOne;
    private String[]dataList;
	
	public PanelSolAsig(String[]dataList) {  
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
        listOne = new JList(dataList);
        scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension(200,600));
        Button botonAceptar = new Button("Solicitar Asignatura");
        botonAceptar.setPreferredSize(new Dimension(150,50));
        botonAceptar.setFont(new Font("Arial",20,15));
        JLabel tit = new JLabel ("Listado de Asignaturas");
        tit.setFont(new Font("Arial",20,20));
        
        this.add(tit);
        this.dataList = dataList;
        this.add(botonAceptar);
        this.add(scrollingListOne);
        
        layout.putConstraint(SpringLayout.WEST,botonAceptar,5, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.WEST,tit,5, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,scrollingListOne,25, SpringLayout.NORTH,tit);
        layout.putConstraint(SpringLayout.WEST,scrollingListOne, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH,botonAceptar, 5, SpringLayout.SOUTH, scrollingListOne);

        this.setPreferredSize(new Dimension(250,50));
        this.setVisible(true);
        // listener para la lista
        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
	}

    public void valueChanged(ListSelectionEvent e) {               
        int selection = this.listOne.getSelectedIndex(); 
        JOptionPane.showMessageDialog(null, dataList[selection]);
    } 
	
}
