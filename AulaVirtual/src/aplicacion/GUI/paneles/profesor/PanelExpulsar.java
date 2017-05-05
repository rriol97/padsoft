package aplicacion.GUI.paneles.profesor;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionExpulsar;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;

/**
 * Clase que implementa el panel de expulsion de alumnos en una asignatura.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelExpulsar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Asignatura asig;
    private Alumno[] matriculados;
    private JList <String> listaMatriculados;
	
	public PanelExpulsar (Asignatura asig) {
		this.asig = asig;
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		JLabel etiqueta_titulo = new JLabel("Alumnos matriculados");
		etiqueta_titulo.setFont(new Font("Arial",12,18));
        this.add(etiqueta_titulo);
		
		String[] lista_matriculados = new String[asig.getMatriculados().size()];
		this.matriculados = new Alumno[asig.getMatriculados().size()];
 		int i = 0;
 		for (Alumno alum: asig.getMatriculados()) {
 			lista_matriculados[i] = alum.toString();
 			this.matriculados[i] = alum;
 			i++;
 		}
 		this.listaMatriculados = new JList<String>(lista_matriculados);
 		listaMatriculados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //this.listaMatriculados.setPreferredSize(new Dimension((int)Frame.WIDTH/3,(int)Frame.HEIGHT));
 		JScrollPane scrolling_matriculados = new JScrollPane(this.listaMatriculados);
 		scrolling_matriculados.setPreferredSize(new Dimension((int)Frame.WIDTH/3,(int)(Frame.HEIGHT/1.5)));
        this.add(scrolling_matriculados);
        
        etiqueta_titulo.setLabelFor(this.listaMatriculados);
        
        JPanel panel_botones = new JPanel();
        panel_botones.setLayout(new BoxLayout(panel_botones, 0));
        
        Button boton_cancelar = new Button ("Cancelar");
        boton_cancelar.addActionListener(new ActionVolverAsig(asig));
        panel_botones.add(boton_cancelar);
        
        Button boton_expulsar = new Button ("Expulsar");
        boton_expulsar.addActionListener(new ActionExpulsar(this));
        panel_botones.add(boton_expulsar);
        
        this.add(panel_botones);
        
        layout.putConstraint(SpringLayout.WEST,etiqueta_titulo ,200,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.NORTH,etiqueta_titulo,(int)(Frame.WIDTH/20) ,SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST,scrolling_matriculados ,200,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.NORTH,scrolling_matriculados,5, SpringLayout.SOUTH,etiqueta_titulo);
        
        layout.putConstraint(SpringLayout.WEST,panel_botones ,200,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.NORTH,panel_botones,5, SpringLayout.SOUTH,scrolling_matriculados);

        this.setPreferredSize(new Dimension((int)Frame.WIDTH/3,(int)Frame.HEIGHT/3));
	}
	
	public Asignatura getAsignatura() {
		return this.asig;
	}
	
	/**
	 * Metodo que devuelve una lista de alumnos que han sido seleccionados en el panel.
	 * @return Lista de alumnos seleccionados en el panel.
	 */
	public List <Alumno> getSeleccionados() {
		int tam = this.listaMatriculados.getSelectedIndices().length;
		int[] indices = this.listaMatriculados.getSelectedIndices();
		
		List <Alumno> sel = new ArrayList <Alumno> (tam);
		for (int i = 0; i< tam; i++) {
			sel.add(this.matriculados[indices[i]]);
		}
		return sel;
	}
}
