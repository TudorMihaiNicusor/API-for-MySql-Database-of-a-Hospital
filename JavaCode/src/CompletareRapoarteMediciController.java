import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;


public class CompletareRapoarteMediciController extends ControllerGeneric{
	private CompletareRapoarteMediciModel m_model;
	private CompletareRapoarteMediciView  m_view;

	/** Constructor */
	CompletareRapoarteMediciController(ModelGeneric model, ViewGeneric view) {
		m_model = (CompletareRapoarteMediciModel) model;
	  	m_view  = (CompletareRapoarteMediciView) view;
	  	
		m_view.addBtnParafare(new parafareListener());
	}
	
	class parafareListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	int column = 0;
	        	int row = m_view.tabel.getSelectedRow();
	        	int raport = Integer.parseInt((String) m_view.tabel.getValueAt(row, column));
	        	m_model.parafareRaport(raport);
	        	m_model.refreshTable();
	        }catch (NumberFormatException nfex) {
	    }
	        
	}
	}
	
	
}
