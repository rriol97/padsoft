package aplicacion.GUI.paneles.profesor;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.ActionCrearAsig;
import aplicacion.GUI.acciones.profesor.ActionMostrarSol;
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

	public PanelAsignaturas(Aplicacion ap){
		this.setLayout(new SpringLayout());

		JLabel etiqueta_asignaturas = new JLabel ("Listado de Asignaturas");
        etiqueta_asignaturas.setFont(new Font("Arial",12,18));
		this.add(etiqueta_asignaturas);
		
		String[] dataList = new String[ap.getAsignaturas().size()];
		int i = 0;
		for (Asignatura asig: ap.getAsignaturas()) {
			dataList[i] = asig.getNombre();
			i++;
		}
	
        listOne = new JList<String>(dataList);
        JScrollPane scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)(Frame.HEIGHT/1.25)));
        scrollingListOne.setFont(new Font ("Arial",12,18));
        this.add(scrollingListOne);
        this.setVisible(true);
        
        JPanel aux = new JPanel();
        aux.setLayout(new BoxLayout(aux, 0));
        
        JButton crearAsig = new JButton ("Crear Asignatura");
        crearAsig.addActionListener(new ActionCrearAsig());
        aux.add(crearAsig);
        
        JButton solicitudes = new JButton ("Solicitudes");
        solicitudes.addActionListener(new ActionMostrarSol());
        aux.add(solicitudes);
        
        crearAsig.addActionListener(new ActionCrearAsig());
        solicitudes.addActionListener(new ActionMostrarSol());
        
        this.add(aux);
        
        SpringUtilities.makeCompactGrid(this, 3, 1, 10, 10, 5, 5);

        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	/**
	 * Metodo que enlaza una asignatura con su panel
	 */
    public void valueChanged(ListSelectionEvent e) {               
        String selection = this.listOne.getSelectedValue();
        for (Asignatura asig : Aplicacion.getInstance().getAsignaturas()){
        	if (asig.getNombre().equals(selection)){
        		Frame.getInstance().cambiarPanel(new PanelAsigProf(asig), 1);
        	}
        }
	}
}
