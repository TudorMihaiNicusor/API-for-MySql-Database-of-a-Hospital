import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditareUtilizatoriModel extends ModelGeneric{

	EditareUtilizatoriModel(){
	}
	
	
	public void refreshTable() {
		EditareUtilizatoriView.modelTabel.setRowCount(0);
		
        String cnp = "";
        String nume = "";
        String prenume = "";
        String adresa = "";
        String telefon = "";
        String email = "";
        String iban = "";
        String nr_contract = "";
        String data_angajarii = "";
        String tip = "";
        String functie = "";
        String salar_neg = "";
        String nr_ore = "";
        String parola = "";
		
		 try {
			 	String queryStr = null;
			 	if(PoliclinicaMVC.tip.equals("administrator")) {
			 		queryStr = "SELECT * FROM utilizatori WHERE tip = 'angajat' ORDER BY nume";
			 	} else if(PoliclinicaMVC.tip.equals("super-administrator")){
			 		queryStr = "SELECT * FROM utilizatori;";
			 	}
			 	
				Statement stmt = PoliclinicaMVC.connection.createStatement();
				ResultSet rs = stmt.executeQuery(queryStr);
											
				System.out.println("Succes!");

				int i = 0;
		
			    while (rs.next()) {
			        
			          cnp = rs.getString("CNP");
			          nume = rs.getString("nume");
			          prenume = rs.getString("prenume");
			          adresa = rs.getString("adresa");
			          telefon = rs.getString("nr_telefon");
			          email = rs.getString("email");
			          iban = rs.getString("IBAN");
			          nr_contract = rs.getString("nr_contract");
			          data_angajarii = rs.getString("data_angajarii");
			          tip = rs.getString("tip");
			          functie = rs.getString("functie");
			          salar_neg = rs.getString("salar_neg");
			          nr_ore = rs.getString("nr_ore");
			          parola = rs.getString("parola");
			          
			          EditareUtilizatoriView.modelTabel.addRow(new Object[]{cnp, nume, prenume, adresa, telefon,
			        		  email, iban, nr_contract, data_angajarii, tip, functie, salar_neg, nr_ore, parola});

			          i++;
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

	        }
	        catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }

	}

	public void editareUtilizator(String id, String result, int column) {
		int rezultat = 1;
		long idCNP = Long.parseLong(id);
		try {
			String queryStr = "UPDATE utilizatori set " + EditareUtilizatoriView.columnNames[column] + " = ? where CNP = ? ";
			PreparedStatement pstmt = PoliclinicaMVC.connection.prepareStatement(queryStr);
			pstmt.setString(1, result);
			pstmt.setLong(2, idCNP);
			
			pstmt.executeUpdate();
			
			
		}
		catch (SQLException ex) {
			 rezultat = 0;
			 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(rezultat == 1) {
			JOptionPane.showMessageDialog(null, "Date introduse cu succes", "Info", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Eroare la introducerea datelor!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void stergereServiciu(String nume, String prenume) {
		int rezultat = -1;
		try {
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call stergere_utilizator (?, ?, ?, ?)}");
			cstmt.setString(1, nume);
			cstmt.setString(2, prenume);
			cstmt.setLong(3, Long.parseLong(PoliclinicaMVC.CNP));
			cstmt.registerOutParameter(4, java.sql.Types.INTEGER);
			
			cstmt.execute();
			
			rezultat = cstmt.getInt(4);
			
			cstmt.close();
			
		}
		catch (SQLException ex) {
			 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(rezultat == 1) {
			JOptionPane.showMessageDialog(null, "Stergere efectuata", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

