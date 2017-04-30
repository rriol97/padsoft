package aplicacion.GUI.Profesor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import aplicacion.GUI.acciones.ActionCrearAsig;
import aplicacion.GUI.acciones.ActionMostrarSol;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;


/**
 * Clase que implementa la lista de asignaturas de la aplicacion (visible en la vista del profesor)
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelAsignaturas extends JPanel implements ListSelectionListener{
	private static final long serialVersionUID = 1L;
	
    private JList<String> listOne;
    private JScrollPane scrollingListOne;
    private String[]dataList;

	public PanelAsignaturas(Aplicacion ap){
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		String[] dataList = new String[ap.getAsignaturas().size()];
		int i = 0;
		for (Asignatura asig: ap.getAsignaturas()) {
			dataList[i] = asig.getNombre();
			i++;
		}
		
        listOne = new JList<String>(dataList);
        scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)(Frame.HEIGHT/1.25)));
        scrollingListOne.setFont(new Font ("Arial",12,18));
        this.add(scrollingListOne, BorderLayout.CENTER);
        this.setVisible(true);
        
        JPanel aux = new JPanel();
        aux.setLayout(new BoxLayout(aux, 0));
        
        JButton crearAsig = new JButton ("Crear Asignatura");
        crearAsig.setPreferredSize(new Dimension((int)Frame.WIDTH/12,(int)Frame.HEIGHT/22));
        crearAsig.setFont(new Font("Arial",20,15));
        crearAsig.addActionListener(new ActionCrearAsig());
        aux.add(crearAsig);
        
        JButton solicitudes = new JButton ("Solicitudes");
        solicitudes.setPreferredSize(new Dimension((int)Frame.WIDTH/12,(int)Frame.HEIGHT/22));
        solicitudes.setFont(new Font("Arial",20,15));
        solicitudes.addActionListener(new ActionMostrarSol());
        aux.add(solicitudes);
        
        crearAsig.addActionListener(new ActionCrearAsig());
        solicitudes.addActionListener(new ActionMostrarSol());
        
        this.add(aux, BorderLayout.AFTER_LAST_LINE);

        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		 int selection = this.listOne.getSelectedIndex(); 
	     JOptionPane.showMessageDialog(null, dataList[selection]);
	}
}
