package aplicacion.GUI.paneles.profesor.test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.ActionEditarFechaFin;
import aplicacion.GUI.acciones.profesor.ActionVolverVisTest;
import aplicacion.clases.elemento.test.Test;

/**
 * Panel que edita la fecha fin de un test cuando este ya ha sido respondido por algún alumno matriculado
 * @author Ricardo Riol y Adrián Fernández
 *
 */

public class PanelEditarFechaFin extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JDatePickerImpl fechaFin;
	
	public PanelEditarFechaFin (Test t){
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel ();
		JLabel tit = new JLabel("Editar fecha fin");
		tit.setFont(new Font("Arial",12,18));
		panel.setLayout(new SpringLayout());
		UtilDateModel model = new UtilDateModel();
		model.setDate(2017, 1, 1);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		this.fechaFin = new JDatePickerImpl(datePanel,  new DateComponentFormatter());
		panel.add(tit);
		panel.add(this.fechaFin);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new SpringLayout());
		JButton aceptar = new JButton ("Aceptar");
		aceptar.addActionListener(new ActionEditarFechaFin(t,this));
		JButton cancelar = new JButton ("Cancelar");
		cancelar.addActionListener(new ActionVolverVisTest(t));
		panelBotones.add(cancelar);
		panelBotones.add(aceptar);
		SpringUtilities.makeCompactGrid(panelBotones,1,2, 5,5,5,5);
		panel.add(panelBotones);
		
		SpringUtilities.makeCompactGrid(panel, 3, 1, 5,5,5,30);
		this.add(panel,BorderLayout.NORTH);
	}
	
	public LocalDate getFechaFin(){
		Date input = (Date)this.fechaFin.getModel().getValue();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date;	
	}
}
