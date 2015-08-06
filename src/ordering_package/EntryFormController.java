package ordering_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import start_package.Start;
import static_structures.Queries;

@SuppressWarnings("serial")
public class EntryFormController extends EntryForm {

	private static EntryFormController INSTANCE;

	private String add_query = "";

	public EntryFormController(OperationalPanel operationalPanel) {
		INSTANCE = this;
		start_cooperation_with_buttons(operationalPanel);

		set_fields_clear();
	}

	public static EntryFormController getInstance() {
		return INSTANCE;
	}

	private void start_cooperation_with_buttons(OperationalPanel operationalPanel) {

		add_listener_to_delete_button(operationalPanel);
		add_listener_to_edit_button(operationalPanel);
		add_listener_to_clear_button(operationalPanel);
		add_listener_to_add_button(operationalPanel);

	}

	private void add_listener_to_add_button(OperationalPanel operationalPanel) {
		operationalPanel.get_list_of_buttons().get(0).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				add_action();
			}
		});
	}

	private void add_listener_to_clear_button(OperationalPanel operationalPanel) {
		operationalPanel.get_list_of_buttons().get(1).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				clear_action();
			}
		});
	}

	private void add_listener_to_edit_button(OperationalPanel operationalPanel) {
		operationalPanel.get_list_of_buttons().get(3).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				edit_action();
			}
		});
	}

	private void add_listener_to_delete_button(OperationalPanel operationalPanel) {
		operationalPanel.get_list_of_buttons().get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					delete_action();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	protected void add_action() {

		System.out.println(Queries.insert_one_row_into_main_table);

		try {

			// if order number > 0
			if (Integer.parseInt(order.getText()) > 0) {

				prepare_query_adding_one_row();

				execute_query();

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Nr zlecenia musi byæ liczb¹");
		}

	}

	private void execute_query() throws SQLException {
		Model.getIntance().execQueryAndUpdateMainTable(add_query);
	}

	private void prepare_query_adding_one_row() {

		String c_time = prepare_curent_date_and_time();
		String date = prepare_curent_date();

		String start_query = "insert into dane VALUES (' ";
		String c = "', '"; // comma between values in query
		String end_query = "')";

		String c1 = order.getText();
		String c2 = order_customer.getText();
		String c3 = "";
		String c4 = reference.getText();
		String c5 = "";
		String c6 = "";
		String c7 = points.getText();
		String c8 = shipment.getText();
		String c9 = discharge.getText();
		String c10 = ship_time.getText();
		String c11 = ship_in.getText();
		String c12 = ship_out.getText();
		String c13 = dis_time.getText();
		String c14 = dis_in.getText();
		String c15 = dis_out.getText();

		try {
			c3 = customer.getSelectedItem().toString();
			c5 = transporter.getSelectedItem().toString();
			c6 = car.getSelectedItem().toString();
		} catch (NullPointerException e) {
			c3 = "";
			c5 = "";
			c6 = "";

		}

		add_query = start_query + c1 + c + c2 + c + c3 + c + c4 + c + c5 + c + c6 + c + c7 + c + c8 + c + c9 + c + c10
				+ c + c11 + c + c12 + c + c13 + c + c14 + c + c15 + c + Start.getReference().getUser() + c + c_time + c
				+ date + end_query;

		System.out.println(add_query);

	}

	private String prepare_curent_date_and_time() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String c_time = dateFormat.format(cal.getTime());
		return c_time;
	}

	private String prepare_curent_date() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String c_time = dateFormat.format(cal.getTime());
		return c_time;
	}

	protected void clear_action() {
		set_fields_clear();
	}

	protected void edit_action() {

		// String order_str = order.getText();
		// int val = Integer.parseInt(order_str);

		// edit_action_matching(val);
		JOptionPane.showMessageDialog(null, "Funkcjonalnosc do usuniecia");
	}

	protected void delete_action() throws SQLException {

		String queryUsun = "DELETE FROM dane WHERE order_wt = " + order.getText();
		System.out.println(queryUsun);
		Model.getIntance().execQueryAndUpdateMainTable(queryUsun);

	}

	public void edit_action_matching(int row, JTable table) {

		order.setText(Integer.toString((int) table.getValueAt(row, 0)));
		order_customer.setText((String) table.getValueAt(row, 1));

		customer.getEditor().setItem((String) table.getValueAt(row, 2));
		customer.setSelectedItem((String) table.getValueAt(row, 2));

		reference.setText((String) table.getValueAt(row, 3));

		transporter.getEditor().setItem((String) table.getValueAt(row, 4));
		transporter.setSelectedItem((String) table.getValueAt(row, 4));
		car.getEditor().setItem((String) table.getValueAt(row, 5));
		car.setSelectedItem((String) table.getValueAt(row, 5));

		points.setText((String) table.getValueAt(row, 6));
		shipment.setText((String) table.getValueAt(row, 7));
		discharge.setText((String) table.getValueAt(row, 8));
		ship_time.setText((String) table.getValueAt(row, 9));
		ship_in.setText((String) table.getValueAt(row, 10));
		ship_out.setText((String) table.getValueAt(row, 11));
		dis_time.setText((String) table.getValueAt(row, 12));
		dis_in.setText((String) table.getValueAt(row, 13));
		dis_out.setText((String) table.getValueAt(row, 14));

	}

	public void overwrite_row() throws SQLException {

		//just delete one row that is currently in order field
		
		delete_action();
		
		
	}

 

}
