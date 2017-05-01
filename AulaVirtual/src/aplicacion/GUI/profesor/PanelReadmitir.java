package aplicacion.GUI.profesor;

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

import aplicacion.GUI.acciones.ActionCancelar;
import aplicacion.GUI.acciones.profesor.ActionReadmitir;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;

/**
 * Clase que implementa el panel de readmision de alumnos en una asignatura.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelReadmitir extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Asignatura asig;
    private Alumno[] expulsados;
    private JList <String> listaExpulsados;
	
	public PanelReadmitir (Asignatura asig) {
		this.asig = asig;
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		JLabel etiqueta_titulo = new JLabel("Alumnos expulsados");
		etiqueta_titulo.setFont(new Font("Arial",12,18));
        this.add(etiqueta_titulo);
		
		String[] lista_expulsados = new String[asig.getExpulsados().size()];
		this.expulsados = new Alumno[asig.getExpulsados().size()];
 		int i = 0;
 		for (Alumno alum: asig.getExpulsados()) {
 			lista_expulsados[i] = alum.toString();
 			this.expulsados[i] = alum;
 			i++;
 		}
 		this.listaExpulsados = new JList<String>(lista_expulsados);
 		listaExpulsados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.listaExpulsados.setPreferredSize(new Dimension(200,30));
 		JScrollPane scrolling_expulsados = new JScrollPane(this.listaExpulsados);
 		scrolling_expulsados.setPreferredSize(new Dimension(200,500));
        this.add(scrolling_expulsados);
        
        etiqueta_titulo.setLabelFor(this.listaExpulsados);
        
        JPanel panel_botones = new JPanel();
        panel_botones.setLayout(new BoxLayout(panel_botones, 0));
        
        Button boton_cancelar = new Button ("Cancelar");
        boton_cancelar.addActionListener(new ActionCancelar());
        panel_botones.add(boton_cancelar);
        
        Button boton_readmitir = new Button ("Readmitir");
        boton_readmitir.addActionListener(new ActionReadmitir(this));
        panel_botones.add(boton_readmitir);
        
        this.add(panel_botones);
        
        layout.putConstraint(SpringLayout.WEST,etiqueta_titulo ,500,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.NORTH,etiqueta_titulo,200 ,SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST,scrolling_expulsados ,500,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.NORTH,scrolling_expulsados,5, SpringLayout.SOUTH,etiqueta_titulo);
        
        layout.putConstraint(SpringLayout.WEST,panel_botones ,500,SpringLayout.WEST ,this);
        layout.putConstraint(SpringLayout.NORTH,panel_botones,5, SpringLayout.SOUTH,scrolling_expulsados);
        
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
		int tam = this.listaExpulsados.getSelectedIndices().length;
		int[] indices = this.listaExpulsados.getSelectedIndices();
		
		List <Alumno> sel = new ArrayList <Alumno> (tam);
		for (int i = 0; i< tam; i++) {
			sel.add(this.expulsados[indices[i]]);
		}
		return sel;
	}
}
