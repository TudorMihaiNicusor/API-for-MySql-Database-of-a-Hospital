import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicController extends ControllerGeneric{
	private MedicModel m_model;
	private MedicView  m_view;

	/** Constructor */
	MedicController(ModelGeneric model, ViewGeneric view) {
	  m_model = (MedicModel) model;
	  m_view  = (MedicView) view;

	  m_view.addLogOutListener(new LogOutListener());
	  m_view.addProgramariListener(new programariListener());
	  m_view.addRapoarteListener(new RapoarteMediciListener());
	  m_view.addGestionareServiciiListener(new gestionareServiciiListener());
	  m_view.addSalariiListener(new salarii());
	  m_view.addOrareListener(new orare());
	  m_view.addConcediiListener(new concedii());
	  m_view.addOrareLunareListener(new orareLunare());
	}
	
	class programariListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.afisarePacientiProgramati();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class orare implements ActionListener {
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
	
	class RapoarteMediciListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereCompletareRapoarteMedici();
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
	
	class gestionareServiciiListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	m_model.deschidereGestionareServicii();
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
