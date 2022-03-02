import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

public class CompletareRapoarteController extends ControllerGeneric{
	private CompletareRapoarteModel m_model;
	private CompletareRapoarteView  m_view;

	/** Constructor */
	CompletareRapoarteController(ModelGeneric model, ViewGeneric view) {
		m_model = (CompletareRapoarteModel) model;
	  	m_view  = (CompletareRapoarteView) view;
	  	
	}
	
	class adaugareListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	       
	        }catch (NumberFormatException nfex) {
	    }
	        
	}
	}
	
	
}
