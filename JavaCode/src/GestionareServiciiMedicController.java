import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

public class GestionareServiciiMedicController extends ControllerGeneric{
	private GestionareServiciiMedicModel m_model;
	private GestionareServiciiMedicView  m_view;

	/** Constructor */
	GestionareServiciiMedicController(ModelGeneric model, ViewGeneric view) {
		m_model = (GestionareServiciiMedicModel) model;
	  	m_view  = (GestionareServiciiMedicView) view;
	  	
	  	m_view.addBtnAdaugare(new adaugareListener());
	  	m_view.addBtnStergere(new stergereListener());
	}
	
	class adaugareListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        String serviciu = m_view.getServiciuInput();
	        String specialitate = m_view.getSpecialitateInput();
	        String competente = m_view.getCompetentaInput();
	        int pret = Integer.parseInt(m_view.getPretInput());
	        int durata = Integer.parseInt(m_view.getDurataInput());
	        m_model.adaugareServiciu(serviciu, specialitate, competente, pret, durata);
	        m_model.refreshTable();
	        }catch (NumberFormatException nfex) {
	    }
	        
	}
	}
	
	class stergereListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	int column = 0;
	        	int row = m_view.tabel.getSelectedRow();
	        	String serviciu = m_view.tabel.getModel().getValueAt(row, column).toString();
	        m_model.stergereServiciu(serviciu);
	        m_model.refreshTable();
	        }catch (NumberFormatException nfex) {
	    }
	        
	}
	}
	
}
