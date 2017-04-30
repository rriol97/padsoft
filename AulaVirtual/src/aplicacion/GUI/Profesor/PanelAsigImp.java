package aplicacion.GUI.Profesor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import aplicacion.GUI.Alumno.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;


/**
 * Clase que implementa la lista de asignaturas de la aplicacion (visible en la vista del profesor)
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelAsigImp extends JPanel implements ListSelectionListener{
	private static final long serialVersionUID = 1L;
    private JList<String> listOne;
    private JScrollPane scrollingListOne;
    private String[]dataList;

	public PanelAsigImp(){
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		String[] dataList = new String[Aplicacion.getInstance().getAsignaturas().size()];
		int i = 0;
		for (Asignatura asig: Aplicacion.getInstance().getAsignaturas()) {
			dataList[i] = asig.getNombre();
			i++;
		}
		
        listOne = new JList<String>(dataList);
        scrollingListOne = new JScrollPane(listOne);
        scrollingListOne.setPreferredSize(new Dimension((int)(Frame.WIDTH/1.25),(int)(Frame.HEIGHT/1.2)));
        scrollingListOne.setFont(new Font ("Arial",12,18));
        this.add(scrollingListOne, BorderLayout.CENTER);
        this.setVisible(true);

        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		 int selection = this.listOne.getSelectedIndex(); 
	     JOptionPane.showMessageDialog(null, dataList[selection]);
	}
}
