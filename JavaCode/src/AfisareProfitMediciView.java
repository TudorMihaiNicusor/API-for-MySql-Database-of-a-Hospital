import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AfisareProfitMediciView extends ViewGeneric{

	 private JTextField m_nume = new JTextField(100);
	 private JTextField m_prenume = new JTextField(100);
	 private JTextField m_policlinica = new JTextField(100);
	 private JTextField m_luna = new JTextField(100);

	 private JButton    m_calculareBtn = new JButton("Calculare");

	 private AfisareProfitMediciModel m_model;

	    /** Constructor */
	    AfisareProfitMediciView(ModelGeneric model) {
	    	m_model = (AfisareProfitMediciModel) model;
	    	m_nume.setBounds(64, 26, 355, 20);
	    	
	    	m_nume.setEditable(true);
	    	m_prenume.setBounds(64, 72, 355, 20);
	    	m_prenume.setEditable(true);
	    	m_policlinica.setBounds(64, 118, 355, 20);
	    	m_policlinica.setEditable(true);
	        m_luna.setBounds(64, 164, 355, 20);
	        m_luna.setEditable(true);
	        
	        JPanel content = new JPanel();
	        content.setLayout(null);
	        JLabel label = new JLabel("Nume");
	        label.setBounds(66, 11, 114, 14);
	        content.add(label);
	        content.add(m_nume);
	        JLabel label_1 = new JLabel("Prenume");
	        label_1.setBounds(66, 57, 114, 14);
	        content.add(label_1);
	        content.add(m_prenume);
	        JLabel label_2 = new JLabel("Policlinica");
	        label_2.setBounds(64, 103, 116, 14);
	        content.add(label_2);
	        content.add(m_policlinica);
	        JLabel label_3 = new JLabel("Luna");
	        label_3.setBounds(66, 149, 114, 14);
	        content.add(label_3);
	        content.add(m_luna);
	        m_calculareBtn.setBounds(198, 210, 88, 40);

	        content.add(m_calculareBtn);
	        
	        super.setContentPane(content);
	        
	        this.setTitle("Profit Medici");
	        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setSize(500,300);
	        super.setResizable(true);
	    }
	    
	    String getNumeInput() {
	        return m_nume.getText();
	    }
	    
	    String getPrenumeInput() {
	        return m_prenume.getText();
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
