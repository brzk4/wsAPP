package ordering_package;

import javax.swing.JScrollPane;

import dataBase_package.DB_dates;
import dataBase_package.DB_mainTable;

public class Controller {

	private View viewOBJ;
	private CenterView centerViewOBJ;
	private JScrollPane sp1;
	private JScrollPane sp2;

	private DB_mainTable db_mainTableOBJ;
	private DB_dates db_usersOBJ;

	 
	@SuppressWarnings("unused")
	private Model modelOBJ;

	public Controller(View v) {

		modelOBJ = Model.getIntance();
		db_mainTableOBJ = DB_mainTable.getInstance();
		db_usersOBJ = DB_dates.getInstance();

		viewOBJ = v;
		centerViewOBJ = viewOBJ.getCenterViewRef();

		sp1 = centerViewOBJ.getSP_left();
		sp2 = centerViewOBJ.getSP_right();

		updateMainTab();
		db_usersOBJ.initConnection(sp2);

 

	}

 

 

 
 

 
 

	public void updateMainTab() {
		db_mainTableOBJ.initConnection(sp1);
		db_usersOBJ.initConnection(sp2);

	}

	public void clearAllFields() {
		centerViewOBJ.head.clearAll();

	}

 

}
