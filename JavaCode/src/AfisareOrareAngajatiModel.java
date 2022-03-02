import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AfisareOrareAngajatiModel extends ModelGeneric{
	String[] columnNames = {"zi", "ora_inceput", "ora_sfarsit", "unitate_medicala"};

	AfisareOrareAngajatiModel(){
		
	}
	
	public void orareAngajat(String NUME, String PRENUME, String POLICLINICA) {
		JFrame frame1 = new JFrame("Date angajat");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        JTable table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        String zi = "";
        String ora_inceput = "";
        String ora_sfarsit = "";
        String unitate_medicala = "";

        try {

        	CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call afisare_orar_saptamanal (?, ?, ?)}");
			cstmt.setString(1, NUME);
			cstmt.setString(2, PRENUME);
			cstmt.setString(3, POLICLINICA);

			boolean hasRs = cstmt.execute(); ///afisandu-se mai multe tabele, trebuie abordata o alta strategie
											///variabila ce ne spune daca am avut cel putin un tabel
			System.out.println("Succes!");

			int i = 0;
			///aici tratam primul tabel ca si in exemplele anterioare
			///trebuie tratat separat pentru ca cu oricare functie ce ne spune daca mai sunt registre afisate, in acelasi timp,
			///ne va muta pe urmatorul, astfel prima inregistrare fiind netrata
			if (hasRs) {
	            try (ResultSet rs = cstmt.getResultSet()) {
	               while (rs.next()) {
	               		zi = rs.getString("zi");
	            	   	ora_inceput = rs.getString("ora_inceput");
	            	   	ora_sfarsit = rs.getString("ora_sfarsit");
	            	   	unitate_medicala = rs.getString("unitate_medicala");

		                model.addRow(new Object[]{zi, ora_inceput, ora_sfarsit, unitate_medicala});
		                i++;
	               }
	            }
	         }

			///prin conditia primului while, continuam sa parcurgem tabel cu tabel plasand cursorul inainte de prima line a acestuia
			while(cstmt.getMoreResults()) {
				try(ResultSet rs = cstmt.getResultSet()){
		            while (rs.next()) {
		            	zi = rs.getString("zi");
		            	ora_inceput = rs.getString("ora_inceput");
		            	ora_sfarsit = rs.getString("ora_sfarsit");
		            	unitate_medicala = rs.getString("unitate_medicala");

		                model.addRow(new Object[]{zi, ora_inceput, ora_sfarsit, unitate_medicala});

		                i++;
		            }
				}
			}

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            }
            else {
                System.out.println(i + " Records Found");
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
}
