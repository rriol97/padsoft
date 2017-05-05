package aplicacion.GUI.paneles.profesor;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionElegirTema;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;

public class PanelCrearEle extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox <String> listaElem;
	private JList <Tema> listaTemas;
	
	public PanelCrearEle(Asignatura asig){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		String[] tipoElem = {"Test","Apuntes","Tema"};
		this.listaElem = new JComboBox<String>(tipoElem);
		
		this.setPreferredSize(new Dimension((int)Frame.WIDTH/5,(int)Frame.HEIGHT/5));
		
		JLabel etiq = new JLabel("Tipo de elemento");
		etiq.setFont(new Font("Arial",12,20));
		
		Tema[] temas = new Tema[asig.getTemas().size()];
 		int i = 0;
 		for (Tema tema: asig.getTemas()) {
 			temas[i] = tema;
 			i++;
 		}
		this.listaTemas = new JList<Tema>(temas);
		this.listaTemas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		JScrollPane scrolling_temas = new JScrollPane(this.listaTemas);
 		scrolling_temas.setPreferredSize(new Dimension((int)Frame.WIDTH/3,(int)(Frame.HEIGHT)));
        this.add(scrolling_temas);
		
		JButton aceptar = new JButton ("Aceptar");
		aceptar.addActionListener(new ActionElegirTema(this, asig));
		aceptar.setPreferredSize(new Dimension((int)Frame.WIDTH/10,(int)Frame.HEIGHT/25));
		JButton cancelar = new JButton ("Cancelar");
		cancelar.setPreferredSize(new Dimension((int)Frame.WIDTH/10,(int)Frame.HEIGHT/25));
		cancelar.addActionListener(new ActionVolverAsig(asig));
		
		this.add(etiq);
		this.add(this.listaElem);
		this.add(cancelar);
		this.add(aceptar);
		
		layout.putConstraint(SpringLayout.NORTH,etiq,200 ,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST,etiq ,290,SpringLayout.WEST ,this);
		layout.putConstraint(SpringLayout.WEST,this.listaElem,20, SpringLayout.EAST,etiq);
		layout.putConstraint(SpringLayout.NORTH,this.listaElem,200, SpringLayout.NORTH,this);
		layout.putConstraint(SpringLayout.NORTH,cancelar,60, SpringLayout.SOUTH,this.listaElem);
		layout.putConstraint(SpringLayout.WEST,cancelar,290, SpringLayout.WEST,this);
		layout.putConstraint(SpringLayout.WEST,aceptar,3, SpringLayout.EAST,cancelar);
		layout.putConstraint(SpringLayout.NORTH,aceptar,60, SpringLayout.SOUTH,this.listaElem);
		layout.putConstraint(SpringLayout.WEST,scrolling_temas ,50,SpringLayout.EAST ,aceptar);

	}
	
    public String getOpcSel(){
    	return (String) this.listaElem.getSelectedItem();
    	
    }
    
    /**
	 * Metodo que devuelve el temas que ha sido seleccionado en el panel.
	 * @return Tema seleccionado en el panel.
	 */
	public Tema getTemaSel() {
		return this.listaTemas.getSelectedValue();
	}
}
