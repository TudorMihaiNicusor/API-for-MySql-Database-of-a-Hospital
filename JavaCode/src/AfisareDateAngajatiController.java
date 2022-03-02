import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AfisareDateAngajatiController extends ControllerGeneric{
	private AfisareDateAngajatiModel m_model;
	private AfisareDateAngajatiView  m_view;

	/** Constructor */
	AfisareDateAngajatiController(ModelGeneric model, ViewGeneric view) {
	  m_model = (AfisareDateAngajatiModel) model;
	  m_view  = (AfisareDateAngajatiView) view;

	  m_view.addBtnAfisare(new afisare());
	}
	
	class afisare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String nume = m_view.getNumeInput();
	        	String prenume = m_view.getPrenumeInput();
	        	String functie = m_view.getFunctieInput();
	        	m_model.dateAngajat(nume, prenume, functie);
	            
	        } catch (NumberFormatException nfex) {
	           
	        }
	    }
	}


}
