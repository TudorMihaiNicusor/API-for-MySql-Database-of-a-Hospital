import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AfisareDateAngajatiModel extends ModelGeneric{
    ///Definim capul Tabelului ce va fi afisat
	String[] columnNames = {"CNP", "nume", "prenume", "adresa", "nr_telefon", "email", "IBAN", "nr_contract", "data_angajarii", "tip", "functie", "salar_neg", "nr_ore", "parola"};

	AfisareDateAngajatiModel(){
	}
	///Functie ce va crea un "Pop up" cu datele returnate prin apasarea butonului si apelarea procedurii corespunzatoare
	public void dateAngajat(String NUME, String PRENUME, String FUNCTIE) {
		JFrame frame1 = new JFrame("Date angajat");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); ///functie de inchidere este de alta, deoarece aceasta prezenta va
        frame1.setLayout(new BorderLayout()); //inchide doar fereastra curenta, pe cand cealalta inchidea total aplicatia

        DefaultTableModel model = new DefaultTableModel(); ///pagina va fi de fapt un tabel

        model.setColumnIdentifiers(columnNames); ///setam capul tabelului
        JTable table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); ///in functie de cate sunt sa isi modifice dimensiunea pentru a
        table.setFillsViewportHeight(true);//incape pe fereastra

        JScrollPane scroll = new JScrollPane(table); ///Adaugam 2 tipuri de scroll - orizontal si vertical
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        String CNP = ""; ///Declaram toate variabilele de care vom avea nevoie sa fie extrase din procedura apelata de variabila
        String nume = "";
        String prenume = "";
        String adresa = "";
        String nr_telefon = "";
        String email = "";
        String IBAN = "";
        String nr_contract = "";
        String data_angajarii = "";
        String tip = "";
        String functie = "";
        String salar_neg = "";
        String nr_ore = "";
        String parola = "";

        try {
        	CallableStatement cstmt = PoliclinicaMVC.connection.prepareCall("{call afisare_date_angajat (?, ?, ?, ?)}");
			cstmt.setString(1, NUME);
			cstmt.setString(2, PRENUME);
			cstmt.setString(3, FUNCTIE);
			cstmt.registerOutParameter(4, java.sql.Types.INTEGER);

			ResultSet rs = cstmt.executeQuery(); ///retinem rezultat transmis de procedura in aceasta variabila pentru a putea parcurge toate
                                                ///tuplele/tabelele afisate

			int rezultat = cstmt.getInt(4);

			System.out.println("Succes!");

            int i = 0;
            ///rs va fi pozitionat inainte de prima linie a primului tabel afisat si prin next() se va duce la urmatoare - acum va merge pe prima
            while (rs.next()) {
                CNP = rs.getString("CNP"); ///extragem pe rand fiecare variabila afisata pe care o dorim
                nume = rs.getString("nume"); ///nu sunt obligatorii toate
                prenume = rs.getString("prenume"); ///aici se manipuleaza dupa preferinta
                adresa = rs.getString("adresa");
                nr_telefon = rs.getString("nr_telefon");
                email = rs.getString("email");
                IBAN = rs.getString("IBAN");
                nr_contract = rs.getString("nr_contract");
                data_angajarii = rs.getString("data_angajarii");
                tip = rs.getString("tip");
                functie = rs.getString("functie");
                salar_neg = rs.getString("salar_neg");
                nr_ore = rs.getString("nr_ore");
                parola = rs.getString("parola");

                ///Completarea propriu-zisa a datelor extrase in tabelul - "pop-up-ul" - afisat Utilizatorului
                model.addRow(new Object[]{CNP, nume, prenume, adresa, nr_telefon, email, IBAN, nr_contract, data_angajarii, tip, functie, salar_neg, nr_ore, parola});
                i++;
            }

            ///Pentru a avea un Debuging mai usor afisam in consola daca nu sau cate linii sau gasite extras prin variabila din Baza de date
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            }
            else {
                System.out.println(i + " Records Found");
            }
            cstmt.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        frame1.add(scroll); ///scrolul vizibil pe fereastra
        frame1.setVisible(true); ///trebuie facuta vizibila fereastra
        frame1.setSize(400, 300); ///dimensiunea ferestrei ce contine tabelul
	}
}
