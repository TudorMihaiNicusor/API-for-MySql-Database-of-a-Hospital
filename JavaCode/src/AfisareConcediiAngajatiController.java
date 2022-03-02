import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisareConcediiAngajatiController extends ControllerGeneric{
	private AfisareConcediiAngajatiModel m_model;
	private AfisareConcediiAngajatiView  m_view;

	/** Constructor */
	AfisareConcediiAngajatiController(ModelGeneric model, ViewGeneric view) {
	  m_model = (AfisareConcediiAngajatiModel) model;
	  m_view  = (AfisareConcediiAngajatiView) view;

	  m_view.addBtnAfisare(new afisare());
	}
	
	class afisare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String nume = m_view.getNumeInput();
	        	String prenume = m_view.getPrenumeInput();
	        	m_model.ConcediiAngajat(nume, prenume);
	            
	        } catch (NumberFormatException nfex) {
	           
	        }
	    }
	}
}
