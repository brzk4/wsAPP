package main_pack;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * 
 * LOGIKA PROGRAMU
 * 
 */
public class Model {

	private String nr_zlecenia;
	private String zleceniodawca;
	private String referencje;
	private String towar;
	private String przewoznik;
	private String spedytor;
	private String nr_pojazdu;
	private String kierowca;
	private String miejsce_zaladunku;
	private String godz_zaladunku;
	private String zal_godz_wjazdu;
	private String zal_godz_wyjazdu;
	private String miejsce_rozladunku;
	private String godz_rozladunku;
	private String rozl_godz_wjazdu;
	private String rozl_godz_wyjazdu;
	private String odebral;
	private String uwagi;

	private Controller controllerOBJ;

	Model() {

	}

	/**
	 * 
	 * MECHANIZM DZIA£ANIA FORMULARZA ZLECEÑ
	 */

	public void executeAddButton(String[] fieldsAsStringTab) {

		/**
		 * SCHEMAT PO KRÓTCE:
		 * 
		 * 9 13 0 1 2 3 4 5 6 7 8 10 12 14 16 17 11 15
		 */

		initStrings(fieldsAsStringTab);

		addAll();

	}

	private void addAll() {

		try {
			int nr_zlec = Integer.parseInt(nr_zlecenia);

			if (nr_zlec > 0) {
				System.out.println("ds");

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String c_time = dateFormat.format(cal.getTime());

				String query1 = "insert into dane VALUES ('" + nr_zlecenia + "', '" + zleceniodawca + "', '"
						+ referencje + "', '" + towar + "', '" + przewoznik + "', '" + spedytor + "', '" + nr_pojazdu
						+ "', '" + kierowca + "', '" + miejsce_zaladunku + "', '" + godz_zaladunku + "', '"
						+ zal_godz_wjazdu + "', '" + zal_godz_wyjazdu + "', '" + miejsce_rozladunku + "', '"
						+ godz_rozladunku + "', '" + rozl_godz_wjazdu + "', '" + rozl_godz_wyjazdu + "', '" + odebral
						+ "', '" + uwagi + "', '" + "ktos" + "',+ '" + c_time + "')";

				execQueryAndUpdateMainTable(query1);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nr zlecenia musi byæ liczb¹");
		}

	}

	private void execQueryAndUpdateMainTable(String query1) {
		try {

			Statement stmt = DB_connector.conn.createStatement();
			stmt.executeUpdate(query1);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "B³¹d bazy danych lub powtórzenie numeru zlecenia");
		}

		// odswiez tabele po wstawieniu rekordu
		controllerOBJ.updateMainTab();
	}

	private void initStrings(String[] fieldsAsStringTab) {

		for (int i = 0; i < fieldsAsStringTab.length; i++) {
			if (fieldsAsStringTab[i] == null)
				fieldsAsStringTab[i] = "";
		}

		nr_zlecenia = fieldsAsStringTab[0];
		zleceniodawca = fieldsAsStringTab[1];
		referencje = fieldsAsStringTab[2];
		towar = fieldsAsStringTab[3];
		przewoznik = fieldsAsStringTab[4];
		spedytor = fieldsAsStringTab[5];
		nr_pojazdu = fieldsAsStringTab[6];
		kierowca = fieldsAsStringTab[7];
		miejsce_zaladunku = fieldsAsStringTab[8];
		godz_zaladunku = fieldsAsStringTab[9];
		zal_godz_wjazdu = fieldsAsStringTab[10];
		zal_godz_wyjazdu = fieldsAsStringTab[11];
		miejsce_rozladunku = fieldsAsStringTab[12];
		godz_rozladunku = fieldsAsStringTab[13];
		rozl_godz_wjazdu = fieldsAsStringTab[14];
		rozl_godz_wyjazdu = fieldsAsStringTab[15];
		odebral = fieldsAsStringTab[16];
		uwagi = fieldsAsStringTab[17];

	}

	public void getControllerRef(Controller cont) {
		controllerOBJ = cont;
	}

	public void delRowInMainDB(String[] fieldsAsStringTab) {
		initStrings(fieldsAsStringTab);
		String queryUsun = "DELETE FROM dane WHERE nr_zlec = " + nr_zlecenia;
		System.out.println(queryUsun);
		execQueryAndUpdateMainTable(queryUsun);

	}

	public void editRowInMainDB(String[] fieldsAsStringTab) {
		initStrings(fieldsAsStringTab);
		
		/// jakos zrobic zeby wczytalo wiesz o podanym numerze i potem mozna bylo je podmienic
		
		
	}

}
