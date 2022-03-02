import java.awt.event.*;

///Prin Controller manipulam tot ceea ce primi de la Utilizator si transmitem Modelului pentru a preluca aceste informatii primite
///reactualizand constant ceea ce vede si ceea ce poate face Utilizatorul
public class PoliclinicaController extends ControllerGeneric{
    ///Declararea View-ului si a Modelului
    private PoliclinicaModel m_model;
    private PoliclinicaView  m_view;

    /** Constructor */
    PoliclinicaController(ModelGeneric model, ViewGeneric view) {
        //In acest constructor ne initializam View-ul si Modelul intre care va face legatura Controllerul
        m_model = (PoliclinicaModel) model;
        m_view  = (PoliclinicaView) view;

        ///Initializarea tuturor Listenerilor
        m_view.addLoginListener(new LoginListener());
        m_view.addLoginAdminListener(new LoginAdminListener());
    }

    ///Pentru fiecare Listener trebuie creata o clasa care sa dezvolte metoda de actionPerfmormed
    ///Metoda in care legam ceea ce ne ofera utilizatorul prin View de ceea ce trebuie sa se execute in Model si
    ///sa se intample aproape simultan actualizarile pe intreaga aplicatie
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userName = "";
            String password = "";
            try {
                userName = m_view.getUserNameInput();
                password = m_view.getPasswordInput();
                
                m_model.login(userName, password );
                
            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userName + "'" + password);
            }
        }
    }
    
    class LoginAdminListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userName = "";
            String password = "";
            try {
                userName = m_view.getUserNameInput();
                password = m_view.getPasswordInput();
                
                m_model.loginAdmin(userName, password );
                
            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userName + "'" + password);
            }
        }
    }
}
