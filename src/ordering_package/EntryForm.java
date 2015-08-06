package ordering_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class EntryForm extends JPanel {

	protected JLabel lblZlecenie;
	protected JLabel lblZlecenieKlienta;
	protected JLabel lblZleceniodawca;
	protected JLabel lblReferencje;
	protected JLabel lblPrzewonik;
	protected JLabel lblPojazd;
	protected JLabel lblUwagi;
	protected JLabel lblZaadunek;
	protected JLabel lblRozadunek;
	protected JLabel lblZawjawyj;
	protected JLabel lblRozwjawyj;

	protected JTextField order;
	protected JTextField order_customer;
	protected JComboBox<String> customer;
	protected JTextField reference;
	protected JComboBox<String> transporter;
	protected JComboBox<String> car;
	protected JTextField points;
	protected JTextField shipment;
	protected JTextField discharge;
	protected JTextField ship_time;
	protected JTextField ship_in;
	protected JTextField ship_out;
	protected JTextField dis_time;
	protected JTextField dis_in;
	protected JTextField dis_out;

	protected List<Object> fields = new ArrayList<Object>();

	private JPanel panel;

	public EntryForm() {
		init_panel_and_add_to_this();

		init_labels();
		init_fields();

		add_fields_to_panel();

		init_list();

		set_comboBoxes_editable();
		
	}

	private void set_comboBoxes_editable() {
		customer.setEditable(true);
		car.setEditable(true);
		transporter.setEditable(true);
	}

	public List<Object> get_list_of_fields() {
		return fields;
	}

	private void init_list() {

		fields.add(order); 
		fields.add(order_customer);
		fields.add(customer);
		fields.add(reference);
		fields.add(transporter);
		fields.add(car);
		fields.add(points);
		fields.add(shipment);
		fields.add(discharge);
		fields.add(ship_time);
		fields.add(ship_in);
		fields.add(ship_out);
		fields.add(dis_time);
		fields.add(dis_in);
		fields.add(dis_out);
 

	}

	public void setBGcolor(Color color) {
		panel.setBackground(color);
		this.setBackground(color);
	}

	private void add_fields_to_panel() {
		panel.add(order, "cell 0 2,growx");
		order.setColumns(10);

		panel.add(order_customer, "cell 1 2,growx");
		order_customer.setColumns(10);

		panel.add(customer, "cell 2 2,growx");

		panel.add(reference, "cell 3 2,growx");
		reference.setColumns(10);

		panel.add(transporter, "cell 4 2,growx");

		panel.add(car, "cell 5 2,growx");

		panel.add(points, "cell 6 2,growx");
		points.setColumns(10);

		panel.add(shipment, "cell 7 2,growx");
		shipment.setColumns(10);

		panel.add(discharge, "cell 8 2,growx");
		discharge.setColumns(10);

		panel.add(ship_time, "cell 9 1,growx");
		ship_time.setColumns(10);

		panel.add(ship_in, "cell 9 2,growx");
		ship_in.setColumns(10);

		panel.add(ship_out, "cell 9 3,growx");
		ship_out.setColumns(10);

		panel.add(dis_time, "cell 10 1,growx");
		dis_time.setColumns(10);

		panel.add(dis_in, "cell 10 2,growx");
		dis_in.setColumns(10);

		panel.add(dis_out, "cell 10 3,growx");
		dis_out.setColumns(10);
	}

	private void init_labels() {
		init_labels_and_set_them_name();
		add_labels_to_panel();
	}

	private void init_fields() {
		order = new JTextField();
		order_customer = new JTextField();
		customer = new JComboBox<String>();
 
 		reference = new JTextField();
		transporter = new JComboBox<String>();
		car = new JComboBox<String>();
		points = new JTextField();
		shipment = new JTextField();
		discharge = new JTextField();
		ship_time = new JTextField();
		ship_in = new JTextField();
		ship_out = new JTextField();
		dis_time = new JTextField();
		dis_in = new JTextField();
		dis_out = new JTextField();
		
		
	}
	
	protected void set_fields_clear(){
		order.setText("");
		order_customer.setText("");
		customer.getEditor().setItem("");
		customer.setSelectedItem((String)"");
		reference.setText("");
		transporter.getEditor().setItem("");
		transporter.setSelectedItem((String)"");
		car.getEditor().setItem("");
		car.setSelectedItem((String)"");
		points.setText("");
		shipment.setText("");
		discharge.setText("");
		ship_time.setText("");
		ship_in.setText("");
		ship_out.setText("");
		dis_time.setText("");
		dis_in.setText("");
		dis_out.setText("");
	}

	private void add_labels_to_panel() {
		panel.add(lblZlecenie, "cell 0 0");
		panel.add(lblZlecenieKlienta, "cell 1 0");
		panel.add(lblZleceniodawca, "cell 2 0");
		panel.add(lblReferencje, "cell 3 0");
		panel.add(lblPrzewonik, "cell 4 0");
		panel.add(lblPojazd, "cell 5 0");
		panel.add(lblUwagi, "cell 6 0");
		panel.add(lblZaadunek, "cell 7 0");
		panel.add(lblRozadunek, "cell 8 0");
		panel.add(lblZawjawyj, "cell 9 0");
		panel.add(lblRozwjawyj, "cell 10 0");
	}

	private void init_labels_and_set_them_name() {
		lblZlecenie = new JLabel("Zlecenie ");
		lblZlecenieKlienta = new JLabel("Zlecenie klienta");
		lblZleceniodawca = new JLabel("Zleceniodawca");
		lblReferencje = new JLabel("Referencje");
		lblPrzewonik = new JLabel("Przewo\u017Anik");
		lblPojazd = new JLabel("Pojazd");
		lblUwagi = new JLabel("Uwagi");
		lblZaadunek = new JLabel("Za\u0142adunek");
		lblRozadunek = new JLabel("Roz\u0142adunek");
		lblZawjawyj = new JLabel("za\u0142/wja/wyj");
		lblRozwjawyj = new JLabel("roz/wja/wyj");
	}

	private void init_panel_and_add_to_this() {
		panel = new JPanel();
		this.add(panel);
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("",
				"[grow][grow][100.00,grow][grow][grow][grow][grow][grow][grow][grow][75.00,grow]", "[][][][]"));
	}

}
