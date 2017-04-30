package aplicacion.GUI.Profesor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import aplicacion.GUI.Alumno.Frame;
import aplicacion.GUI.acciones.ActionPanelCrear;
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
    private JScrollPane scrollingListOne;
    private String[] alumSol;
    
    public PanelSolPendientes() {
    	
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		this.alumSol = getSol();
		
        listOne = new JList<String>(this.alumSol);
        scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)(Frame.HEIGHT/1.25)));
        
        JButton crearAsig = new JButton ("Crear Asignatura");
        crearAsig.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)Frame.HEIGHT/22));
        crearAsig.setFont(new Font("Arial",20,15));
        crearAsig.addActionListener(new ActionPanelCrear());
        
        JLabel tit = new JLabel("Solicitudes Pendientes");
        tit.setFont(new Font ("Arial",12,16));
        
        this.add(this.scrollingListOne,BorderLayout.CENTER);
        this.add(crearAsig,BorderLayout.AFTER_LAST_LINE);
        this.add(tit,BorderLayout.NORTH);
        this.setVisible(true);
        
        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

    	
    }
    
	private String[] getSol(){
    	int index = 0;
    	String[] data = {};
    	for (Asignatura a:Aplicacion.getInstance().getAsignaturas()){
    		for (Solicitud s:a.getSolicitudes()){
    			data[index] = s.getAlumno().getNia()+s.getAlumno().getApellidos();
    		}
    	}
    	return data;
    }

	@Override
	public void valueChanged(ListSelectionEvent e) {
        int selection = this.listOne.getSelectedIndex(); 
        JOptionPane.showMessageDialog(null, alumSol[selection]);
	}
}
