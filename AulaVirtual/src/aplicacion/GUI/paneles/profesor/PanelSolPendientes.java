package aplicacion.GUI.paneles.profesor;

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
	
	private JList<Solicitud> listOne;
    
    public PanelSolPendientes(Aplicacion ap) {
    	SpringLayout l = new SpringLayout(); 
		this.setLayout(l);
		
		JLabel tit = new JLabel("Solicitudes Pendientes");
        tit.setFont(new Font ("Arial",12,18));
        this.add(tit);
        
		Solicitud[] arraySol = getSol(ap);
        listOne = new JList<Solicitud>(arraySol);
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension((int)(Frame.WIDTH/6),(int)(Frame.HEIGHT/1.25)));
        this.add(scrollingListOne);
        
        l.putConstraint(SpringLayout.WEST, tit, (int) (Frame.WIDTH/3), SpringLayout.WEST, this);
        l.putConstraint(SpringLayout.WEST, scrollingListOne, (int) (Frame.WIDTH/3), SpringLayout.WEST, this);
        l.putConstraint(SpringLayout.NORTH, scrollingListOne, 5, SpringLayout.SOUTH, tit);
        
        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
	private Solicitud[] getSol(Aplicacion ap){
		int numSol = 0;
    	for (Asignatura asig: ap.getAsignaturas()) {
    		numSol = numSol + asig.getSolicitudes().size();
    	}
    	
    	Solicitud[] data = new Solicitud[numSol];
    	int index = 0;
    	for (Asignatura a: ap.getAsignaturas()){
    		for (Solicitud s: a.getSolicitudes()){
    			data[index] = s;
    			index++;
    		}
    	}
    	return data;
    }
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Solicitud sel = this.listOne.getSelectedValue();
		Frame.getInstance().cambiarPanel(new PanelSolProf(sel), 1);
	}
}
