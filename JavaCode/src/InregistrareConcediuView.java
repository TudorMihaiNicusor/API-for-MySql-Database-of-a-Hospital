import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InregistrareConcediuView extends ViewGeneric{

	 private JTextField m_numeAngajat = new JTextField(22);
	 private JTextField m_prenumeAngajat = new JTextField(22);
	 private JTextField m_data_inceput = new JTextField(10);
	 private JTextField m_data_sfarsit = new JTextField(10);
	 private JButton    m_inregistrareBtn = new JButton("Inregistreaza");

	 private InregistrareConcediuModel m_model;

	 /** Constructor */
	 InregistrareConcediuView(ModelGeneric model) {
	 	m_model = (InregistrareConcediuModel) model;
	 	m_numeAngajat.setBounds(64, 26, 355, 20);
	    	
	 	m_numeAngajat.setEditable(true);
	 	m_prenumeAngajat.setBounds(64, 72, 355, 20);
	 	m_prenumeAngajat.setEditable(true);
	 	m_data_inceput.setBounds(64, 118, 355, 20);
	 	m_data_inceput.setEditable(true);
	 	m_data_sfarsit.setBounds(64, 162, 355, 20);
	 	m_data_sfarsit.setEditable(true);

	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("Nume");
	 	label.setBounds(64, 11, 91, 14);
	 	content.add(label);
	 	content.add(m_numeAngajat);
	 	JLabel label_1 = new JLabel("Prenume");
	 	label_1.setBounds(64, 58, 91, 14);
	 	content.add(label_1);
	 	content.add(m_prenumeAngajat);
	 	JLabel label_2 = new JLabel("Data inceput");
	 	label_2.setBounds(64, 103, 110, 14);
	 	content.add(label_2);
	 	content.add(m_data_inceput);
	 	JLabel label_3 = new JLabel("Data sfarsit");
	 	label_3.setBounds(64, 147, 110, 14);
	 	content.add(label_3);
	 	content.add(m_data_sfarsit);
	 	m_inregistrareBtn.setBounds(187, 210, 110, 40);

	 	content.add(m_inregistrareBtn);
	        
	 	super.setContentPane(content);
		
        this.setTitle("Inregistrare Concediu");
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
	    
	    String getDataInceput() {
	        return m_data_inceput.getText();
	    }
	    
	    String getDataSfarsit() {
	        return m_data_sfarsit.getText();
	    }
	    
	    void addBtnInregistrare(ActionListener mal) {
	    	m_inregistrareBtn.addActionListener(mal);
	    }
}
