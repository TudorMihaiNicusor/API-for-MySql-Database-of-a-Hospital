import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AfisareConcediiAngajatiView extends ViewGeneric{

	 private JTextField m_numeAngajat = new JTextField(20);
	 private JTextField m_prenumeAngajat = new JTextField(20);
	    
	 private JButton    m_cautareBtn = new JButton("Cautare");

	 private AfisareConcediiAngajatiModel m_model;

	 /** Constructor */
	 AfisareConcediiAngajatiView(ModelGeneric model) {
	 	m_model = (AfisareConcediiAngajatiModel) model;
	 	
	 	if(!PoliclinicaMVC.functie.equals("expert financiar") && !PoliclinicaMVC.functie.equals("inspector resurse umane")) {
	 		m_numeAngajat.setText(PoliclinicaMVC.numele);
	 		m_prenumeAngajat.setText(PoliclinicaMVC.prenumele);
	 		m_numeAngajat.setEnabled(false);
	 		m_prenumeAngajat.setEnabled(false);
	 	} else {
	 		m_numeAngajat.setEnabled(true);
	 		m_prenumeAngajat.setEnabled(true);
		 	m_numeAngajat.setEditable(true);
		 	m_prenumeAngajat.setEditable(true);
	 	}
	 	m_numeAngajat.setBounds(64, 47, 355, 20);

	 	m_numeAngajat.setEditable(true);
	 	m_prenumeAngajat.setBounds(64, 114, 355, 20);
	 	m_prenumeAngajat.setEditable(true);

	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("Nume");
	 	label.setBounds(64, 33, 106, 14);
	 	content.add(label);
	 	content.add(m_numeAngajat);
	 	JLabel label_1 = new JLabel("Prenume");
	 	label_1.setBounds(64, 100, 106, 14);
	 	content.add(label_1);
	 	content.add(m_prenumeAngajat);
	 	m_cautareBtn.setBounds(199, 181, 86, 32);
	        
	 	content.add(m_cautareBtn);
	 	
	 	super.setContentPane(content);
		
        this.setTitle("Afisare concedii angajati");
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

	    void addBtnAfisare(ActionListener mal) {
	    	m_cautareBtn.addActionListener(mal);
	    }
}
