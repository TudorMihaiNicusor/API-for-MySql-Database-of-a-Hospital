import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class GestionareServiciiMedicView extends ViewGeneric{

	 public JTable tabel;
	 public JTextField m_serviciu = new JTextField(20);
	 public JTextField m_specialitate = new JTextField(20);
	 public JTextField m_competenta= new JTextField(20);
	 public JTextField m_pret = new JTextField(20);
	 public JTextField m_durata = new JTextField(20);
	 
	 public JButton   m_adaugareBtn = new JButton("Adauga");
	 public JButton   m_stergereBtn = new JButton("Sterge");
	 
	 public static DefaultTableModel modelTabel = new DefaultTableModel();
	 
	 Vector<String> lista_unitati_medicale;
	 Vector<String> lista_servicii;
	 Vector<String> lista_medici;
	 
	 String columnNames[] = {"Denumire", "Specialitate", "Competente", "Pret", "Durata"};
	

	 private GestionareServiciiMedicModel m_model;

	 /** Constructor */
	 GestionareServiciiMedicView(ModelGeneric model) {

	 	m_model = (GestionareServiciiMedicModel) model;
	 	
	 	
	 	/////////Tabel
	 	JPanel panel1 = new JPanel();
	 	panel1.setLocation(45, 5);
	 	panel1.setLayout(new BorderLayout());
	 	
        modelTabel.setColumnIdentifiers(columnNames);
        
        tabel = new JTable();
        tabel.setModel(modelTabel);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabel.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(tabel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel1.add(scroll);
        panel1.setVisible(true);
        panel1.setSize(452, 402);
        
        m_model.refreshTable();
        m_serviciu.setBounds(562, 81, 166, 20);
	    	
        m_serviciu.setEditable(true);
        m_specialitate.setBounds(562, 130, 166, 20);
        m_specialitate.setEditable(true);
        m_competenta.setBounds(562, 186, 166, 20);
        m_competenta.setEditable(true);
        m_pret.setBounds(562, 239, 166, 20);
        m_pret.setEditable(true);
        m_durata.setBounds(562, 284, 166, 20);
        m_durata.setEditable(true);
	 	

	 	JPanel content = new JPanel();
	 	content.setLayout(null);
	 	content.add(panel1);
	 	JLabel label = new JLabel("Serviciu");
	 	label.setHorizontalAlignment(SwingConstants.LEFT);
	 	label.setBounds(562, 67, 93, 14);
	 	content.add(label);
	 	content.add(m_serviciu);
	 	JLabel label_1 = new JLabel("Specialitate");
	 	label_1.setHorizontalAlignment(SwingConstants.LEFT);
	 	label_1.setBounds(562, 117, 93, 14);
	 	content.add(label_1);
	 	content.add(m_specialitate);
	 	JLabel label_2 = new JLabel("Competenta");
	 	label_2.setHorizontalAlignment(SwingConstants.LEFT);
	 	label_2.setBounds(562, 171, 101, 14);
	 	content.add(label_2);
	 	content.add(m_competenta);
	 	JLabel label_3 = new JLabel("Pret");
	 	label_3.setHorizontalAlignment(SwingConstants.LEFT);
	 	label_3.setBounds(562, 227, 66, 14);
	 	content.add(label_3);
	 	content.add(m_pret);
	 	JLabel label_4 = new JLabel("Durata");
	 	label_4.setHorizontalAlignment(SwingConstants.LEFT);
	 	label_4.setBounds(562, 270, 68, 14);
	 	content.add(label_4);
	 	content.add(m_durata);
	 	m_adaugareBtn.setBounds(547, 354, 81, 42);

	 	content.add(m_adaugareBtn);
	 	m_stergereBtn.setBounds(658, 354, 81, 42);
	 	content.add(m_stergereBtn);
	        
	 	super.setContentPane(content);
	 	//this.pack();

	 	this.setTitle("Gestionare Servicii");
	 	super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(787,462);
        super.setResizable(true);
	 }

	 String getServiciuInput() {
	        return m_serviciu.getText();
	    }

	 String getSpecialitateInput() {
	        return m_specialitate.getText();
	    }
	 
	 String getCompetentaInput() {
	        return m_competenta.getText();
	    }
	    
	 String getPretInput() {
	        return m_pret.getText();
	    }
	 
	 String getDurataInput() {
	        return m_durata.getText();
	    }
		
	    
	 void addBtnAdaugare(ActionListener mal) {
		 m_adaugareBtn.addActionListener(mal);
	    }
	 
	 void addBtnStergere(ActionListener mal) {
		 m_stergereBtn.addActionListener(mal);
	    }
	 
}
