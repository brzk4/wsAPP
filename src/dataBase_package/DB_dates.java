package dataBase_package;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class DB_dates {

	public static final DB_dates INSTANCE = new DB_dates();

	private JScrollPane sp2;
	private JTable mainTab;

	/**
	 * MAKE SURE CLASS IS SINGLETON
	 */

	private DB_dates() {
		table_init();

		double_click_listener_init();
	}

	private void double_click_listener_init() {
		mainTab.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table = (JTable) me.getSource();
				
				Point p = me.getPoint();
				int row = table.rowAtPoint(p);
				if (me.getClickCount() == 2) {

					double_click_action(row,table);

				}
			}


		});
	}
	
	private void double_click_action(int row, JTable table) {

		Sorter.getInstance().sortByDate((String)table.getValueAt(row, 0));
	}
	@SuppressWarnings("serial")
	private void table_init() {
		mainTab = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	/**
	 * RETURN INSTANCE OF CLASS DB_dates
	 */
	public static DB_dates getInstance() {
		return INSTANCE;
	}

	public void initConnection(JScrollPane s) {
		sp2 = s;
		connectToMainDB();

		sp2.setPreferredSize(new Dimension(120, 400));
		sp2.setViewportView(mainTab);

	 
		mainTab.getColumnModel().getColumn(0).setPreferredWidth(100);
		try{
		mainTab.setRowSelectionInterval(0, 0);
		}
		catch(java.lang.IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "IllegalArgumentException - tabela dat");
		}
	}

	public void connectToMainDB() {
		try {

			String query = "SELECT DISTINCT  date FROM dane";
			Statement stmt = DB_connector.getInstance().ret_connection().createStatement();
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			mainTab.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException c) {
			JOptionPane.showMessageDialog(null, "B³¹d danych - dates");
			System.exit(0);
			c.printStackTrace();
		}

	}

}
