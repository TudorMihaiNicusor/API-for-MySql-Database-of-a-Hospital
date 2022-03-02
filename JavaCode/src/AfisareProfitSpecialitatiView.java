import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AfisareProfitSpecialitatiView extends ViewGeneric{

	 private JTextField m_specialitate = new JTextField(100);
	 private JTextField m_policlinica = new JTextField(100);
	 private JTextField m_luna = new JTextField(100);
	    
	 private JButton    m_calculareBtn = new JButton("Calculare");

	 private AfisareProfitSpecialitatiModel m_model;

	 /** Constructor */
	 AfisareProfitSpecialitatiView(ModelGeneric model) {

	 	m_model = (AfisareProfitSpecialitatiModel) model;
	 	m_specialitate.setBounds(97, 35, 359, 20);

	 	m_specialitate.setEditable(true);
	 	m_policlinica.setBounds(97, 90, 359, 20);
	 	m_policlinica.setEditable(true);
	 	m_luna.setBounds(97, 145, 359, 20);
	 	m_luna.setEditable(true);
	        
	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("Specialitate");
	 	label.setBounds(32, 38, 55, 14);
	 	content.add(label);
	 	content.add(m_specialitate);
	 	JLabel label_1 = new JLabel("Policlinica");
	 	label_1.setBounds(46, 93, 44, 14);
	 	content.add(label_1);
	 	content.add(m_policlinica);
	 	JLabel label_2 = new JLabel("Luna");
	 	label_2.setBounds(64, 148, 23, 14);
	 	content.add(label_2);
	 	content.add(m_luna);
	 	m_calculareBtn.setBounds(193, 200, 77, 23);
	        
	 	content.add(m_calculareBtn);

	 	super.setContentPane(content);
	 

	 	this.setTitle("Profit Specialitate");

	 	super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,300);
        super.setResizable(true);
	 }
	    
	 	String getSpecialitateInput() {
	        return m_specialitate.getText();
	    }
	    String getPoliclinicaInput() {
	        return m_policlinica.getText();
	    }
	    String getLunaInput() {
	        return m_luna.getText();
	    }
	    void addBtnCalculare(ActionListener mal) {
	    	m_calculareBtn.addActionListener(mal);
	    }
}
