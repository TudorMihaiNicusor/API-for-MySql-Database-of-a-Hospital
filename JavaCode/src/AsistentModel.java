public class AsistentModel extends ModelGeneric{
	AsistentModel() {
	    
 	}
	
	public void deschidereCompletareRapoarte() {
		PoliclinicaMVC.paginaCurenta = "completare rapoarte";
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

	public void deschidereOrareLunare() {
		PoliclinicaMVC.paginaCurenta = "afisare orare lunare angajati";
		PoliclinicaMVC.main(null);
	}
}
