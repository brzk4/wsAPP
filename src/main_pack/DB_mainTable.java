package main_pack;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable; 

import net.proteanit.sql.DbUtils;

public class DB_mainTable {

	private JScrollPane sp1;
	private JTable mainTab;

	DB_mainTable() {
		mainTab = new JTable();

	}

	public void initConnection(JScrollPane s) {

		sp1 = s;
		connectToMainDB();

		sp1.setPreferredSize(new Dimension(1000,400));
		sp1.setViewportView(mainTab);

		mainTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mainTab.getColumnModel().getColumn(0).setPreferredWidth(10);
		mainTab.getColumnModel().getColumn(1).setPreferredWidth(50);
		mainTab.getColumnModel().getColumn(2).setPreferredWidth(50);
		mainTab.getColumnModel().getColumn(3).setPreferredWidth(50);
		mainTab.getColumnModel().getColumn(4).setPreferredWidth(50);
		mainTab.getColumnModel().getColumn(6).setPreferredWidth(50);
		mainTab.getColumnModel().getColumn(7).setPreferredWidth(50);
		mainTab.getColumnModel().getColumn(8).setPreferredWidth(50);
		mainTab.getColumnModel().getColumn(9).setPreferredWidth(50);
		mainTab.getColumnModel().getColumn(10).setPreferredWidth(50);

	}

	public void connectToMainDB() {
		try {

			String query = "SELECT * FROM dane ORDER BY nr_zlec DESC";
			Statement stmt = DB_connector.conn.createStatement();
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();

			mainTab.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			makeTabNotEditable();
			
			

		} catch (SQLException c) {
			JOptionPane.showMessageDialog(null, "B³¹d danych");
			System.exit(0);
			c.printStackTrace();
		}

	}

	private void makeTabNotEditable() {
 

		mainTab.setEnabled(false);
	}

}
