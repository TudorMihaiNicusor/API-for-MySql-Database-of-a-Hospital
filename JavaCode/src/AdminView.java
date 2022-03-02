import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminView extends ViewGeneric{

	private JButton m_addUser = new JButton("Adaugare Utilizator");
	private JButton m_editUsers = new JButton("Gestionare Utilizatori");
	private JButton m_logOut = new JButton("Log Out");

	private AdminModel m_model;

	/** Constructor */
	AdminView(ModelGeneric model) {
		m_model = (AdminModel) model;

	  	JPanel content = new JPanel();
	  	content.setLayout(null);
	  	JLabel label = new JLabel("Nume si Prenume: " + PoliclinicaMVC.numele + " " + PoliclinicaMVC.prenumele);
	  	label.setBounds(15, 51, 256, 14);
	  	content.add(label);
	  	JLabel label_1 = new JLabel("Functie: " + PoliclinicaMVC.tip);
	  	label_1.setBounds(15, 108, 235, 14);
	  	content.add(label_1);
	  	m_addUser.setBounds(291, 71, 163, 23);
	  
	  	content.add(m_addUser);
	  	m_editUsers.setBounds(291, 137, 163, 23);
	  	content.add(m_editUsers);
	  	m_logOut.setBounds(10, 217, 89, 33);

	
	  	content.add(m_logOut);
	  
	  	super.setContentPane(content);
	  	//this.pack();
	  
	  	this.setTitle("Admin");
	  	super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        super.setResizable(true);
	}
	
	void addAddUserListener(ActionListener mal) {
		m_addUser.addActionListener(mal);
	}
	
	void addEditUsersListener(ActionListener mal) {
		m_editUsers.addActionListener(mal);
	}
	
	void addLogOutListener(ActionListener mal) {
		m_logOut.addActionListener(mal);
	}

	
}
