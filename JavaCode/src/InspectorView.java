import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InspectorView extends ViewGeneric {
	
    private JButton m_cautare = new JButton("Cautare date angajati");
    private JButton m_consultareSalarii = new JButton("Consultare salariu");
    private JButton m_consultareOrare = new JButton("Consultare orar saptamanal");
    private JButton m_consultareOrareLunare = new JButton("Consultare orar lunar");
    private JButton m_consultareConcedii = new JButton("Consultare concedii");
    private JButton m_inregistrareConcediu = new JButton("Inregistrare concediu");

    private JButton m_logOut = new JButton("Log Out");
    private InspectorModel m_model;

    /** Constructor */
    InspectorView(ModelGeneric model) {
        m_model = (InspectorModel) model;
  
        JPanel content = new JPanel();
        content.setLayout(null);
        JLabel label = new JLabel("Nume si Prenume: " + PoliclinicaMVC.numele + " " + PoliclinicaMVC.prenumele);
        label.setBounds(24, 37, 220, 14);
        content.add(label);
        JLabel label_1 = new JLabel("Functie: Inspector Resurse Umane");
        label_1.setBounds(24, 86, 220, 14);
        content.add(label_1);
        m_cautare.setBounds(254, 177, 212, 23);

        content.add(m_cautare);
        m_consultareSalarii.setBounds(254, 17, 212, 23);
        content.add(m_consultareSalarii);
        m_consultareOrare.setBounds(254, 57, 212, 23);
        content.add(m_consultareOrare);
        m_consultareOrareLunare.setBounds(254, 97, 212, 23);
        content.add(m_consultareOrareLunare);
        m_consultareConcedii.setBounds(254, 137, 212, 23);
        content.add(m_consultareConcedii);
        m_inregistrareConcediu.setBounds(254, 217, 212, 23);
        content.add(m_inregistrareConcediu);
        m_logOut.setBounds(20, 217, 101, 23);
        content.add(m_logOut);

        super.setContentPane(content);
        
        super.setTitle("Inspector");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        super.setResizable(true);
    }

    void addCautareListener(ActionListener mal) {
	m_cautare.addActionListener(mal);
}
    
    void addConsultareSalariiListener(ActionListener mal) {
    	m_consultareSalarii.addActionListener(mal);
    }

    void addConsultareOrareListener(ActionListener mal) {
	m_consultareOrare.addActionListener(mal);
}
    
    void addConsultareOrareLunareListener(ActionListener mal) {
    	m_consultareOrareLunare.addActionListener(mal);
    }

    void addConsultareConcediiListener(ActionListener mal) {
	m_consultareConcedii.addActionListener(mal);
}

    void addInregistrareConcediuListener(ActionListener mal) {
	m_inregistrareConcediu.addActionListener(mal);
}

    void addLogOutListener(ActionListener mal) {
	m_logOut.addActionListener(mal);
}

    void showError(String errMessage) {
  JOptionPane.showMessageDialog(this, errMessage);
}
}
