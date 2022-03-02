import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InspectorModel extends ModelGeneric{
	String[] columnNamesConcedii = {"CNP_utilizator", "data_inceput", "data_sfarsit"};

	InspectorModel() {
 	}
	
	public void afisareDateAngajati() {
		PoliclinicaMVC.paginaCurenta = "afisare date angajati";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereOrareAngajati() {
		PoliclinicaMVC.paginaCurenta = "afisare orare angajati";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereConcediiAngajati() {
		PoliclinicaMVC.paginaCurenta = "afisare concedii angajati";
		PoliclinicaMVC.main(null);
	}
	
	public void afisareConcedii() {
		JFrame frame1 = new JFrame("Concedii");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNamesConcedii);

        JTable table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        String CNP_utilizator = "";
        String data_inceput = "";
        String data_sfarsit = "";

        ///Aici am stabilit ca mai discutam putin despre cum va fi functia si cum manevram treaba
        try {
        	CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call afisare_concedii ()}");
			boolean hasRs = cstmt.execute();
			  
			System.out.println("Succes!");
			
			if (hasRs) {
	            try (ResultSet rs = cstmt.getResultSet()) {
	               while (rs.next()) {
	               		CNP_utilizator = rs.getString("CNP_utilizator");
	                    data_inceput = rs.getString("data_inceput");
	                    data_sfarsit = rs.getString("data_sfarsit");

	                    model.addRow(new Object[]{CNP_utilizator, data_inceput, data_sfarsit});
	               }
	            }
	         }

			///Se putea parcurge si cu un While, dar stim exact cate tabele ni se vor afisa
			for(int i=2;i<=7;i++) {
			 if (cstmt.getMoreResults()) {
		            try (ResultSet rs = cstmt.getResultSet()) {
		            	while (rs.next()) {
		            		CNP_utilizator = rs.getString("CNP_utilizator");
		                    data_inceput = rs.getString("data_inceput");
		                    data_sfarsit = rs.getString("data_sfarsit");

		                    model.addRow(new Object[]{CNP_utilizator, data_inceput, data_sfarsit});
		               }
		            }
		         }
			}
            cstmt.close();
        }
        catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
	}
	
	public void deschidereInregistrareConcediu() {
		PoliclinicaMVC.paginaCurenta = "inregistrare concediu";
		PoliclinicaMVC.main(null);
	}
	
	public void logOut() {
		System.out.println("I'm out!");
		PoliclinicaMVC.paginaCurenta = "Login";
		PoliclinicaMVC.lastView.setVisible(false);
		PoliclinicaMVC.main(null);
 	}

	public void deschidereSalarii() {
		PoliclinicaMVC.paginaCurenta = "vizualizare salariu angajat";
		PoliclinicaMVC.main(null);
		
	}

	public void deschidereOrareLunare() {
		PoliclinicaMVC.paginaCurenta = "afisare orare lunare angajati";
		PoliclinicaMVC.main(null);
	}
}
