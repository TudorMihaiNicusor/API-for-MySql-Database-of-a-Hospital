import java.awt.event.*;

public class InspectorController extends ControllerGeneric{

    private InspectorModel m_model;
    private InspectorView  m_view;

    /** Constructor */
    InspectorController(ModelGeneric model, ViewGeneric view) {
        m_model = (InspectorModel) model;
        m_view  = (InspectorView) view;

        m_view.addLogOutListener(new LogOutListener());
        m_view.addCautareListener(new cautareListener());
        m_view.addConsultareSalariiListener(new salariiListener());
        m_view.addConsultareOrareListener(new orareAngajatiListener());
        m_view.addConsultareConcediiListener(new concediiListener());
        m_view.addInregistrareConcediuListener(new inregistrareConcediuListener());
        m_view.addConsultareOrareLunareListener(new orareLunare());
    }

    class cautareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
        	    m_model.afisareDateAngajati();
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
    
    class salariiListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m_model.deschidereSalarii();
            }
            catch (NumberFormatException nfex) {
            }
        }
    }

    class orareAngajatiListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m_model.deschidereOrareAngajati();
            }
            catch (NumberFormatException nfex) {
            }
        }
    }

    class concediiListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
        	    m_model.deschidereConcediiAngajati();
            }
            catch (NumberFormatException nfex) {
            }
        }
    }

    class inregistrareConcediuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m_model.deschidereInregistrareConcediu();
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
