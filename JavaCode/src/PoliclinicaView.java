import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

///View-ul reprezinta interfeta propriu-zisa - ceea ce vede efectiv Utilizatorul
class PoliclinicaView extends ViewGeneric {
    //Declarama, prima data, componentele ce vor constitui fereastra actuala ce este vizibila Utilizatorului
    private JTextField m_userName = new JTextField(13);
    private JPasswordField m_userPassword = new JPasswordField(15); ///pentru a inlocui caracterele introduse cu stelute
    private JButton    m_loginBtn = new JButton("Login");
    private JButton    m_loginAdminBtn = new JButton("Login admin");
    private PoliclinicaModel m_model; ///trebuie declarat si un Model pentru a putea lega functiile din spate de componentele ferestrei

    /** Constructor */
    PoliclinicaView(ModelGeneric model) {
        ///In Constructorul View-ului trebuie sa ne intializam componentele si caracteristicile pe care dorim sa le aiba acestea
    	m_model = (PoliclinicaModel) model;
        m_userName.setBounds(128, 55, 227, 24);
        m_userName.setEditable(true);
        m_userPassword.setBounds(129, 115, 225, 28);
        m_userPassword.setEditable(true);
        
        JPanel content = new JPanel();
        content.setLayout(null);
        JLabel label = new JLabel("User Name");
        label.setBounds(128, 39, 76, 14);
        content.add(label); //Etichete pentru casetele de Text
        content.add(m_userName); ///Adaugarea unei casete de text
        JLabel label_1 = new JLabel("Password");
        label_1.setBounds(128, 100, 76, 14);
        content.add(label_1);
        content.add(m_userPassword);
        m_loginBtn.setBounds(128, 154, 76, 37);

        content.add(m_loginBtn);
        m_loginAdminBtn.setBounds(234, 154, 121, 37);
        content.add(m_loginAdminBtn);
        
        super.setContentPane(content);
        //super.pack();
        
        super.setTitle("Policlinica"); ///Titlul ferestrei
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ///Inchiderea ferestrei la apsarea butonului de close
        this.setSize(500,300);
        super.setResizable(true);
        
    }

    ///functie ce va extrage continutul din Textfieldul completat de Utilizator
    String getUserNameInput() {

        return m_userName.getText();
    }

    ///asemenea ca si Prima
    String getPasswordInput() {

        return m_userPassword.getText();
    }

    ///functie ce
    void addLoginListener(ActionListener mal) {

        m_loginBtn.addActionListener(mal);
    }
    
    void addLoginAdminListener(ActionListener mal) {
        m_loginAdminBtn.addActionListener(mal);
    }
    
    void showError(String errMessage) {

        JOptionPane.showMessageDialog(this, errMessage);
    }
}
