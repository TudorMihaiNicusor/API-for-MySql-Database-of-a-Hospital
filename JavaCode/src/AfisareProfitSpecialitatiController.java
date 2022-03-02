import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisareProfitSpecialitatiController extends ControllerGeneric{
	private AfisareProfitSpecialitatiModel m_model;
	private AfisareProfitSpecialitatiView  m_view;

	/** Constructor */
	AfisareProfitSpecialitatiController(ModelGeneric model, ViewGeneric view) {
	  m_model = (AfisareProfitSpecialitatiModel) model;
	  m_view  = (AfisareProfitSpecialitatiView) view;

	  m_view.addBtnCalculare(new calculare());
	}

	class calculare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String specialitate = m_view.getSpecialitateInput();
	        	String policlinica = m_view.getPoliclinicaInput();
	        	int luna = Integer.parseInt(m_view.getLunaInput());
	        	int profit = 0;
	        	m_model.calculareProfitSpecialitate(specialitate, policlinica, luna, profit);
	            
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}


}
