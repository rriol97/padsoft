package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.GUI.paneles.profesor.test.PanelEditarPregSiNo;
import aplicacion.clases.elemento.test.SiNo;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarPreguntaSiNo implements ActionListener {
	private SiNo preg;
	private Test t;
	private PanelEditarPregSiNo p;

	public ActionEditarPreguntaSiNo(SiNo preg, PanelEditarPregSiNo panelEditarPregSiNo, Test t) {
		this.preg = preg;
		this.t = t;
		this.p = panelEditarPregSiNo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.p.getEnunciado().equals("")){
			JOptionPane.showMessageDialog(this.p,"Introduzca el enunciado");
		} else if (this.p.getValor()==null){
			JOptionPane.showMessageDialog(this.p,"Introduzca el valor de la pregunta");
		} else if (this.p.getPenalizacion()==null){
			JOptionPane.showMessageDialog(this.p,"Introduzca el la penalizacion por fallo");
		} else{
			Controlador.getInstance().editarPregSiNo(this.preg,this.p.getEnunciado(),this.p.getValor(),this.p.getPenalizacion(),this.p.getRespuesta());
			Frame.getInstance().cambiarPanel(new PanelAnadirPregunta(t), 1);
		}
	}

}