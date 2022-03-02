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

public class CreareProgramareModel extends ModelGeneric{
	String[] columnNames = {"Nume", "Prenume", "Serviciu", "Pret"};

	CreareProgramareModel(){
	}
	
	public Vector<String> getUnitatiMedicale(){
		 Vector<String> result = new Vector<String>();
		 
		 result.add("");
		 
		 try {
				String queryStr = "SELECT denumire FROM Unitati_medicale";
				Statement stmt = PoliclinicaMVC.connection.createStatement();
				ResultSet rst = stmt.executeQuery(queryStr);
				
				while(rst.next()) {
					String denumire = rst.getString("denumire");
					result.add(denumire);
				}
			}
			catch (SQLException ex) {
				System.err.println("SQLException: " + ex);
			}
		 return result;
	}
	
	public Vector<String> getServicii(){
		 Vector<String> result = new Vector<String>();
		 
		 result.add("");
		 
		 try {
				String queryStr = "SELECT denumire FROM servicii_medicale";
				Statement stmt = PoliclinicaMVC.connection.createStatement();
				ResultSet rst = stmt.executeQuery(queryStr);
				
				while(rst.next()) {
					String denumire = rst.getString("denumire");
					result.add(denumire);
				}
			}
			catch (SQLException ex) {
				System.err.println("SQLException: " + ex);
			}
		 
		 return result;
	}
	
	public Vector<String> getMedici(String denumireServiciu){
		 Vector<String> result = new Vector<String>();
		 
		 
		 try {

	            CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call medici_dupa_serviciu(?)}");
				cstmt.setString(1, denumireServiciu);
				
				ResultSet rs = cstmt.executeQuery();
				  
				while(rs.next()) {
					String nume_prenume_medic = rs.getString("nume_prenume_medic");
					result.add(nume_prenume_medic);
				}

	        }
	        catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
		 
		 return result;
	}
	
	public int programarePacient(String NUME, String PRENUME, String UNITATE_MEDICALA, String SERVICIU, String NUME_MEDIC, String PRENUME_MEDIC, String DATA, String ORA) {
		int rezultat = 0;
        try {

            CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call creare_programare (?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cstmt.setString(1, NUME);
			cstmt.setString(2, PRENUME);
			cstmt.setString(3, NUME_MEDIC);
			cstmt.setString(4, PRENUME_MEDIC);
			cstmt.setString(5, DATA);
			cstmt.setString(6, ORA);
			cstmt.setString(7, SERVICIU);
			cstmt.setString(8, UNITATE_MEDICALA);
			cstmt.registerOutParameter(9, java.sql.Types.INTEGER);

			cstmt.execute();
			  
			rezultat = cstmt.getInt(9);

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(rezultat == 1) {
        	JOptionPane.showMessageDialog(null, "Programare creata cu succes!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
        	JOptionPane.showMessageDialog(null, "Programare esuata!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return rezultat;
	}
	
	 public void afisareBonFiscal(String NUME, String PRENUME, String Serviciu, String NUME_MEDIC, String PRENUME_MEDIC) {
			JFrame frame1 = new JFrame("Bon fiscal");
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
			String serviciu = "";
			String pret = "";

			try {
				 CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call pret_dupa_serviciu_si_medic (?, ?, ?, ?)}");
				 cstmt.setString(1, Serviciu);
				 cstmt.setString(2, NUME_MEDIC);
				 cstmt.setString(3, PRENUME_MEDIC);
				 cstmt.registerOutParameter(4, java.sql.Types.INTEGER);
				 
				 cstmt.execute();

				 pret = String.valueOf(cstmt.getInt(4));
				 
				
				int i = 1;
				
		                nume = NUME;
		                prenume = PRENUME;
		                serviciu = Serviciu;
		   
		                model.addRow(new Object[]{nume, prenume, serviciu, pret});


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

			frame1.add(scroll);
			frame1.setVisible(true);
			frame1.setSize(400, 300);

		}
}
