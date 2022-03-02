public class ExpertModel extends ModelGeneric{

	ExpertModel(){
	}
	
	public void deschidereVizSalarii() {
		PoliclinicaMVC.paginaCurenta = "vizualizare salariu angajat";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereOrare() {
		PoliclinicaMVC.paginaCurenta = "afisare orare angajati";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereConcedi() {
		PoliclinicaMVC.paginaCurenta = "afisare concedii angajati";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereProfitPoliclinici() {
		PoliclinicaMVC.paginaCurenta = "vizualizare profit policlinici";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereProfitSpecialitati() {
		PoliclinicaMVC.paginaCurenta = "vizualizare profit specialitati";
		PoliclinicaMVC.main(null);
	}
	
	public void deschidereProfitMedici() {
		PoliclinicaMVC.paginaCurenta = "vizualizare profit medici";
		PoliclinicaMVC.main(null);
	}
	
	public void logOut() {
		System.out.println("I'm out!");
		PoliclinicaMVC.paginaCurenta = "Login";
		PoliclinicaMVC.lastView.setVisible(false);
		PoliclinicaMVC.main(null);
 	}

	public void deschidereOrareLunare() {
		PoliclinicaMVC.paginaCurenta = "afisare orare lunare angajati";
		PoliclinicaMVC.main(null);
	}
}	
