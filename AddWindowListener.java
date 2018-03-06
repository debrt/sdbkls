
public interface AddWindowListener {

	void onCancelled();
	
	void onOkButtonClicked(String vorname, String name,
			String klasse, String gebDatum, String strasse,
			String hausNummer, String plz, String ort,
			String beitrittsDatum, String medBesonderheiten,
			String anmerkungen);
	
}
