import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MedicView extends ViewGeneric {
	private JButton m_vizPacProgramati = new JButton("Vizualizare pacienti programati");
	private JButton m_vizRapoarte = new JButton("Vizualizare rapoarte");
    private JButton m_consultareSalarii = new JButton("Consultare salariu");
    private JButton m_consultareOrare = new JButton("Consultare orar saptamanal");
    private JButton m_consultareOrareLunare = new JButton("Consultare orar lunar");
    private JButton m_consultareConcedii = new JButton("Consultare concedii");
    private JButton m_gestionareServ = new JButton("Gestionare servicii medicale");
	private JButton m_logOut = new JButton("Log Out");

	private MedicModel m_model;

	/** Constructor */
	MedicView(ModelGeneric model) {
		m_model = (MedicModel) model;

	  	JPanel content = new JPanel();
	  	content.setLayout(null);
	  	JLabel label = new JLabel("Nume si Prenume: " + PoliclinicaMVC.numele + " " + PoliclinicaMVC.prenumele);
	  	label.setBounds(14, 27, 208, 14);
	  	content.add(label);
	  	JLabel label_1 = new JLabel("Functie: Medic");
	  	label_1.setBounds(14, 69, 178, 14);
	  	content.add(label_1);
	  	m_consultareOrare.setBounds(232, 117, 230, 23);
	  	
	  	content.add(m_consultareOrare);
	  	m_consultareOrareLunare.setBounds(232, 152, 230, 23);
	  	content.add(m_consultareOrareLunare);
	  	m_consultareSalarii.setBounds(232, 187, 230, 23);
	  	content.add(m_consultareSalarii);
	  	m_consultareConcedii.setBounds(232, 222, 230, 23);
	  	content.add(m_consultareConcedii);
	  	m_vizPacProgramati.setBounds(232, 12, 230, 23);
	  	content.add(m_vizPacProgramati);
	  	m_vizRapoarte.setBounds(232, 47, 230, 23);
	  	content.add(m_vizRapoarte);
	  	m_gestionareServ.setBounds(232, 82, 230, 23);
	  	content.add(m_gestionareServ);
	  	m_logOut.setBounds(14, 227, 82, 23);
	  	content.add(m_logOut);
	  
	  	super.setContentPane(content);
		
        super.setTitle("Medic");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        super.setResizable(true);
	}
	
	void addProgramariListener(ActionListener mal) {
		m_vizPacProgramati.addActionListener(mal);
	}
	
	void addSalariiListener(ActionListener mal) {
		m_consultareSalarii.addActionListener(mal);
	}
	
	void addOrareListener(ActionListener mal) {
		m_consultareOrare.addActionListener(mal);
	}
	
	void addOrareLunareListener(ActionListener mal) {
		m_consultareOrareLunare.addActionListener(mal);
	}
	
	void addConcediiListener(ActionListener mal) {
		m_consultareConcedii.addActionListener(mal);
	}
	
	void addRapoarteListener(ActionListener mal) {
		m_vizRapoarte.addActionListener(mal);
	}
	
	void addGestionareServiciiListener(ActionListener mal) {
		m_gestionareServ.addActionListener(mal);
	}
	
	void addLogOutListener(ActionListener mal) {
		m_logOut.addActionListener(mal);
	}

}
