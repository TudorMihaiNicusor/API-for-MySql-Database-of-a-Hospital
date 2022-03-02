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

public class AdminModel extends ModelGeneric{

	AdminModel() {
 	}

	
	public void deschidereAddUser() {
		PoliclinicaMVC.paginaCurenta = "adaugare utilizator";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereEditUser() {
		PoliclinicaMVC.paginaCurenta = "editare utilizatori";
		PoliclinicaMVC.main(null);
	}
	
	public void logOut() {
		System.out.println("I'm out!");
		PoliclinicaMVC.paginaCurenta = "Login";
		PoliclinicaMVC.lastView.setVisible(false);
		PoliclinicaMVC.main(null);
 	}
}
