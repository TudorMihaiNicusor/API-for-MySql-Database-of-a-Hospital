import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReceptionerModel extends ModelGeneric{
	
	String[] columnNames = {"Data", "Ora", "Suma achitata"};

	ReceptionerModel() {
 	}

	
	public void deschidereCreareProgramare() {
		PoliclinicaMVC.paginaCurenta = "creare programare";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereVizSalarii() {
		PoliclinicaMVC.paginaCurenta = "vizualizare salariu angajat";
		PoliclinicaMVC.main(null);
	}
	
	
	
	public void logOut() {
		System.out.println("I'm out!");
		PoliclinicaMVC.paginaCurenta = "Login";
		PoliclinicaMVC.lastView.setVisible(false);
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


	public void deschidereOrareLunar() {
		PoliclinicaMVC.paginaCurenta = "afisare orare lunare angajati";
		PoliclinicaMVC.main(null);
	}
}
