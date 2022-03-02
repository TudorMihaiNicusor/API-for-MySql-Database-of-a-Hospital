import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisareOrareAngajatiController extends ControllerGeneric{
	private AfisareOrareAngajatiModel m_model;
	private AfisareOrareAngajatiView  m_view;

	/** Constructor */
	AfisareOrareAngajatiController(ModelGeneric model, ViewGeneric view) {
	  m_model = (AfisareOrareAngajatiModel) model;
	  m_view  = (AfisareOrareAngajatiView) view;

	  m_view.addBtnAfisare(new afisare());
	}
	
	class afisare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String nume = m_view.getNumeInput();
	        	String prenume = m_view.getPrenumeInput();
	        	String policlinica = m_view.getPoliclinicaInput();
	        	m_model.orareAngajat(nume, prenume, policlinica);
	            
	        } catch (NumberFormatException nfex) {
	           
	        }
	    }
	}
}
