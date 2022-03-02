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

public class GestionareServiciiMedicModel extends ModelGeneric{

	GestionareServiciiMedicModel(){
	}
	
	
	public void refreshTable() {
		GestionareServiciiMedicView.modelTabel.setRowCount(0);
		
        String serviciu = "";
        String specialitate = "";
        String competente = "";
        String pret = "";
        String durata = "";
		
		 try {
			 	String queryStr = "SELECT * FROM servicii_medicale WHERE CNP_medic = " + PoliclinicaMVC.CNP;
				Statement stmt = PoliclinicaMVC.connection.createStatement();
				ResultSet rs = stmt.executeQuery(queryStr);
											
				System.out.println("Succes!");

				int i = 0;
		
			    while (rs.next()) {
			        
			          serviciu = rs.getString("denumire");
			          specialitate = rs.getString("specialitate");
			          competente = rs.getString("competente");
			          pret = rs.getString("pret");
			          durata = rs.getString("durata");

			          GestionareServiciiMedicView.modelTabel.addRow(new Object[]{serviciu, specialitate, competente, pret, durata});

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

	public void adaugareServiciu(String serviciu, String specialitate, String competente, int pret, int durata) {
		int rezultat = -1;
		try {
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call adaugare_serviciu (?, ?, ?, ?, ?, ?, ?)}");
			cstmt.setLong(1, Long.parseLong(PoliclinicaMVC.CNP));
			cstmt.setString(2, serviciu);
			cstmt.setString(3, specialitate);
			cstmt.setString(4, competente);
			cstmt.setInt(5, pret);
			cstmt.setInt(6, durata);
			cstmt.registerOutParameter(7, java.sql.Types.INTEGER);
			
			cstmt.execute();
			
			rezultat = cstmt.getInt(7);
			
			cstmt.close();
			
		}
		catch (SQLException ex) {
			 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(rezultat == 1) {
			JOptionPane.showMessageDialog(null, "Date introduse cu succes", "Info", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Eroare la introducerea datelor!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void stergereServiciu(String serviciu) {
		int rezultat = -1;
		try {
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call stergere_serviciu (?, ?, ?)}");
			cstmt.setLong(1, Long.parseLong(PoliclinicaMVC.CNP));
			cstmt.setString(2, serviciu);
			cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
			
			cstmt.execute();
			
			rezultat = cstmt.getInt(3);
			
			cstmt.close();
			
		}
		catch (SQLException ex) {
			 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(rezultat == 1) {
			JOptionPane.showMessageDialog(null, "Stergere efectuata", "Info", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Eroare stergere", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

