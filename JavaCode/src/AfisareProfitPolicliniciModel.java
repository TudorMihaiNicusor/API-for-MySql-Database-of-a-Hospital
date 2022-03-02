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

public class AfisareProfitPolicliniciModel extends ModelGeneric{
	String[] columnNames = {"Nume Policlinica", "Luna", "An", "Profit"};

	AfisareProfitPolicliniciModel(){
		
	}
	
	public void calculareProfitPoliclinici(String NUME_POLICLINICA, int LUNA, int AN,int PROFIT) {
		JFrame frame1 = new JFrame("Profit Policlinica");
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


        String numePoliclinica = "";
        String luna = "";
        String an = "";
        String Profit = "";
        int profit = -1;

        try {
        	CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call profit_policlinica(?, ?, ?, ?)}");
			cstmt.setString(1, NUME_POLICLINICA);
			cstmt.setInt(2, LUNA);
			cstmt.setInt(3, AN);
			cstmt.registerOutParameter(4, java.sql.Types.BIGINT);
			cstmt.execute();

			profit = cstmt.getInt(4);
			System.out.println("Succes!");

			int i = 1;
		    ///Deoarece stim sigur ca daca se va afisa ceva, va fi doar o linie, nu are rost sa ma retinem rezultat intr-o variabila
			numePoliclinica = NUME_POLICLINICA; ///si sa parcurgem
			luna = String.valueOf(LUNA);
			an = String.valueOf(AN);
			Profit = String.valueOf(profit);
			model.addRow(new Object[]{numePoliclinica, luna, an, Profit});

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
