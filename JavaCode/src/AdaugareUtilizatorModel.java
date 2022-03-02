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

public class AdaugareUtilizatorModel extends ModelGeneric{

	AdaugareUtilizatorModel(){
	}

	public void adaugareUtilizator(long CNP, String nume, String prenume, String adresa, String nr_telefon,
			String email, String IBAN, String nr_contract, String data_angajarii, String tip, String functie,
			float salar_neg, int nr_ore, String parola, long CNP_modificator) {
		int success = -1;
		try {
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call creare_utilizator (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cstmt.setLong(1, CNP);
			cstmt.setString(2, nume);
			cstmt.setString(3, prenume);
			cstmt.setString(4, adresa);
			cstmt.setString(5, nr_telefon);
			cstmt.setString(6, email);
			cstmt.setString(7, IBAN);
			cstmt.setString(8, nr_contract);
			cstmt.setString(9, data_angajarii);
			cstmt.setString(10,  tip);
			cstmt.setString(11, functie);
			cstmt.setFloat(12, salar_neg);
			cstmt.setInt(13, nr_ore);
			cstmt.setString(14, parola);
			cstmt.setLong(15, CNP_modificator);
			cstmt.registerOutParameter(16, java.sql.Types.INTEGER);
			
			cstmt.execute();
			
			success = cstmt.getInt(16);
			cstmt.close();
			
		}
		catch (SQLException ex) {
			 success = 0;
			 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(success == 1) {
			JOptionPane.showMessageDialog(null, "Utilizator inregistrat cu succes!", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
