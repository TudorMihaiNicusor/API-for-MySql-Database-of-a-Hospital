import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class CompletareRapoarteView extends ViewGeneric{

	 public JTable tabel;
	 
	 public static DefaultTableModel modelTabel = new DefaultTableModel();
	 
	 
	 static String columnNames[] = {"id_raport", "Ziua", "Nume Pacient", "Prenume Pacient", "Rezultat", "CNP Medic", "CNP asistent",
			 "Recomandari", "Simptome", "Diagnostic", "Investigatie", "Parafa"};
	

	 private CompletareRapoarteModel m_model;

	 /** Constructor */
	 CompletareRapoarteView(ModelGeneric model) {

	 	m_model = (CompletareRapoarteModel) model;
	 	
	 	
	 	/////////Tabel
	 	JPanel panel1 = new JPanel();
	 	panel1.setLayout(new BorderLayout());
	 	
        modelTabel.setColumnIdentifiers(columnNames);
        
        tabel = new JTable();
        tabel.setModel(modelTabel);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabel.setFillsViewportHeight(true);
        tabel.setPreferredScrollableViewportSize(new Dimension(800, 600));
        JScrollPane scroll = new JScrollPane(tabel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel1.add(scroll);
        
        tabel.addKeyListener((KeyListener) new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    int row = tabel.getSelectedRow();
                    int column = tabel.getSelectedColumn();

                    // resul is the new value to insert in the DB
                    String resul = tabel.getValueAt(row, column).toString();
                    // id is the primary key of my DB
                    System.out.println(row + " " + column);
                    String id = tabel.getValueAt(row, 0).toString();

                    // update is my method to update. Update needs the id for
                    // the where clausule. resul is the value that will receive
                    // the cell and you need column to tell what to update.
                    m_model.completareRaport(id, resul, column);
                    m_model.refreshTable();

                }
            }
        });
        
        panel1.setVisible(true);
        panel1.setSize(600, 300);
        
        m_model.refreshTable();
	 	

	 	JPanel content = new JPanel();
	 	content.setLayout(new BorderLayout(0, 0));
	 	content.add(panel1);
	 	
	        
	 	super.setContentPane(content);
	 	//this.pack();

	 	this.setTitle("Rapoarte");
	 	super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,530);
        super.setResizable(true);
	 }
	 
	    
	 
}
