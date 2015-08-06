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

import ordering_package.EntryFormController;

public class DB_mainTable {

	public static final DB_mainTable INSTANCE = new DB_mainTable();

	private JScrollPane sp1;
	private JTable mainTab;
	
	
	/**
	 * MAKE SURE CLASS IS SINGLETON
	 */
	@SuppressWarnings("serial")
	private DB_mainTable() {
		mainTab = new JTable(){
			   @Override
			    public boolean isCellEditable(int row, int column) {
			       return false;
			    }
		};
		double_click_listener_init();
	}
	

	/**
	 * RETURN INSTANCE OF CLASS DB_dates
	 */
	public static DB_mainTable getInstance() {
		return INSTANCE;
	}

	public void initConnection(JScrollPane s) {

		sp1 = s;
		connectToMainDB();

		sp1.setPreferredSize(new Dimension(1000, 400));
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

			 
			Statement stmt = DB_connector.getInstance().ret_connection().createStatement();
			stmt.executeQuery("SELECT * FROM dane ORDER BY order_wt DESC");
			ResultSet rs = stmt.getResultSet();
			mainTab.setModel(DbUtils.resultSetToTableModel(rs));
		 

		} catch (SQLException c) {
			JOptionPane.showMessageDialog(null, "Nie mozna pobraæ danych");
			System.exit(0);
			c.printStackTrace();
		}

	}
	
	private void double_click_listener_init() {
		mainTab.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table = (JTable) me.getSource();
				
				Point p = me.getPoint();
				int row = table.rowAtPoint(p);
				if (me.getClickCount() == 2) {

					EntryFormController.getInstance().edit_action_matching(row,table);

				}
			}


		});
	}
	
 


	public void get_row_of_this_id(int id_order) {
		try {

			 
			Statement stmt = DB_connector.getInstance().ret_connection().createStatement();
			stmt.executeQuery("SELECT * FROM dane WHERE id_wt = '" + id_order + "'");
			
			 
			
			ResultSet rs = stmt.getResultSet();
			mainTab.setModel(DbUtils.resultSetToTableModel(rs));
		 

		} catch (SQLException c) {
			JOptionPane.showMessageDialog(null, "Nie mozna pobraæ danych");
			System.exit(0);
			c.printStackTrace();
		}
		
	}

 

}
