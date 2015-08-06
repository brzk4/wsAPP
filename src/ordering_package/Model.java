package ordering_package;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import dataBase_package.DB_connector;

/**
 * 
 * LOGIKA PROGRAMU
 * 
 */
public class Model {

	private static Model INSTANCE = new Model();

	private Controller controllerOBJ;

	public static Model getIntance() {
		return INSTANCE;
	}

	public void execQueryAndUpdateMainTable(String query1) throws SQLException {
		try {

			Statement stmt = DB_connector.conn.createStatement();
			stmt.executeUpdate(query1);

		} catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e) {

			show_dialog_yes_no(query1);

		}

		// odswiez tabele po wstawieniu rekordu
		controllerOBJ.updateMainTab();
	}

	private void show_dialog_yes_no(String query1) throws SQLException {
		int opcion = JOptionPane.showConfirmDialog(null, "Chcesz nadpisaæ zlecenie?", "Uwaga!",
				JOptionPane.YES_NO_OPTION);

		if (opcion == 0) { // The ISSUE is here
			EntryFormController.getInstance().overwrite_row();
			execQueryAndUpdateMainTable(query1);
		}  
	}

	public void getControllerRef(Controller cont) {
		controllerOBJ = cont;
	}

}
