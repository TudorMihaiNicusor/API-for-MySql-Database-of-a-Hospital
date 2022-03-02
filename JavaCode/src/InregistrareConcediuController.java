import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InregistrareConcediuController extends ControllerGeneric{
	private InregistrareConcediuModel m_model;
	private InregistrareConcediuView  m_view;

	/** Constructor */
	InregistrareConcediuController(ModelGeneric model, ViewGeneric view) {
		m_model = (InregistrareConcediuModel) model;
	  	m_view  = (InregistrareConcediuView) view;

	  	m_view.addBtnInregistrare(new inregistrare());
	}
	
	class inregistrare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String nume = m_view.getNumeInput();
	        	String prenume = m_view.getPrenumeInput();
	        	String data_inceput = m_view.getDataInceput();
	        	String data_sfarsit = m_view.getDataSfarsit();
	        	m_model.stabilireConcediu(nume, prenume, data_inceput, data_sfarsit);
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
}
