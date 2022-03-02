import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsistentController extends ControllerGeneric{
	private AsistentModel m_model;
	private AsistentView  m_view;

	/** Constructor */
	AsistentController(ModelGeneric model, ViewGeneric view) {
		m_model = (AsistentModel) model;
		m_view  = (AsistentView) view;

	  	m_view.addLogOutListener(new LogOutListener());
	  	m_view.addRapoarteListener(new rapoarteListener());
	  	m_view.addSalariiListener(new salarii());
	  	m_view.addOrareSaptListener(new orareSapt());
	  	m_view.addConcediiListener(new concedii());
	  	m_view.addOrareLunarListener(new orareLunare());
	}
	
	class rapoarteListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereCompletareRapoarte();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class orareSapt implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereOrareSapt();
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
	
	class salarii implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereVizSalarii();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class concedii implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereConcedii();
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
