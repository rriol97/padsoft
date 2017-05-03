package aplicacion.GUI.profesor;

import java.awt.Dimension;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionAnadirPregunta;
import aplicacion.GUI.acciones.profesor.ActionCrearTest;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Asignatura;

public class PanelCrearTest extends PanelComun {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> ordenPreguntas;
	private JLabel fi;
	private JLabel ff;
	private JDatePickerImpl fechaIni;
	private JDatePickerImpl fechaFin;
	private JLabel peso;
	private JTextField campoPeso;
	private JLabel vpd;
	private JTextField campoVpd;
	
	public PanelCrearTest(Asignatura asig){
		super();
		this.setLayout(new SpringLayout());
		
		this.cancelar.addActionListener(new ActionVolverAsig(asig));
		this.aceptar.addActionListener(new ActionCrearTest(asig,this));
		
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
		
		JPanel panelPeso = new JPanel();
		SpringLayout layoutPeso = new SpringLayout();
		panelPeso.setLayout(layoutPeso);
		this.peso = new JLabel ("Peso");
		this.campoPeso = new JTextField();
		this.campoPeso.setPreferredSize(new Dimension((int)Frame.WIDTH/5,30));
		this.vpd = new JLabel ("Valor por defecto");
		this.campoVpd = new JTextField();
		this.campoVpd.setPreferredSize(new Dimension((int)Frame.WIDTH/6,30));
		panelPeso.add(this.peso);
		panelPeso.add(this.campoPeso);
		panelPeso.add(this.vpd);
		panelPeso.add(this.campoVpd);
		layoutPeso.putConstraint(SpringLayout.WEST,this.campoPeso,(int) Frame.HEIGHT/10 ,SpringLayout.WEST, this.peso);
		layoutPeso.putConstraint(SpringLayout.NORTH,this.vpd,(int) Frame.HEIGHT/8 ,SpringLayout.NORTH, this.peso);
		layoutPeso.putConstraint(SpringLayout.WEST,this.campoVpd,(int) Frame.HEIGHT/6 ,SpringLayout.WEST, this.vpd);
		layoutPeso.putConstraint(SpringLayout.NORTH,this.campoVpd,(int) Frame.HEIGHT/8 ,SpringLayout.NORTH, this.campoPeso);
		
		this.add(aux);
		this.add(panel_elecciones);
		this.add(panelPeso);
		this.add(panel_botones);
		
		
		SpringUtilities.makeCompactGrid(this, 4, 1, 5, 5, 5, 5);
		
	}
	
	public String getNombre(){
		return this.text.getText();
	}
	
	public boolean getSelec(){
		if (this.visibilidad.getSelectedItem().equals("Visible")){
			return true;
		}
		return false;
	}
	
	public boolean getOrden(){
		if (this.ordenPreguntas.getSelectedItem().equals("Ordenadas")){
			return true;
		}
		
		return false;
	}
	
	public LocalDate getFechaIni(){
		Date input = (Date)this.fechaIni.getModel().getValue();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date;
	}
	
	public LocalDate getFechaFin(){
		Date input = (Date)this.fechaFin.getModel().getValue();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date;	
	}
	
	public Double getVpd(){
		return Double.parseDouble(this.campoVpd.getText());
	}
	
	public Double getPeso(){
		return Double.parseDouble(this.campoPeso.getText());
	}
}
