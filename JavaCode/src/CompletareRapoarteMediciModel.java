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

public class CompletareRapoarteMediciModel extends ModelGeneric{

	CompletareRapoarteMediciModel(){
	}
	
	public void parafareRaport(int raport) {
		int rezultat = -1;
		try {
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call completare_raport (?, ?, ?, ?, ?)}");
			cstmt.setLong(1, Long.parseLong(PoliclinicaMVC.CNP));
			cstmt.setInt(2, raport);
			cstmt.setString(3, "cod_parafa");
			cstmt.setString(4, "");
			cstmt.registerOutParameter(5, java.sql.Types.INTEGER);
			
			cstmt.execute();
			
			rezultat = cstmt.getInt(5);
			
			cstmt.close();
			
		}
		catch (SQLException ex) {
			 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(rezultat == 1) {
			JOptionPane.showMessageDialog(null, "Raport parafat", "Info", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Eroare", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void refreshTable() {
		CompletareRapoarteMediciView.modelTabel.setRowCount(0);
		
        String id_raport = "";
        String ziua = "";
        String nume_pacient = "";
        String prenume_pacient = "";
        String rezultat = "";
        String cnp_medic = "";
        String cnp_asistent = "";
        String recomandari = "";
        String simptome = "";
        String diagnostic = "";
        String investigatie = "";
        String parafa = "";
		
		 try {
			 	String queryStr = "SELECT * FROM rapoarte_programare WHERE (cnp_medic_rec = " + PoliclinicaMVC.CNP + " OR cnp_medic_rec IS NULL) ORDER BY cod_parafa;";
			 	Statement stmt = PoliclinicaMVC.connection.createStatement();
				ResultSet rs = stmt.executeQuery(queryStr);
											
				System.out.println("Succes!");

				int i = 0;
		
			    while (rs.next()) {
			        
			          id_raport = rs.getString("id_raport");
			          ziua = rs.getString("ziua");
			          nume_pacient = rs.getString("nume_pacient");
			          prenume_pacient = rs.getString("prenume_pacient");
			          rezultat = rs.getString("rezultat");
			          cnp_medic = rs.getString("cnp_medic_rec");
			          cnp_asistent = rs.getString("cnp_asistent");
			          recomandari = rs.getString("recomandari");
			          simptome = rs.getString("simptome");
			          diagnostic = rs.getString("diagnostic");
			          investigatie = rs.getString("investigatie");
			          parafa = rs.getString("cod_parafa");

			          CompletareRapoarteMediciView.modelTabel.addRow(new Object[]{id_raport, ziua, nume_pacient, prenume_pacient, rezultat,
			        		  cnp_medic, cnp_asistent, recomandari, simptome, diagnostic, investigatie, parafa});

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
	
	public void completareRaportMedici(String id, String result, int column) {
		int rezultat = -1;
		try {
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call completare_raport (?, ?, ?, ?, ?)}");
			cstmt.setLong(1, Long.parseLong(PoliclinicaMVC.CNP));
			cstmt.setInt(2, Integer.parseInt(id));
			cstmt.setString(3, CompletareRapoarteMediciView.columnNames[column]);
			cstmt.setString(4, result);
			cstmt.registerOutParameter(5, java.sql.Types.INTEGER);
			
			System.out.println(CompletareRapoarteMediciView.columnNames[column]);
			
			cstmt.execute();
			
			rezultat = cstmt.getInt(5);
			
			cstmt.close();
			
		}
		catch (SQLException ex) {
			 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(rezultat == 1) {
			JOptionPane.showMessageDialog(null, "Success!", "Info", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Campul nu a putut fi modificat", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	
}

