import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MedicModel extends ModelGeneric{
	String[] columnNames = {"Nume Pacient", "Prenume Pacient", "Serviciu", "Ora", "Unitatea Medicala"};
	MedicModel() {
	 }
	
	public void afisarePacientiProgramati () {
		JFrame frame1 = new JFrame("Programari pe ziua curenta");
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
        String ora = "";
        String unitatea_medicala = "";

        try {

        	String queryStr = "SELECT *"
        			+ " FROM Programari_pacient"
        			+ " WHERE CNP_medic = " + PoliclinicaMVC.CNP
        			+ " AND ziua = CURRENT_DATE();";
			Statement stmt = PoliclinicaMVC.connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryStr);

			
			System.out.println("Succes!");

			int i = 0;
			
			
			while (rs.next()) {
	            nume = rs.getString("nume_pacient");
	            prenume = rs.getString("prenume_pacient");
	            serviciu = rs.getString("serviciu");
	            ora = rs.getString("ora");
	            unitatea_medicala = rs.getString("unitate_medicala");

		        model.addRow(new Object[]{nume, prenume, serviciu, ora, unitatea_medicala});
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
           

        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        frame1.add(scroll); ///scrolul vizibil pe fereastra
        frame1.setVisible(true); ///trebuie facuta vizibila fereastra
        frame1.setSize(400, 300); ///dimensiunea ferestrei ce contine tabelul
	}

		public void logOut() {
			System.out.println("I'm out!");
			PoliclinicaMVC.paginaCurenta = "Login";
			PoliclinicaMVC.lastView.setVisible(false);
			PoliclinicaMVC.main(null);
	 }
		
	public void deschidereCompletareRapoarteMedici() {
			PoliclinicaMVC.paginaCurenta = "completare rapoarte medici";
			PoliclinicaMVC.main(null);
		}
	
	public void deschidereVizSalarii() {
		PoliclinicaMVC.paginaCurenta = "vizualizare salariu angajat";
		PoliclinicaMVC.main(null);
	}
		
	public void deschidereGestionareServicii() {
		PoliclinicaMVC.paginaCurenta = "gestionare servicii medic";
		PoliclinicaMVC.main(null);
	}

	public void deschidereOrareSapt() {
		PoliclinicaMVC.paginaCurenta = "afisare orare angajati";
		PoliclinicaMVC.main(null);
	}

	public void deschidereConcedii() {
		PoliclinicaMVC.paginaCurenta = "afisare concedii angajati";
		PoliclinicaMVC.main(null);
	}

	public void deschidereOrareLunare() {
		PoliclinicaMVC.paginaCurenta = "afisare orare lunare angajati";
		PoliclinicaMVC.main(null);
	}
}
