import java.awt.BorderLayout;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AfisareSalariiAngajatiModel extends ModelGeneric{
	String[] columnNames = {"nume", "prenume", "luna", "Salariu"};

	AfisareSalariiAngajatiModel(){
	}
	
	public void salariiAngajat(String NUME, String PRENUME, int LUNA, int SALARIU) {

	    JFrame frame1 = new JFrame("Salariu angajat");
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
        String luna = "";
        String Salariu = "";

        long salariu;
        try {

            CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call calculare_salariu (?, ?, ?, ?)}");
			cstmt.setString(1, NUME);
			cstmt.setString(2, PRENUME);
			cstmt.setInt(3, LUNA);
			cstmt.registerOutParameter(4, java.sql.Types.BIGINT);

			cstmt.execute();
			  
			salariu = cstmt.getLong(4);

			System.out.println("Succes!");

			int i = 1;
			nume = NUME;
			prenume = PRENUME;
			luna = String.valueOf(LUNA);
			Salariu = String.valueOf(salariu);

			model.addRow(new Object[]{nume, prenume, luna, Salariu});

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
