import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InregistrareConcediuModel extends ModelGeneric{

	InregistrareConcediuModel(){
	}
	
	public void stabilireConcediu(String nume, String prenume, String data_inceput, String data_sfarsit) {
		boolean success = true;
		try {
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call stabilire_concediu (?, ?, ?, ?)}");
			cstmt.setString(1, nume);
			cstmt.setString(2, prenume);
			cstmt.setString(3, data_inceput);
			cstmt.setString(4, data_sfarsit);
			
			cstmt.execute();
			cstmt.close();
			
		}
		catch (SQLException ex) {
			 success = false;
			 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(success) {
			JOptionPane.showMessageDialog(null, "Success!", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
