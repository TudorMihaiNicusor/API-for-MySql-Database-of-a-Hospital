import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisareOrareLunareAngajatiController extends ControllerGeneric{
	private AfisareOrareLunareAngajatiModel m_model;
	private AfisareOrareLunareAngajatiView  m_view;

	/** Constructor */
	AfisareOrareLunareAngajatiController(ModelGeneric model, ViewGeneric view) {
	  m_model = (AfisareOrareLunareAngajatiModel) model;
	  m_view  = (AfisareOrareLunareAngajatiView) view;

	  m_view.addBtnAfisare(new afisare());
	}
	
	class afisare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String nume = m_view.getNumeInput();
	        	String prenume = m_view.getPrenumeInput();
	        	String policlinica = m_view.getPoliclinicaInput();
	        	int luna = Integer.parseInt(m_view.getLunaInput());
	        	int an = Integer.parseInt(m_view.getAnInput());
	        	m_model.orareLunareAngajat(nume, prenume, policlinica, luna, an);
	            
	        } catch (NumberFormatException nfex) {
	           
	        }
	    }
	}
}
