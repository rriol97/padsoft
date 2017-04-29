package aplicacion.GUI.general;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import aplicacion.GUI.acciones.ActionSolAsig;
import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;

/**
 * Clase que implementa el panel que muestra las asignaturas matriculadas de un alumno. Siempre se muestra en un lateral de la ventana.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelMatriculadas extends JPanel implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
    private JList<String> listOne;
    private JScrollPane scrollingListOne;
    private String[]dataList;
	
	public PanelMatriculadas(Alumno alum) {  
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		String[] dataList = new String[alum.getAsignaturas().size()];
		int i = 0;
		for (Asignatura asig: alum.getAsignaturas()) {
			dataList[i] = asig.getNombre();
			i++;
		}
		
        listOne = new JList<String>(dataList);
        scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)(Frame.HEIGHT/1.25)));
        Button botonAceptar = new Button("Solicitar Asignatura");
        botonAceptar.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)Frame.HEIGHT/22));
        botonAceptar.setFont(new Font("Arial",20,15));
        JLabel tit = new JLabel ("Listado de Asignaturas");
        tit.setFont(new Font("Arial",20,19));
        
        this.add(tit);
        this.dataList = dataList;
        this.add(botonAceptar);
        botonAceptar.addActionListener(new ActionSolAsig());
        this.add(scrollingListOne);
        
        layout.putConstraint(SpringLayout.WEST,botonAceptar,5, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.WEST,tit,5, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,scrollingListOne,25, SpringLayout.NORTH,tit);
        layout.putConstraint(SpringLayout.WEST,scrollingListOne, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH,botonAceptar, 5, SpringLayout.SOUTH, scrollingListOne);

        this.setPreferredSize(new Dimension(250,50));
        this.setVisible(true);
        
        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
	}

	// TODO comentar esta funcion
	/**
	 *
	 */
    public void valueChanged(ListSelectionEvent e) {               
        int selection = this.listOne.getSelectedIndex(); 
        JOptionPane.showMessageDialog(null, dataList[selection]);
    } 
	
}
