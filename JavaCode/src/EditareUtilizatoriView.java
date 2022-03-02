import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.BoxLayout;

public class EditareUtilizatoriView extends ViewGeneric{

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
	 
	 public static String columnNames[] = {"CNP", "nume", "prenume", "adresa", "nr_telefon", "email", "IBAN", "nr_contract", "data_angajarii",
			 "tip", "functie", "salar_neg", "nr_ore", "parola"};
	

	 private EditareUtilizatoriModel m_model;

	 /** Constructor */
	 EditareUtilizatoriView(ModelGeneric model) {

	 	m_model = (EditareUtilizatoriModel) model;
	 	
	 	
	 	/////////Tabel
	 	JPanel panel1 = new JPanel();
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
        
        tabel.addKeyListener((KeyListener) new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    int row = tabel.getSelectedRow();
                    int column = tabel.getSelectedColumn();

                    // resul is the new value to insert in the DB
                    String resul = tabel.getValueAt(row, column).toString();
                    // id is the primary key of my DB
                    String id = tabel.getValueAt(row, 0).toString();

                    // update is my method to update. Update needs the id for
                    // the where clausule. resul is the value that will receive
                    // the cell and you need column to tell what to update.
                    m_model.editareUtilizator(id, resul, column);
                    m_model.refreshTable();

                }
            }
        });
        
        m_model.refreshTable();
	    	
        m_serviciu.setEditable(true);
        m_specialitate.setEditable(true);
        m_competenta.setEditable(true);
        m_pret.setEditable(true);
        m_durata.setEditable(true);
	 	

	 	JPanel content = new JPanel();
	 	content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
	 	content.add(panel1);

	 	content.add(m_stergereBtn);
	        
	 	super.setContentPane(content);
	 	//this.pack();

	 	this.setTitle("Editare Utilizatori");
	 	super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(803,537);
        super.setResizable(true);
	 }
	 
	 void addBtnStergere(ActionListener mal) {
		 m_stergereBtn.addActionListener(mal);
	    }
}
