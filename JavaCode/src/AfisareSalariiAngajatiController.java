import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisareSalariiAngajatiController extends ControllerGeneric{
	private AfisareSalariiAngajatiModel m_model;
	private AfisareSalariiAngajatiView  m_view;

	/** Constructor */
	AfisareSalariiAngajatiController(ModelGeneric model, ViewGeneric view) {

		m_model = (AfisareSalariiAngajatiModel) model;
	  	m_view  = (AfisareSalariiAngajatiView) view;

	  	m_view.addBtnAfisare(new afisare());
	}
	
	class afisare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String nume = m_view.getNumeInput();
	        	String prenume = m_view.getPrenumeInput();
	        	int luna = Integer.parseInt(m_view.getLunaInput());
	        	int salariu = 0;
	        	m_model.salariiAngajat(nume, prenume, luna, salariu);
	            
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}

}
