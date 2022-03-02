import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExpertView extends ViewGeneric{

	private JButton m_salarii = new JButton("Vizualizare salarii");
    private JButton m_consultareOrareLunare = new JButton("Consultare orar lunar");
	private JButton m_consultareOrare = new JButton("Consultare orar saptamanal");
	private JButton m_consultareConcedii = new JButton("Consultare concedii");
	private JButton m_profitPoliclinica = new JButton("Vizualizare profit policlinica");
	private JButton m_profitMedici = new JButton("Vizualizare profit medici");
	private JButton m_profitSpecialitati = new JButton("Vizualizare profit specialitati");
	private JButton m_logOut = new JButton("Log Out");

	private ExpertModel m_model;

	/** Constructor */
	ExpertView(ModelGeneric model) {

		m_model = (ExpertModel) model;

		JPanel content = new JPanel();
	  	content.setLayout(null);
	  	JLabel label = new JLabel("Nume si Prenume: " + PoliclinicaMVC.numele + " " + PoliclinicaMVC.prenumele);
	  	label.setBounds(21, 25, 234, 14);
	  	content.add(label);
	  	JLabel label_1 = new JLabel("Functie: Expert Financiar");
	  	label_1.setBounds(21, 69, 216, 14);
	  	content.add(label_1);
	  	m_salarii.setBounds(222, 11, 239, 23);
	  
	  	content.add(m_salarii);
	  	m_consultareOrare.setBounds(222, 46, 239, 23);
	  	content.add(m_consultareOrare);
	  	m_consultareOrareLunare.setBounds(222, 81, 239, 23);
	  	content.add(m_consultareOrareLunare);
	  	m_consultareConcedii.setBounds(222, 116, 239, 23);
	  	content.add(m_consultareConcedii);
	  	m_profitPoliclinica.setBounds(222, 186, 239, 23);
	  	content.add(m_profitPoliclinica);
	  	m_profitMedici.setBounds(222, 221, 239, 23);
	  	content.add(m_profitMedici);
	  	m_profitSpecialitati.setBounds(222, 151, 239, 23);
	  	content.add(m_profitSpecialitati);
	  	m_logOut.setBounds(21, 221, 91, 23);
	  	content.add(m_logOut);
	  
	  	super.setContentPane(content);
	
        super.setTitle("Expert financiar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        super.setResizable(true);
	}
	
	void addVizSalariiListener(ActionListener mal) {
		m_salarii.addActionListener(mal);
	}

	void addConsultareOrareListener(ActionListener mal) {
		m_consultareOrare.addActionListener(mal);
	}
	
	void addConsultareOrareLunareListener(ActionListener mal) {
		m_consultareOrareLunare.addActionListener(mal);
	}

	void addConsultareConcediiListener(ActionListener mal) {
		m_consultareConcedii.addActionListener(mal);
	}

	void addProfitPoliclinicaListener(ActionListener mal) {
		m_profitPoliclinica.addActionListener(mal);
	}

	void addProfitMediciListener(ActionListener mal) {
		m_profitMedici.addActionListener(mal);
	}

	void addProfitSpecialitatiListener(ActionListener mal) {
		m_profitSpecialitati.addActionListener(mal);
	}

	void addLogOutListener(ActionListener mal) {
		m_logOut.addActionListener(mal);
	}
}
