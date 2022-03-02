import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugareUtilizatorController extends ControllerGeneric{
	private AdaugareUtilizatorModel m_model;
	private AdaugareUtilizatorView  m_view;

	/** Constructor */
	AdaugareUtilizatorController(ModelGeneric model, ViewGeneric view) {
		m_model = (AdaugareUtilizatorModel) model;
	  	m_view  = (AdaugareUtilizatorView) view;

	  	m_view.addBtnInregistrare(new inregistrare());
	}
	
	class inregistrare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	long CNP = Long.parseLong(m_view.getM_CNP());
	        	String nume = m_view.getM_numeAngajat();
	        	String prenume = m_view.getM_prenumeAngajat();
	        	String adresa = m_view.getM_adresa();
	        	String nr_telefon = m_view.getM_telefon();
	        	String email = m_view.getM_email();
	        	String IBAN = m_view.getM_IBAN();
	        	String nr_contract = m_view.getM_nr_contract();
	        	String data_angajarii = m_view.getM_data_angajarii();
	        	String tip = m_view.getM_tip();
	        	String functie = m_view.getM_functie();
	        	float salar_neg = Float.parseFloat(m_view.getM_salar_neg());
	        	int nr_ore = Integer.parseInt(m_view.getM_nr_ore());
	        	String parola = m_view.getM_parola();
	        	long CNP_modificator = Long.parseLong(PoliclinicaMVC.CNP);
	        	m_model.adaugareUtilizator(CNP, nume, prenume, adresa, nr_telefon, email, IBAN, nr_contract, data_angajarii,
	        			tip, functie, salar_neg, nr_ore, parola, CNP_modificator);
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
}
