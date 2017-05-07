package aplicacion.GUI.paneles.profesor.test;

import java.awt.Dimension;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

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
import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.PanelComun;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;

/**
 * Clase que implementa el panel abstarto de creacion y modificacion de un test.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public abstract class PanelAbstractoCrearTest extends PanelComun{
	protected static final long serialVersionUID = 1L;
	protected JComboBox<String> ordenPreguntas;
	protected JLabel fi;
	protected JLabel ff;
	protected JDatePickerImpl fechaIni;
	protected JDatePickerImpl fechaFin;
	protected JLabel peso;
	protected JTextField campoPeso;
	protected JLabel vpd;
	protected JTextField campoVpd;
	
	public PanelAbstractoCrearTest(Asignatura asig, Tema tema){
		super();
		this.setLayout(new SpringLayout());
		
		JPanel panel_elecciones = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel_elecciones.setLayout(layout);
		String[]orden = {"Ordenadas","No ordenadas"};
		this.ordenPreguntas = new JComboBox<String>(orden);
		panel_elecciones.add(this.ordenPreguntas);
		
		fi = new JLabel("Fecha Inicial");
		ff = new JLabel ("Fecha Fin");
		panel_elecciones.add(fi);
		panel_elecciones.add(ff);
				
		UtilDateModel model = new UtilDateModel();
		UtilDateModel model2 = new UtilDateModel();
		model.setDate(2017, 1, 1);
		model.setSelected(true);
		model2.setDate(2017, 12, 31);
		model2.setSelected(true);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		JDatePanelImpl dataPanel2 = new JDatePanelImpl(model2, new Properties());
		this.fechaIni = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		this.fechaFin = new JDatePickerImpl(dataPanel2,  new DateComponentFormatter());
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
	
	public void setNombre(String nombre){
		this.text.setText(nombre);
	}
	
	public boolean getSelec(){
		if (this.visibilidad.getSelectedItem().equals("Visible")){
			return true;
		}
		return false;
	}
	
	public void setSele(boolean s){
		if (s == true){
			this.visibilidad.setSelectedItem("Visible");
		} else{
			this.visibilidad.setSelectedItem("No visible");
		}
	}
	
	public boolean getOrden(){
		if (this.ordenPreguntas.getSelectedItem().equals("Ordenadas")){
			return false;
		}
		
		return true;
	}
	
	public void setOrden(boolean sel){
		if (sel == false){
			this.ordenPreguntas.setSelectedItem("Ordenadas");
		} else{
			this.ordenPreguntas.setSelectedItem("No ordenadas");
		}
	}
	
	public LocalDate getFechaIni(){
		Date input = (Date)this.fechaIni.getModel().getValue();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date;
	}
	
	public void setFechaIni(LocalDate l){
		this.fechaIni.getModel().setDate(l.getDayOfMonth(), l.getMonthValue(), l.getYear());
	}
	
	public LocalDate getFechaFin(){
		Date input = (Date)this.fechaFin.getModel().getValue();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date;	
	}
	
	public void setFechaFin(LocalDate l){
		this.fechaFin.getModel().setDate(l.getDayOfMonth(), l.getMonthValue(), l.getYear());
	}
	
	public Double getVpd(){
		return Double.parseDouble(this.campoVpd.getText());
	}
	
	public void setVpd(Double d){
		this.campoVpd.setText(Double.toString(d));
	}
	
	public Double getPeso(){
		return Double.parseDouble(this.campoPeso.getText());
	}
	
	public void setPeso(Double d){
		this.campoPeso.setText(Double.toString(d));
	}
	
}