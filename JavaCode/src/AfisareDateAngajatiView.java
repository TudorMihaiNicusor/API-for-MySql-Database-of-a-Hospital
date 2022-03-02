import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AfisareDateAngajatiView extends ViewGeneric{

	 private JTextField m_numeAngajat = new JTextField(100);
	 private JTextField m_prenumeAngajat = new JTextField(100);
	 private JTextField m_functieAngajat = new JTextField(100);
	    
	 private JButton    m_cautareBtn = new JButton("Cautare");

	 private AfisareDateAngajatiModel m_model;

	 /** Constructor */
	 AfisareDateAngajatiView(ModelGeneric model) {
	 	m_model = (AfisareDateAngajatiModel) model; ///datorita Clasei tata de ModelGeneric putem face simplu Casting la Modelul actual folosit
	 	m_numeAngajat.setBounds(64, 36, 355, 20);
	    
	 	
	 	m_numeAngajat.setEditable(true);
	 	m_prenumeAngajat.setBounds(64, 92, 355, 20);
	 	m_prenumeAngajat.setEditable(true);
	 	m_functieAngajat.setBounds(64, 148, 355, 20);
	 	m_functieAngajat.setEditable(true);
	        
	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("Nume");
	 	label.setBounds(64, 24, 104, 14);
	 	content.add(label);
	 	content.add(m_numeAngajat);
	 	JLabel label_1 = new JLabel("Prenume");
	 	label_1.setBounds(64, 79, 104, 14);
	 	content.add(label_1);
	 	content.add(m_prenumeAngajat);
	 	JLabel label_2 = new JLabel("Functie");
	 	label_2.setBounds(64, 135, 110, 14);
	 	content.add(label_2);
	 	content.add(m_functieAngajat);
	 	m_cautareBtn.setBounds(199, 200, 85, 35);
	        
	 	content.add(m_cautareBtn);

	 	super.setContentPane(content);
		
        super.setTitle("Cautare date angajati");
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
	    
	    String getFunctieInput() {

	 	return m_functieAngajat.getText();
	    }

	    void addBtnAfisare(ActionListener mal) {
	 		m_cautareBtn.addActionListener(mal);
	    }
}
