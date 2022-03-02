import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AfisareOrareAngajatiView extends ViewGeneric{

	 private JTextField m_numeAngajat = new JTextField(100);
	 private JTextField m_prenumeAngajat = new JTextField(100);
	 private JTextField m_policlinica = new JTextField(100);
	    
	 private JButton    m_cautareBtn = new JButton("Cautare");

	 private AfisareOrareAngajatiModel m_model;

	 /** Constructor */
	 AfisareOrareAngajatiView(ModelGeneric model) {
	 	m_model = (AfisareOrareAngajatiModel) model;
	 	
	 	if(!PoliclinicaMVC.functie.equals("expert financiar") && !PoliclinicaMVC.functie.equals("inspector resurse umane")) {
	 		m_numeAngajat.setText(PoliclinicaMVC.numele);
	 		m_prenumeAngajat.setText(PoliclinicaMVC.prenumele);
	 		m_numeAngajat.setEnabled(false);
	 		m_prenumeAngajat.setEnabled(false);
	 	} else {
	 		m_numeAngajat.setEditable(true);
		 	m_prenumeAngajat.setEditable(true);
		 	m_policlinica.setEditable(true);
	 	}
	 	

	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("Nume");
	 	label.setBounds(64, 21, 140, 14);
	 	content.add(label);
	 	m_numeAngajat.setBounds(64, 33, 355, 20);
	 	content.add(m_numeAngajat);
	 	JLabel label_1 = new JLabel("Prenume");
	 	label_1.setBounds(64, 74, 140, 14);
	 	content.add(label_1);
	 	m_prenumeAngajat.setBounds(64, 88, 355, 20);
	 	content.add(m_prenumeAngajat);
	 	JLabel label_2 = new JLabel("Nume policlinica");
	 	label_2.setBounds(64, 129, 140, 14);
	 	content.add(label_2);
	 	m_policlinica.setBounds(64, 143, 355, 20);
	 	content.add(m_policlinica);
	 	m_cautareBtn.setBounds(200, 201, 84, 33);
	        
	 	content.add(m_cautareBtn);

	 	super.setContentPane(content);
		
        this.setTitle("Afisare orar saptamanal angajati");
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,300);
        super.setResizable(true);
	    }
	    
	    String getNumeInput() {
	        return m_numeAngajat.getText();
	    }

	    String getPrenumeInput() {
	        return m_prenumeAngajat.getText();
	    }
	    
	    String getPoliclinicaInput() {
	        return m_policlinica.getText();
	    }

	    void addBtnAfisare(ActionListener mal) {
	    	m_cautareBtn.addActionListener(mal);
	    }
}
