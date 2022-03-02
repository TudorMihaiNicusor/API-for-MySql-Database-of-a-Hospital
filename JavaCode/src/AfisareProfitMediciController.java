import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AfisareProfitMediciController extends ControllerGeneric{
	private AfisareProfitMediciModel m_model;
	private AfisareProfitMediciView  m_view;

	/** Constructor */
	AfisareProfitMediciController(ModelGeneric model, ViewGeneric view) {
	  m_model = (AfisareProfitMediciModel) model;
	  m_view  = (AfisareProfitMediciView) view;

	  m_view.addBtnCalculare(new calculare());
	}
	
	class calculare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String nume = m_view.getNumeInput();
	        	String prenume = m_view.getPrenumeInput();
	        	String policlinica = m_view.getPoliclinicaInput();
	        	int luna = Integer.parseInt(m_view.getLunaInput());
	        	int profit = 0;
	        	m_model.calculareProfitMedici(nume, prenume, policlinica, luna, profit);
	            
	        } catch (NumberFormatException nfex) {
	           
	        }
	    }
	}


}
