import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AfisareProfitPolicliniciController extends ControllerGeneric{
	private AfisareProfitPolicliniciModel m_model;
	private AfisareProfitPolicliniciView  m_view;

	/** Constructor */
	AfisareProfitPolicliniciController(ModelGeneric model, ViewGeneric view) {
	  m_model = (AfisareProfitPolicliniciModel) model;
	  m_view  = (AfisareProfitPolicliniciView) view;

	  m_view.addBtnCalculare(new calculare());
	}
	
	class calculare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String numePoliclinica = m_view.getNumePoliclinicaInput();
	        	int luna =Integer.parseInt(m_view.getLunaInput());
	        	int an = Integer.parseInt(m_view.getAnInput());
	        	int profit = 0;
	        	m_model.calculareProfitPoliclinici(numePoliclinica, luna, an, profit);
	        	
	        } catch (NumberFormatException nfex) {
	           
	        }
	    }
	}


}
