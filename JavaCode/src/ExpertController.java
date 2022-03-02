import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpertController extends ControllerGeneric{

	private ExpertModel m_model;
	private ExpertView  m_view;

	/** Constructor */
	ExpertController(ModelGeneric model, ViewGeneric view) {
		m_model = (ExpertModel) model;
	  	m_view  = (ExpertView) view;

	  	m_view.addLogOutListener(new LogOutListener());
	  	m_view.addVizSalariiListener(new vizSalariiListener());
	  	m_view.addConsultareOrareListener(new orare());
	  	m_view.addConsultareConcediiListener(new concedii());
	  	m_view.addProfitPoliclinicaListener(new profitPolicliniciListener());
	  	m_view.addProfitSpecialitatiListener(new profitSpecialitatiListener());
	  	m_view.addProfitMediciListener(new profitMediciListener());
	  	m_view.addConsultareOrareLunareListener(new orareLunare());
	}

	class vizSalariiListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereVizSalarii();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class orare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereOrare();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class orareLunare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereOrareLunare();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class concedii implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereConcedi();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class profitPolicliniciListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereProfitPoliclinici();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class profitSpecialitatiListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereProfitSpecialitati();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class profitMediciListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereProfitMedici();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}

	class LogOutListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.logOut();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
}
