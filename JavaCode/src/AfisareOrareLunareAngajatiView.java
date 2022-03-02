import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AfisareOrareLunareAngajatiView extends ViewGeneric{

	 private JTextField m_numeAngajat = new JTextField(20);
	 private JTextField m_prenumeAngajat = new JTextField(20);
	 private JTextField m_policlinica = new JTextField(20);
	 private JTextField m_luna = new JTextField(20);
	 private JTextField m_an = new JTextField(20);
	    
	 private JButton    m_cautareBtn = new JButton("Cautare");

	 private AfisareOrareLunareAngajatiModel m_model;

	 /** Constructor */
	 AfisareOrareLunareAngajatiView(ModelGeneric model) {
	 	m_model = (AfisareOrareLunareAngajatiModel) model;
	 	
	 	if(( !PoliclinicaMVC.functie.equals("expert financiar")) && (!PoliclinicaMVC.functie.equals("inspector resurse umane"))) {
	 		m_numeAngajat.setText(PoliclinicaMVC.numele);
	 		m_prenumeAngajat.setText(PoliclinicaMVC.prenumele);
	 		m_numeAngajat.setEnabled(false);
	 		m_prenumeAngajat.setEnabled(false);
	 	} else {
	 		m_numeAngajat.setEnabled(true);
	 		m_prenumeAngajat.setEnabled(true);
		 	m_numeAngajat.setEditable(true);
		 	m_prenumeAngajat.setEditable(true);
		 	m_policlinica.setEditable(true);
	 	}
	 	

	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("Nume");
	 	label.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label.setBounds(33, 22, 60, 14);
	 	content.add(label);
	 	m_numeAngajat.setBounds(103, 19, 355, 20);
	 	content.add(m_numeAngajat);
	 	JLabel label_1 = new JLabel("Prenume");
	 	label_1.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_1.setBounds(33, 61, 60, 14);
	 	content.add(label_1);
	 	m_prenumeAngajat.setBounds(103, 58, 355, 20);
	 	content.add(m_prenumeAngajat);
	 	JLabel label_2 = new JLabel("Nume policlinica");
	 	label_2.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_2.setBounds(0, 100, 93, 14);
	 	content.add(label_2);
	 	m_policlinica.setBounds(103, 97, 355, 20);
	 	content.add(m_policlinica);
		JLabel label_3 = new JLabel("Luna");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(10, 139, 83, 14);
		content.add(label_3);
	 	m_luna.setBounds(103, 136, 355, 20);
	 	content.add(m_luna);
		JLabel label_4 = new JLabel("An");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(10, 178, 83, 14);
		content.add(label_4);
	 	m_an.setBounds(103, 175, 355, 20);
	 	content.add(m_an);
	 	m_cautareBtn.setBounds(200, 215, 83, 35);
	        
	 	content.add(m_cautareBtn);

	 	super.setContentPane(content);
		
        this.setTitle("Afisare orar lunar angajati");
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

	    String getLunaInput() {
	        return m_luna.getText();
	    }
	    String getAnInput() {
	        return m_an.getText();
	    }
	    void addBtnAfisare(ActionListener mal) {
	    	m_cautareBtn.addActionListener(mal);
	    }
}
