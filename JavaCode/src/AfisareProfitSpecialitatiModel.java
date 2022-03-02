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

public class AfisareProfitSpecialitatiModel extends ModelGeneric{
	String[] columnNames = {"Specialitate", "Policlinica", "Luna", "Profit"};

	AfisareProfitSpecialitatiModel(){
	}
	
	public void calculareProfitSpecialitate(String SPECIALITATE, String POLICLINICA, int LUNA, int PROFIT) {
		JFrame frame1 = new JFrame("Profit " + SPECIALITATE + " de la Policlinica " + POLICLINICA);
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

        String Specialitate = "";
        String Policlinica = "";
        String Luna = "";
        String Profit = "";
        int profit = 0;

        try {

        	CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call profit_specialitate_policlinica (?, ?, ?, ?)}");
			cstmt.setString(1, SPECIALITATE);
			cstmt.setString(2, POLICLINICA);
			cstmt.setInt(3, LUNA);
			cstmt.registerOutParameter(4, java.sql.Types.BIGINT);
		
			cstmt.execute();
			  
			profit = cstmt.getInt(4);
			
			System.out.println("Succes!");
			int i = 1;

			Specialitate = SPECIALITATE;
			Policlinica = POLICLINICA;
			Luna = String.valueOf(LUNA);
			Profit = String.valueOf(profit);
			model.addRow(new Object[]{Specialitate, Policlinica, Luna, Profit});

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

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
	}
}
