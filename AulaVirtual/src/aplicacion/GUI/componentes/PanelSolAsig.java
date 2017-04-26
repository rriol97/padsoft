package aplicacion.GUI.componentes;

import java.awt.BorderLayout;

import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PanelSolAsig extends JPanel implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
    private JList listOne;
    private JScrollPane scrollingListOne;
    private String[]dataList;
	
	public PanelSolAsig(String[]dataList) {        
        listOne = new JList(dataList);
        scrollingListOne = new JScrollPane(listOne);
        this.dataList = dataList;
                
        this.add(scrollingListOne);
                
        // listener para la lista
        listOne.addListSelectionListener(this); 
        listOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
	}

    public void valueChanged(ListSelectionEvent e) {               
        int selection = this.listOne.getSelectedIndex(); 
        JOptionPane.showMessageDialog(null, dataList[selection]);
    } 
	
}
