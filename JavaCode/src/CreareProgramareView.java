import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

///De lucrat pe maine 30.12.2020
public class CreareProgramareView extends ViewGeneric{

	 public JTextField m_nume = new JTextField(20);
	 public JTextField m_prenume = new JTextField(20);
	 public JComboBox m_unitateMedicala;
	 public JComboBox m_serviciu;
	 public JComboBox m_medic = new JComboBox();
	 public JTextField m_data = new JTextField(20);
	 public JTextField m_ora = new JTextField(20);
	 
	 Vector<String> lista_unitati_medicale;
	 Vector<String> lista_servicii;
	 Vector<String> lista_medici;

	 private JButton   m_programareBtn = new JButton("Creeaza programare");

	 private CreareProgramareModel m_model;

	 /** Constructor */
	 CreareProgramareView(ModelGeneric model) {

	 	m_model = (CreareProgramareModel) model;
	 	m_nume.setBounds(66, 14, 383, 20);
	    	
	 	m_nume.setEditable(true);
	 	m_prenume.setBounds(66, 48, 383, 20);
	 	m_prenume.setEditable(true);
	 	m_data.setBounds(119, 190, 134, 20);
	 	m_data.setEditable(true);
	 	m_ora.setBounds(119, 224, 134, 20);
	 	m_ora.setEditable(true);
	 	
	 	lista_unitati_medicale = m_model.getUnitatiMedicale();
	 	lista_servicii = m_model.getServicii();
	 	
	 	m_unitateMedicala = new JComboBox(lista_unitati_medicale);
	 	m_unitateMedicala.setBounds(117, 82, 136, 22);
	 	m_serviciu = new JComboBox(lista_servicii);
	 	m_serviciu.setBounds(119, 118, 134, 22);

	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	JLabel label = new JLabel("Nume");
	 	label.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label.setBounds(10, 17, 51, 14);
	 	content.add(label);
	 	content.add(m_nume);
	 	JLabel label_1 = new JLabel("Prenume");
	 	label_1.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_1.setBounds(10, 51, 51, 14);
	 	content.add(label_1);
	 	content.add(m_prenume);
	 	JLabel label_2 = new JLabel("Unitate Medicala");
	 	label_2.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_2.setBounds(10, 85, 103, 14);
	 	content.add(label_2);
	 	content.add(m_unitateMedicala);
	 	JLabel label_3 = new JLabel("Serviciu");
	 	label_3.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_3.setBounds(10, 122, 103, 14);
	 	content.add(label_3);
	 	content.add(m_serviciu);
	 	JLabel label_4 = new JLabel("Medic");
	 	label_4.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_4.setBounds(10, 158, 103, 14);
	 	content.add(label_4);
	 	m_medic.setBounds(119, 154, 134, 22);
	 	content.add(m_medic);
	 	JLabel label_5 = new JLabel("Data");
	 	label_5.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_5.setBounds(5, 193, 108, 14);
	 	content.add(label_5);
	 	content.add(m_data);
	 	JLabel label_6 = new JLabel("Ora");
	 	label_6.setHorizontalAlignment(SwingConstants.RIGHT);
	 	label_6.setBounds(10, 227, 103, 14);
	 	content.add(label_6);
	 	content.add(m_ora);
	 	m_programareBtn.setBounds(292, 129, 157, 49);

	 	content.add(m_programareBtn);
	        
	 	super.setContentPane(content);
	 	//this.pack();

	 	this.setTitle("Creare Programare");
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
	    
	 String getUnitateMedicalaItem() {
	        return String.valueOf(m_unitateMedicala.getSelectedItem());
	    }
	 
	 String getServiciuItem() {
			return String.valueOf(m_serviciu.getSelectedItem());
		 }
	 
	 String getMedicItem() {
			return String.valueOf(m_medic.getSelectedItem());
		 }
	 
	 String getDataInput() {
	        return m_data.getText();
	    }
	 
	 String getOraInput() {
	        return m_ora.getText();
	    }
	 
	void addServiciiListener(ActionListener mal) {
		m_serviciu.addActionListener(mal);
	}
		
	    
	 void addBtnProgramare(ActionListener mal) {
		 m_programareBtn.addActionListener(mal);
	    }
}
