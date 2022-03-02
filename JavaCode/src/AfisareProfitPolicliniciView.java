import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AfisareProfitPolicliniciView extends ViewGeneric{

	 private JTextField m_numePoliclinica = new JTextField(100);
	 private JTextField m_luna = new JTextField(100);
	 private JTextField m_an = new JTextField(100);

	 private JButton    m_calculareBtn = new JButton("Calculare");

	 private AfisareProfitPolicliniciModel m_model;

	    /** Constructor */
	    AfisareProfitPolicliniciView(ModelGeneric model) {
	    	m_model = (AfisareProfitPolicliniciModel) model;
	    	m_numePoliclinica.setBounds(117, 35, 314, 20);
	    	
	    	m_numePoliclinica.setEditable(true);
	    	m_an.setBounds(117, 145, 314, 20);
	    	m_an.setEditable(true);
	        m_luna.setBounds(117, 90, 314, 20);
	        m_luna.setEditable(true);
	        
	        JPanel content = new JPanel();
	        content.setLayout(null);
	        JLabel label = new JLabel("Nume Policlinica");
	        label.setBounds(33, 38, 74, 14);
	        content.add(label);
	        content.add(m_numePoliclinica);
	        JLabel label_1 = new JLabel("Luna");
	        label_1.setBounds(84, 93, 23, 14);
	        content.add(label_1);
	        content.add(m_luna);
	        JLabel label_2 = new JLabel("An");
	        label_2.setBounds(94, 148, 13, 14);
	        content.add(label_2);
	        content.add(m_an);
	        m_calculareBtn.setBounds(205, 200, 77, 23);
	        

	        content.add(m_calculareBtn);
	        
	        super.setContentPane(content);
	    
	        
	        this.setTitle("Profit Policlinici");
	        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setSize(500,300);
	        super.setResizable(true);
	    }
	    
	    String getNumePoliclinicaInput() {
	        return m_numePoliclinica.getText();
	    }
	    
	    String getLunaInput() {
	        return m_luna.getText();
	    }
	    
	    String getAnInput() {
	        return m_an.getText();
	    }
	    
	    void addBtnCalculare(ActionListener mal) {
	    	m_calculareBtn.addActionListener(mal);
	    }
}
