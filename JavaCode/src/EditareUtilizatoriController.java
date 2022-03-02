import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

public class EditareUtilizatoriController extends ControllerGeneric{
	private EditareUtilizatoriModel m_model;
	private EditareUtilizatoriView  m_view;

	/** Constructor */
	EditareUtilizatoriController(ModelGeneric model, ViewGeneric view) {
		m_model = (EditareUtilizatoriModel) model;
	  	m_view  = (EditareUtilizatoriView) view;
	  	
	  	m_view.addBtnStergere(new stergereListener());
	}
	
	
	class stergereListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	int column = 1;
	        	int row = m_view.tabel.getSelectedRow();
	        	String nume = m_view.tabel.getModel().getValueAt(row, column).toString();
	        	column = 2;
	        	String prenume = m_view.tabel.getModel().getValueAt(row, column).toString();
	        m_model.stergereServiciu(nume, prenume);
	        m_model.refreshTable();
	        }catch (NumberFormatException nfex) {
	    }
	        
	}
	}
	
}
