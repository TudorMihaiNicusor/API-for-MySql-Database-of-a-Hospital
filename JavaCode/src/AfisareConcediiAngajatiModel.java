import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AfisareConcediiAngajatiModel extends ModelGeneric{
	String[] columnNames = {"Nume", "Prenume", "data_inceput", "data_sfarsit"};

	AfisareConcediiAngajatiModel(){
		
	}
	
	public void ConcediiAngajat(String NUME, String PRENUME) {
		JFrame frame1 = new JFrame("Concedii angajat");
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

        String nume = "";
        String prenume = "";
        String data_inceput = "";
        String data_sfarsit = "";

        try {

        	CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call afisare_concedii(?, ?)}");
			cstmt.setString(1, NUME);
			cstmt.setString(2, PRENUME);

			boolean hasRs = cstmt.execute(); 
			
			System.out.println("Succes!");

			int i = 0;
			
			if (hasRs) {
	            try (ResultSet rs = cstmt.getResultSet()) {
	               while (rs.next()) {
	               		nume = NUME;
	            	   	prenume = PRENUME;
	            	   	data_inceput = rs.getString("data_inceput");
	            	   	data_sfarsit = rs.getString("data_sfarsit");

		                model.addRow(new Object[]{nume, prenume, data_inceput, data_sfarsit});
		                i++;
	               }
	            }
	         }

			///prin conditia primului while, continuam sa parcurgem tabel cu tabel plasand cursorul inainte de prima line a acestuia
			while(cstmt.getMoreResults()) {
				try(ResultSet rs = cstmt.getResultSet()){
		            while (rs.next()) {
		            	nume = NUME;
	            	   	prenume = PRENUME;
	            	   	data_inceput = rs.getString("data_inceput");
	            	   	data_sfarsit = rs.getString("data_sfarsit");

		                model.addRow(new Object[]{nume, prenume, data_inceput, data_sfarsit});
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
