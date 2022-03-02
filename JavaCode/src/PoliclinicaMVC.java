
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.sql.*;

import javax.swing.*;
///Acesta este principalul MVC care, in functie de niste parametrii globali isi schimba componentele
public class PoliclinicaMVC {
    public static String paginaCurenta = "Login"; ///Stringul acesta defineste pagina pe care se afla utilizatorul momentan
    public static ViewGeneric lastView; ///Aces View ne spune ce pagina trebuie sa fie inchisa o data cu trecerea la alta
    public static String CNP = null;
    public static String numele = null;
    public static String prenumele = null;
    public static String functie = null;
    public static String tip = null;
    public static Connection connection = null; ///Parametrul cu care se stabileste conexiunea la Baza de Date

    public static void main(String[] args) {   	
    	
    	ModelGeneric model = null;///Cei 3 parametrii ai MVC-ului pe care ii definim aici si schimbam mai jos in functie de
        ViewGeneric view = null ; ///pagina pe care dorim sa o afisam
    	ControllerGeneric controller = null;

        ///Conexiunea propriu-zisa la Baza de Date proprie - trebuie schimbata doar parola, daca fisierul se afla pe alt PC
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }
        catch (Exception ex) {
            System.err.println("An Exception occured during JDBC Driver loading." +
                    " Details are provided below:");
            ex.printStackTrace(System.err);
        }

    	try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/Policlinici?serverTimezone=UTC&&user=root&password=Nicusor20");
            ///Trebuie doar schimbata parola din Stringul de sus pentru a reusi conexiunea si mai trebuie adaugat fisierul de connector
            ///in libraria Proiectului
    	}
    	catch (SQLException sqlex) {
            System.err.println("An SQL Exception occured. Details are provided below:");
            sqlex.printStackTrace(System.err);
    	}

        ///Aici se face schimbarea propriu-zisa dintre pagini prin schimbare tuturor partilor MVC-ului
    	if(paginaCurenta.equals("Login")) {
        		model     = new PoliclinicaModel();
                view     = new PoliclinicaView(model);
                controller = new PoliclinicaController(model, view);
                view.setLocationRelativeTo(null);
                view.setVisible(true);
        }
    	else if(paginaCurenta.equals("inspector resurse umane")) {
        		model     = new InspectorModel();
                view     = new InspectorView(model);
                controller = new InspectorController(model, view);
                view.setLocationRelativeTo(null);
                view.setVisible(true);
    	}
        else if(paginaCurenta.equals("expert financiar")) {
        	model     = new ExpertModel();
            view     = new ExpertView(model);
            controller = new ExpertController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("receptioner")) {
        	model     = new ReceptionerModel();
            view     = new ReceptionerView(model);
            controller = new ReceptionerController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("asistent medical")) {
        	model     = new AsistentModel();
            view     = new AsistentView(model);
            controller = new AsistentController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("medic")) {
        	model     = new MedicModel();
            view     = new MedicView(model);
            controller = new MedicController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("afisare date angajati")) {
        	model     = new AfisareDateAngajatiModel();
            view     = new AfisareDateAngajatiView(model);
            controller = new AfisareDateAngajatiController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("inregistrare concediu")) {
        	model     = new InregistrareConcediuModel();
            view     = new InregistrareConcediuView(model);
            controller = new InregistrareConcediuController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("afisare orare angajati")) {
        	model     = new AfisareOrareAngajatiModel();
            view     = new AfisareOrareAngajatiView(model);
            controller = new AfisareOrareAngajatiController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("vizualizare salariu angajat")) {
        	model     = new AfisareSalariiAngajatiModel();
            view     = new AfisareSalariiAngajatiView(model);
            controller = new AfisareSalariiAngajatiController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("vizualizare profit specialitati")) {
        	model     = new AfisareProfitSpecialitatiModel();
            view     = new AfisareProfitSpecialitatiView(model);
            controller = new AfisareProfitSpecialitatiController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("vizualizare profit medici")) {
        	model     = new AfisareProfitMediciModel();
            view     = new AfisareProfitMediciView(model);
            controller = new AfisareProfitMediciController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("creare programare")) {
        	model     = new CreareProgramareModel();
            view     = new CreareProgramareView(model);
            controller = new CreareProgramareController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("afisare concedii angajati")) {
        	model     = new AfisareConcediiAngajatiModel();
            view     = new AfisareConcediiAngajatiView(model);
            controller = new AfisareConcediiAngajatiController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("gestionare servicii medic")) {
        	model     = new GestionareServiciiMedicModel();
            view     = new GestionareServiciiMedicView(model);
            controller = new GestionareServiciiMedicController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("completare rapoarte")) {
        	model     = new CompletareRapoarteModel();
            view     = new CompletareRapoarteView(model);
            controller = new CompletareRapoarteController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("completare rapoarte medici")) {
        	model     = new CompletareRapoarteMediciModel();
            view     = new CompletareRapoarteMediciView(model);
            controller = new CompletareRapoarteMediciController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("vizualizare profit policlinici")) {
        	model     = new AfisareProfitPolicliniciModel();
            view     = new AfisareProfitPolicliniciView(model);
            controller = new AfisareProfitPolicliniciController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("admin")) {
        	model     = new AdminModel();
            view     = new AdminView(model);
            controller = new AdminController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("adaugare utilizator")) {
        	model     = new AdaugareUtilizatorModel();
            view     = new AdaugareUtilizatorView(model);
            controller = new AdaugareUtilizatorController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("editare utilizatori")) {
        	model     = new EditareUtilizatoriModel();
            view     = new EditareUtilizatoriView(model);
            controller = new EditareUtilizatoriController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else if(paginaCurenta.equals("afisare orare lunare angajati")) {
        	model     = new AfisareOrareLunareAngajatiModel();
            view     = new AfisareOrareLunareAngajatiView(model);
            controller = new AfisareOrareLunareAngajatiController(model, view);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
    	

        ///dorim sa inchidem doar paginile care nu reprezinta un Menu Principal pentru Utilizaotor
        ///le identificam dupa numele acestora
        if(paginaCurenta.equals("inspector resurse umane") || paginaCurenta.equals("expert financiar") || paginaCurenta.equals("receptioner") || paginaCurenta.equals("asistent medical")
    		  || paginaCurenta.equals("medic") || paginaCurenta.equals("Login") || paginaCurenta.equals("admin")){   
    	  lastView = view; ///actualizarea ultimei pagini deschise utilizatorului
        }
     	
    }
}
