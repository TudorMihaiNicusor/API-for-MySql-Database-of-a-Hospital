import java.math.BigInteger;

import javax.swing.JOptionPane;

import java.sql.*;

//In Modele am definit functiile din spatele interfetei, functii care fac legatura cu baze de date si preiau/transmit informatii
//catre aceasta; sunt activate de actiunile realizate de Utilizator
public class PoliclinicaModel extends ModelGeneric{

	PoliclinicaModel() { //constructorul este gol, deoarece este nevoie de functiile definite in aceasta componenta
    }

    ///functia de logare
	public void login(String userName, String password) {
		String functie = null;
		String numele = null;
		String prenumele = null;
		int rezultat = 0;

		///orice interactiune pe care dorim a o face cu MySQL-ul trebuie integrata intr-un try-catch, altfel vom avea eroare de unhandled
		try {
			///crearea unei variabile ce va apela o procedura din MySQL
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call logare (?, ?, ?)}");
			cstmt.setString(1, userName); ///setarea varibilelor de intrarea, deoarece acestea sunt dinamice
			cstmt.setString(2, password);
			cstmt.registerOutParameter(3, java.sql.Types.INTEGER); ///variabila de tip OUT a procedurii

			cstmt.execute(); //executarea propriu-zisa
			
			rezultat = cstmt.getInt(3); //extragerea parametrului de tip OUT
			
			cstmt.close(); ///inchiderea variabilei ce a executat chemarea procedurii
			System.out.println("Succes!"); //mesaj pentru consola <- un Debug mai usor
		}
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}
		System.out.println(rezultat);
		
		
		if(rezultat == 1) {
			try {
				///preluam functia utilizatorului logat
				///urmam aceeasi pasi ca si cei la variabila anterioara care chema o procedura in MySQL
				CallableStatement detFunctie = PoliclinicaMVC.connection.prepareCall("{call determinare_functie (?, ?, ?, ?, ?)}");
				detFunctie.setString(1, userName);
				detFunctie.setString(2, password);
				detFunctie.registerOutParameter(3, java.sql.Types.VARCHAR);
				detFunctie.registerOutParameter(4, java.sql.Types.VARCHAR);
				detFunctie.registerOutParameter(5, java.sql.Types.VARCHAR);

				detFunctie.execute();
			
				functie = detFunctie.getString(3);
				numele = detFunctie.getString(4);
				prenumele = detFunctie.getString(5);
	
			
			}
			catch (SQLException ex) {
				System.err.println("SQLException: " + ex);
			}
			System.out.println(functie);
			PoliclinicaMVC.CNP = userName;
			PoliclinicaMVC.numele = numele;
			PoliclinicaMVC.prenumele = prenumele;
			PoliclinicaMVC.functie = functie;
			PoliclinicaMVC.paginaCurenta = functie;  ///navigam la Meniul Principal al functie corespunzatoare afisate
			PoliclinicaMVC.tip = "angajat";
			PoliclinicaMVC.lastView.setVisible(false); ///inchidem pagina de Logare
			PoliclinicaMVC.main(null); //reapelam MAIN-ul - pentru noi reprezentand MVC-ul principal care leaga oricare trio intre ele
		}
		else {
			JOptionPane.showMessageDialog(null, "Logare esuata!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
    }
	
	public void loginAdmin(String userName, String password) {
		String tip = null;
		String numele = null;
		String prenumele = null;
		int rezultat = 0;

		///orice interactiune pe care dorim a o face cu MySQL-ul trebuie integrata intr-un try-catch, altfel vom avea eroare de unhandled
		try {
			///crearea unei variabile ce va apela o procedura din MySQL
			CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call logare (?, ?, ?)}");
			cstmt.setString(1, userName); ///setarea varibilelor de intrarea, deoarece acestea sunt dinamice
			cstmt.setString(2, password);
			cstmt.registerOutParameter(3, java.sql.Types.INTEGER); ///variabila de tip OUT a procedurii

			cstmt.execute(); //executarea propriu-zisa
			
			rezultat = cstmt.getInt(3); //extragerea parametrului de tip OUT
			
			cstmt.close(); ///inchiderea variabilei ce a executat chemarea procedurii
			System.out.println("Succes!"); //mesaj pentru consola <- un Debug mai usor
		}
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}
		System.out.println(rezultat);
		
		
		if(rezultat == 1) {
			///getNume
			try {
				///preluam functia utilizatorului logat
				///urmam aceeasi pasi ca si cei la variabila anterioara care chema o procedura in MySQL
				CallableStatement detFunctie = PoliclinicaMVC.connection.prepareCall("{call determinare_functie (?, ?, ?, ?, ?)}");
				detFunctie.setString(1, userName);
				detFunctie.setString(2, password);
				detFunctie.registerOutParameter(3, java.sql.Types.VARCHAR);
				detFunctie.registerOutParameter(4, java.sql.Types.VARCHAR);
				detFunctie.registerOutParameter(5, java.sql.Types.VARCHAR);

				detFunctie.execute();
			
				numele = detFunctie.getString(4);
				prenumele = detFunctie.getString(5);
	
			
			}
			catch (SQLException ex) {
				System.err.println("SQLException: " + ex);
			}
			
			///getTip
			try {
				String queryStr = "SELECT tip FROM utilizatori WHERE CNP = " + userName;
				Statement stmt = PoliclinicaMVC.connection.createStatement();
				ResultSet rs = stmt.executeQuery(queryStr);
				
				while(rs.next()) {
					tip = rs.getString("tip");
				}
	
			
			}
			catch (SQLException ex) {
				System.err.println("SQLException: " + ex);
			}
			PoliclinicaMVC.CNP = userName;
			PoliclinicaMVC.numele = numele;
			PoliclinicaMVC.prenumele = prenumele;
			if(tip.equals("administrator") || tip.equals("super-administrator")) {
				PoliclinicaMVC.paginaCurenta = "admin";  ///navigam la Meniul Principal al functie corespunzatoare afisate
				PoliclinicaMVC.tip = tip;
				PoliclinicaMVC.functie = tip;
				PoliclinicaMVC.lastView.setVisible(false); ///inchidem pagina de Logare
				PoliclinicaMVC.main(null);
			} else	{
				JOptionPane.showMessageDialog(null, "Logare esuata!", "Error", JOptionPane.ERROR_MESSAGE);
			}
				 //reapelam MAIN-ul - pentru noi reprezentand MVC-ul principal care leaga oricare trio intre ele
		}
		else {
			JOptionPane.showMessageDialog(null, "Logare esuata!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
    }
}
