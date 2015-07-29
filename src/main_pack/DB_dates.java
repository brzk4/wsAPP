package main_pack;

 
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class DB_dates {

	private JScrollPane sp2;
	private JTable mainTab;
	
	DB_dates() {
		mainTab = new JTable();

	}
	
	public void initConnection(JScrollPane s ) {
		sp2 = s;
		connectToMainDB();

		sp2.setPreferredSize(new Dimension(120,400));
		sp2.setViewportView(mainTab);
		
		//mainTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mainTab.getColumnModel().getColumn(0).setPreferredWidth(100);
 
	 

	}

	public void connectToMainDB() {
		try {

			String query = "SELECT  data FROM dane";
			Statement stmt = DB_connector.conn.createStatement();
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();

			mainTab.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException c) {
			JOptionPane.showMessageDialog(null, "B³¹d danych");
			System.exit(0);
			c.printStackTrace();
		}

	}

}
