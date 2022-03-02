import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionerController extends ControllerGeneric{
	
	private ReceptionerModel m_model;
	private ReceptionerView  m_view;

	/** Constructor */
	ReceptionerController(ModelGeneric model, ViewGeneric view) {
	  m_model = (ReceptionerModel) model;
	  m_view  = (ReceptionerView) view;

	  m_view.addLogOutListener(new LogOutListener());
	  m_view.addCreareProgramareListener(new CreareProgramare());
	  m_view.addSalariiListener(new salarii());
	  m_view.addOrareSaptListener(new orarSapt());
	  m_view.addConcediiListener(new concedii());
	  m_view.addOrareLunarListener(new orarLunar());
	}
	
	class CreareProgramare implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        
	        try {
	        	m_model.deschidereCreareProgramare();
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
	
	
	class orarSapt implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        
	        try {
	        	m_model.deschidereOrareSapt();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class orarLunar implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        
	        try {
	        	m_model.deschidereOrareLunar();
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
