import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AsistentView extends ViewGeneric{
	
	private JButton m_vizRapoarte = new JButton("Vizualizare rapoarte");
	private JButton m_consultareSalarii = new JButton("Consultare salariu");
    private JButton m_consultareOrare = new JButton("Consultare orar saptamanal");
    private JButton m_consultareOrareLunare = new JButton("Consultare orar lunar");
    private JButton m_consultareConcedii = new JButton("Consultare concedii");
	private JButton m_logOut = new JButton("Log Out");
	private AsistentModel m_model;

	/** Constructor */
	AsistentView(ModelGeneric model) {
		m_model = (AsistentModel) model;

	  	JPanel content = new JPanel();
	  	content.setLayout(null);
	  	JLabel label = new JLabel("Nume si Prenume: " + PoliclinicaMVC.numele + " " + PoliclinicaMVC.prenumele);
	  	label.setBounds(10, 28, 235, 14);
	  	content.add(label);
	  	JLabel label_1 = new JLabel("Functie: Asistent Medical");
	  	label_1.setBounds(10, 62, 189, 14);
	  	content.add(label_1);
	  	m_vizRapoarte.setBounds(227, 24, 231, 23);
	  
	  	content.add(m_vizRapoarte);
	  	m_consultareSalarii.setBounds(227, 71, 231, 23);
	  	content.add(m_consultareSalarii);
	  	m_consultareOrare.setBounds(227, 118, 231, 23);
	  	content.add(m_consultareOrare);
	  	m_consultareOrareLunare.setBounds(227, 165, 231, 23);
	  	content.add(m_consultareOrareLunare);
	  	m_consultareConcedii.setBounds(227, 212, 231, 23);
	  	content.add(m_consultareConcedii);
	  	m_logOut.setBounds(10, 227, 88, 23);
	  	content.add(m_logOut);
	  
	  	super.setContentPane(content);
		
        super.setTitle("Asistent");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        super.setResizable(true);
	}
	
	void addRapoarteListener(ActionListener mal) {
		m_vizRapoarte.addActionListener(mal);
	}
	
	void addOrareSaptListener(ActionListener mal) {
		m_consultareOrare.addActionListener(mal);
	}
	
	void addOrareLunarListener(ActionListener mal) {
		m_consultareOrareLunare.addActionListener(mal);
	}
	
	void addConcediiListener(ActionListener mal) {
		m_consultareConcedii.addActionListener(mal);
	}
	
	void addSalariiListener(ActionListener mal) {
		m_consultareSalarii.addActionListener(mal);
	}
	
	void addLogOutListener(ActionListener mal) {
		m_logOut.addActionListener(mal);
	}
}
