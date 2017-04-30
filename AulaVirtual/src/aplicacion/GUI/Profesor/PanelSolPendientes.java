package aplicacion.GUI.Profesor;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;

/**
 * Clase que implementa la lista de solicitudes y el boton de crear asignatura (visible en la vista del profesor)
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelSolPendientes extends JPanel implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
	
	private JList<String> listOne;
    private Solicitud[] solicitudes;
    
    public PanelSolPendientes(Aplicacion ap) {
		this.setLayout(new SpringLayout());
		
		JLabel tit = new JLabel("Solicitudes Pendientes");
        tit.setFont(new Font ("Arial",12,18));
        this.add(tit);
        
        this.solicitudes = new Solicitud [ap.getAlumnos().size()*ap.getAsignaturas().size()];
		String[] arraySol = getSol(ap);
        listOne = new JList<String>(arraySol);
        JScrollPane scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension((int)(5*Frame.WIDTH/6),(int)(Frame.HEIGHT/1.5)));
        this.add(scrollingListOne);
        
        SpringUtilities.makeCompactGrid(this, 2, 1, 5, 5, 5, 5);
        
        this.setVisible(true);
        
        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
	private String[] getSol(Aplicacion ap){
    	int index = 0;
    	String[] data = new String[ap.getAlumnos().size()*ap.getAsignaturas().size()];
    	for (Asignatura a: ap.getAsignaturas()){
    		for (Solicitud s: a.getSolicitudes()){
    			this.solicitudes[index] = s;
    			data[index] = s.toString();
    			index++;
    		}
    	}
    	return data;
    }
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int sel = this.listOne.getSelectedIndex();
		Frame.getIntance().cambiarPanel(new PanelSolProf(this.solicitudes[sel]), 1);
	}
}
