import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReceptionerView extends ViewGeneric{

	private JButton m_creareProgramare = new JButton("Creare programare");
	private JButton m_consultareOrare = new JButton("Consultare orar saptamanal");
    private JButton m_consultareOrareLunare = new JButton("Consultare orar lunar");
	private JButton m_consultareConcedii = new JButton("Consultare concedii");
	private JButton m_consultareSalarii = new JButton("Consultare salariu");
	private JButton m_logOut = new JButton("Log Out");

	private ReceptionerModel m_model;

	/** Constructor */
	ReceptionerView(ModelGeneric model) {
		m_model = (ReceptionerModel) model;

	  	JPanel content = new JPanel();
	  	content.setLayout(null);
	  	JLabel label = new JLabel("Nume si Prenume: " + PoliclinicaMVC.numele + " " + PoliclinicaMVC.prenumele);
	  	label.setBounds(20, 33, 211, 14);
	  	content.add(label);
	  	JLabel label_1 = new JLabel("Functie: Receptioner");
	  	label_1.setBounds(21, 75, 180, 14);
	  	content.add(label_1);
	  	m_creareProgramare.setBounds(233, 24, 218, 23);
	  
	  	content.add(m_creareProgramare);
	  	m_consultareSalarii.setBounds(233, 71, 218, 23);
	  	content.add(m_consultareSalarii);
	  	m_consultareOrare.setBounds(233, 118, 218, 23);
	  	content.add(m_consultareOrare);
	  	m_consultareOrareLunare.setBounds(233, 165, 218, 23);
	  	content.add(m_consultareOrareLunare);
	  	m_consultareConcedii.setBounds(233, 212, 218, 23);
	  	content.add(m_consultareConcedii);
	  	m_logOut.setBounds(10, 227, 91, 23);

	
	  	content.add(m_logOut);
	  
	  	super.setContentPane(content);
		
        super.setTitle("Receptioner");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        super.setResizable(true);
	}
	
	void addCreareProgramareListener(ActionListener mal) {
		m_creareProgramare.addActionListener(mal);
	}
	
	void addOrareSaptListener(ActionListener mal) {
		m_consultareOrare.addActionListener(mal);
	}
	
	void addOrareLunarListener(ActionListener mal) {
		m_consultareOrareLunare.addActionListener(mal);
	}
	
	void addSalariiListener(ActionListener mal) {
		m_consultareSalarii.addActionListener(mal);
	}
	
	void addConcediiListener(ActionListener mal) {
		m_consultareConcedii.addActionListener(mal);
	}
	
	void addLogOutListener(ActionListener mal) {
		m_logOut.addActionListener(mal);
	}

	
}
