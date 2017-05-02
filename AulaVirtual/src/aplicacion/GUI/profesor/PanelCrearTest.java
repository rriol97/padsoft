package aplicacion.GUI.profesor;

import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Asignatura;

public class PanelCrearTest extends PanelComun {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> ordenPreguntas;
	private JLabel fi;
	private JLabel ff;
	private JDatePickerImpl fechaIni;
	private JDatePickerImpl fechaFin;
	private JButton anadir;
	
	public PanelCrearTest(Asignatura asig){
		super();
		this.setLayout(new SpringLayout());
		
		this.cancelar.addActionListener(new ActionVolverAsig(asig));
		//this.aceptar.addActionListener(new ActionCrearApuntes(asig,this));
		
		JPanel panel_elecciones = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel_elecciones.setLayout(layout);
		String[]orden = {"Ordenadas","No Ordenadas"};
		this.ordenPreguntas = new JComboBox<String>(orden);
		panel_elecciones.add(this.ordenPreguntas);
		
		fi = new JLabel("Fecha Inicial");
		ff = new JLabel ("Fecha Fin");
		panel_elecciones.add(fi);
		panel_elecciones.add(ff);
		
		JPanel preg = new JPanel();
		SpringLayout layoutAna = new SpringLayout();
		preg.setLayout(layoutAna);
		this.anadir = new JButton ("Añadir Pregunta");
		preg.add(this.anadir);
		//layoutAna.putConstraint(SpringLayout.NORTH,this.anadir, 10, SpringLayout.NORTH, preg);
		preg.setVisible(true);
		
		UtilDateModel model = new UtilDateModel();
		model.setDate(2017, 5, 2);
		model.setSelected(true);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		this.fechaIni = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		this.fechaFin = new JDatePickerImpl(datePanel,  new DateComponentFormatter());
		panel_elecciones.add(this.fechaIni);
		panel_elecciones.add(fechaFin);
		layout.putConstraint(SpringLayout.NORTH,this.fi,(int) Frame.HEIGHT/10 ,SpringLayout.NORTH, this.ordenPreguntas);
		layout.putConstraint(SpringLayout.NORTH,this.ff,(int) Frame.HEIGHT/10 ,SpringLayout.NORTH, this.fi);
		layout.putConstraint(SpringLayout.NORTH,this.fechaIni,(int) Frame.HEIGHT/10 ,SpringLayout.NORTH, this.ordenPreguntas);
		layout.putConstraint(SpringLayout.NORTH,this.fechaFin,(int) Frame.HEIGHT/10 ,SpringLayout.NORTH, this.fechaIni);
		layout.putConstraint(SpringLayout.WEST,this.fechaIni,(int) Frame.HEIGHT/8 ,SpringLayout.WEST, this.fi);
		layout.putConstraint(SpringLayout.WEST,this.fechaFin,(int) Frame.HEIGHT/8,SpringLayout.WEST, this.ff);
		this.add(aux);
		this.add(preg);
		this.add(panel_elecciones);
		this.add(panel_botones);
		
		
		SpringUtilities.makeCompactGrid(this, 4, 1, 5, 5, 5, 5);
		
	}
	
	public String getSelec(){
		return (String) this.visibilidad.getSelectedItem();
	}
	
	public String getOrden(){
		return (String) this.ordenPreguntas.getSelectedItem();
	}
	
	public LocalDate getFechaIni(){
		return (LocalDate) this.fechaIni.getModel().getValue();
	}
	
	public LocalDate getFechaFin(){
		return (LocalDate) this.fechaFin.getModel().getValue();
	}
}
