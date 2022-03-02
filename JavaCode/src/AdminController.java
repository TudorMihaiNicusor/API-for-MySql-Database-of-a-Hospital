import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController extends ControllerGeneric{
	
	private AdminModel m_model;
	private AdminView  m_view;

	/** Constructor */
	AdminController(ModelGeneric model, ViewGeneric view) {
	  m_model = (AdminModel) model;
	  m_view  = (AdminView) view;

	  m_view.addLogOutListener(new LogOutListener());
	  m_view.addAddUserListener(new addUserListener());
	  m_view.addEditUsersListener(new editUserListener());
	}
	
	class addUserListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        
	        try {
	        	m_model.deschidereAddUser();
	        }
	        catch (NumberFormatException nfex) {
	        }
	    }
	}
	
	class editUserListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        
	        try {
	        	m_model.deschidereEditUser();
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
