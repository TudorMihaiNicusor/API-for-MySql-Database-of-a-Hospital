import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AfisareSalariiAngajatiView extends ViewGeneric{

	 private JTextField m_numeAngajat = new JTextField(100);
	 private JTextField m_prenumeAngajat = new JTextField(100);
	 private JTextField m_luna = new JTextField(100);
	 private JButton    m_cautareBtn = new JButton("Cautare");

	 private AfisareSalariiAngajatiModel m_model;

	 /** Constructor */
	 AfisareSalariiAngajatiView(ModelGeneric model) {
	 	m_model = (AfisareSalariiAngajatiModel) model;
	    	
	 	if(!PoliclinicaMVC.functie.equals("expert financiar")) {
	 		m_numeAngajat.setText(PoliclinicaMVC.numele);
	 		m_prenumeAngajat.setText(PoliclinicaMVC.prenumele);
	 		m_numeAngajat.setEnabled(false);
	 		m_prenumeAngajat.setEnabled(false);
	 	} else {
	 		m_numeAngajat.setEditable(true);
		 	m_prenumeAngajat.setEditable(true);
		 	m_luna.setEditable(true);
	 	}
	 

	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("Nume");
	 	label.setBounds(67, 21, 90, 14);
	 	content.add(label);
	 	m_numeAngajat.setBounds(67, 35, 355, 20);
	 	content.add(m_numeAngajat);
	 	JLabel label_1 = new JLabel("Prenume");
	 	label_1.setBounds(67, 75, 90, 14);
	 	content.add(label_1);
	 	m_prenumeAngajat.setBounds(67, 90, 355, 20);
	 	content.add(m_prenumeAngajat);
	 	JLabel label_2 = new JLabel("Luna");
	 	label_2.setBounds(67, 130, 76, 14);
	 	content.add(label_2);
	 	m_luna.setBounds(67, 145, 355, 20);
	 	content.add(m_luna);
	 	m_cautareBtn.setBounds(204, 200, 76, 29);
	        
	 	content.add(m_cautareBtn);
	        
	 	super.setContentPane(content);
		
        this.setTitle("Afisare salarii angajati");
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
	    
	 String getLunaInput() {
	        return m_luna.getText();
	    }

	 void addBtnAfisare(ActionListener mal) {
	    	m_cautareBtn.addActionListener(mal);
	    }
}
