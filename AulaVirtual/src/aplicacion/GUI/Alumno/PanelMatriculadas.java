package aplicacion.GUI.Alumno;

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

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionSolAsig;
import aplicacion.GUI.general.Frame;
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
		
		JLabel etiqueta_asignaturas = new JLabel ("Listado de Asignaturas");
        etiqueta_asignaturas.setFont(new Font("Arial",20,19));
		this.add(etiqueta_asignaturas);
		
        listOne = new JList<String>(dataList);
        this.dataList = dataList;
        scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)(Frame.HEIGHT/1.25)));
        this.add(scrollingListOne);
        
        Button boton_solicitud = new Button("Solicitar Asignatura");
        boton_solicitud.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)Frame.HEIGHT/22));
        boton_solicitud.setFont(new Font("Arial",20,15));
        this.add(boton_solicitud);

        boton_solicitud.addActionListener(new ActionSolAsig());

        SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);

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
