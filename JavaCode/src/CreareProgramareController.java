import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

public class CreareProgramareController extends ControllerGeneric{
	private CreareProgramareModel m_model;
	private CreareProgramareView  m_view;

	/** Constructor */
	CreareProgramareController(ModelGeneric model, ViewGeneric view) {
		m_model = (CreareProgramareModel) model;
	  	m_view  = (CreareProgramareView) view;
	  	
	  	m_view.addServiciiListener(new ServiciiListener());
	  	m_view.addBtnProgramare(new programare());
	}
	
	class ServiciiListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        Vector <String> result;
	        result = m_model.getMedici(m_view.getServiciuItem());
	        m_view.m_medic.removeAllItems();
	        for(String s:result){
	            m_view.m_medic.addItem(s);
	        }
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class programare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String nume = m_view.getNumeInput();
	        	String prenume = m_view.getPrenumeInput();
	        	String unitateMedicala = m_view.getUnitateMedicalaItem();
	        	String serviciu = m_view.getServiciuItem();
	        	String nume_prenume_medic = m_view.getMedicItem();
	        	String data = m_view.getDataInput();
	        	String ora = m_view.getOraInput();
	        	
	        	String arr[] = nume_prenume_medic.split(" ", 2);
	        	
	        	String nume_medic = arr[0];
	        	String prenume_medic = arr[1];
	        	
	        	int rezultat = 0;
	        	
	        	rezultat = m_model.programarePacient(nume, prenume, unitateMedicala, serviciu,
	        			nume_medic, prenume_medic, data, ora);
	        	
	        	if(rezultat == 1) {
	        		System.out.println("Intra");
	        		m_model.afisareBonFiscal(nume, prenume, serviciu, nume_medic, prenume_medic);
	        	}
	        		
	        	
	            
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
}
