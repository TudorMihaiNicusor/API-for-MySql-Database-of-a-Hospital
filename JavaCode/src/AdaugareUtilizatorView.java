import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdaugareUtilizatorView extends ViewGeneric{

     private JTextField m_CNP = new JTextField(22);
	 private JTextField m_numeAngajat = new JTextField(22);
	 private JTextField m_prenumeAngajat = new JTextField(22);
	 private JTextField m_adresa = new JTextField(10);
	 private JTextField m_telefon = new JTextField(10);
	 private JTextField m_email = new JTextField(10);
	 private JTextField m_IBAN = new JTextField(10);
	 private JTextField m_nr_contract = new JTextField(10);
	 private JTextField m_data_angajarii = new JTextField(10);
	 private JTextField m_tip = new JTextField(10);
	 private JTextField m_functie = new JTextField(10);
	 private JTextField m_salar_neg = new JTextField(10);
	 private JTextField m_nr_ore = new JTextField(10);
	 private JTextField m_parola = new JTextField(10);

	 private JButton    m_inregistrareBtn = new JButton("Inregistreaza");

	 private AdaugareUtilizatorModel m_model;

	 /** Constructor */
	 AdaugareUtilizatorView(ModelGeneric model) {
	 	m_model = (AdaugareUtilizatorModel) model;
	    
	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("CNP");
	 	label.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label.setBounds(28, 26, 60, 14);
	 	content.add(label);
	 	m_CNP.setBounds(98, 23, 182, 20);
	 	content.add(m_CNP);
	 	JLabel label_1 = new JLabel("Nume");
	 	label_1.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_1.setBounds(28, 69, 60, 14);
	 	content.add(label_1);
	 	m_numeAngajat.setBounds(98, 66, 182, 20);
	 	content.add(m_numeAngajat);
	 	JLabel label_2 = new JLabel("Prenume");
	 	label_2.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_2.setBounds(10, 112, 78, 14);
	 	content.add(label_2);
	 	m_prenumeAngajat.setBounds(98, 109, 182, 20);
	 	content.add(m_prenumeAngajat);
	 	JLabel label_3 = new JLabel("Adresa");
	 	label_3.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_3.setBounds(10, 155, 78, 14);
	 	content.add(label_3);
	 	m_adresa.setBounds(98, 152, 182, 20);
	 	content.add(m_adresa);
	 	JLabel label_4 = new JLabel("Email");
	 	label_4.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_4.setBounds(10, 198, 78, 14);
	 	content.add(label_4);
	 	m_email.setBounds(98, 195, 182, 20);
	 	content.add(m_email);
	 	JLabel label_5 = new JLabel("Telefon");
	 	label_5.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_5.setBounds(10, 241, 78, 14);
	 	content.add(label_5);
	 	m_telefon.setBounds(98, 238, 182, 20);
	 	content.add(m_telefon);
	 	JLabel label_6 = new JLabel("IBAN");
	 	label_6.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_6.setBounds(10, 284, 78, 14);
	 	content.add(label_6);
	 	m_IBAN.setBounds(101, 281, 182, 20);
	 	content.add(m_IBAN);
	 	JLabel label_7 = new JLabel("Nr. Contract");
	 	label_7.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_7.setBounds(320, 26, 116, 14);
	 	content.add(label_7);
	 	m_nr_contract.setBounds(446, 23, 182, 20);
	 	content.add(m_nr_contract);
	 	JLabel label_8 = new JLabel("Data angajarii");
	 	label_8.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_8.setBounds(320, 69, 116, 14);
	 	content.add(label_8);
	 	m_data_angajarii.setBounds(446, 66, 182, 20);
	 	content.add(m_data_angajarii);
	 	JLabel label_9 = new JLabel("Tip");
	 	label_9.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_9.setBounds(360, 112, 76, 14);
	 	content.add(label_9);
	 	m_tip.setBounds(446, 109, 182, 20);
	 	content.add(m_tip);
	 	JLabel label_10 = new JLabel("Functie");
	 	label_10.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_10.setBounds(360, 155, 76, 14);
	 	content.add(label_10);
	 	m_functie.setBounds(446, 152, 182, 20);
	 	content.add(m_functie);
	 	JLabel label_11 = new JLabel("Salariu negociat");
	 	label_11.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_11.setBounds(330, 198, 106, 14);
	 	content.add(label_11);
	 	m_salar_neg.setBounds(446, 195, 182, 20);
	 	content.add(m_salar_neg);
	 	JLabel label_12 = new JLabel("Nr. ore");
	 	label_12.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_12.setBounds(320, 241, 116, 14);
	 	content.add(label_12);
	 	m_nr_ore.setBounds(446, 238, 182, 20);
	 	content.add(m_nr_ore);
	 	JLabel label_13 = new JLabel("Parola");
	 	label_13.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_13.setBounds(330, 284, 106, 14);
	 	content.add(label_13);
	 	m_parola.setBounds(446, 281, 182, 20);
	 	content.add(m_parola);
	 	m_inregistrareBtn.setBounds(283, 360, 131, 32);

	 	content.add(m_inregistrareBtn);
	        
	 	super.setContentPane(content);
	 	//this.pack();

	 	this.setTitle("Adaugare Utilizator");

	 	super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(713,469);
        super.setResizable(true);
	    }

	public String getM_CNP() {
		return m_CNP.getText();
	}

	public String getM_numeAngajat() {
		return m_numeAngajat.getText();
	}

	public String getM_prenumeAngajat() {
		return m_prenumeAngajat.getText();
	}

	public String getM_adresa() {
		return m_adresa.getText();
	}

	public String getM_email() {
		return m_email.getText();
	}
	
	public String getM_telefon() {
		return m_telefon.getText();
	}

	public String getM_IBAN() {
		return m_IBAN.getText();
	}

	public String getM_nr_contract() {
		return m_nr_contract.getText();
	}

	public String getM_data_angajarii() {
		return m_data_angajarii.getText();
	}

	public String getM_tip() {
		return m_tip.getText();
	}

	public String getM_functie() {
		return m_functie.getText();
	}

	public String getM_salar_neg() {
		return m_salar_neg.getText();
	}

	public String getM_nr_ore() {
		return m_nr_ore.getText();
	}

	public String getM_parola() {
		return m_parola.getText();
	}

	void addBtnInregistrare(ActionListener mal) {
		m_inregistrareBtn.addActionListener(mal);
    }
	    
	    
}
