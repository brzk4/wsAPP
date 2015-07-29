package main_pack;

import java.awt.EventQueue;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class LogIn {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private JButton btnZalogujSi;
	private JLabel lblLogowanie;
	public static boolean flag;
	public static JLabel lblPoczonoZBaz;
	public Color bg_color = new Color(90, 143, 179);

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public void RunWindow() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					DB_connector.dbConnection();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String close() {
		frame.setVisible(false);
		return textField.getText();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Ekran logowania");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(bg_color);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		textField = new JTextField("kuba");
		sl_panel.putConstraint(SpringLayout.WEST, textField, 205, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -109, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField("raz");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 142, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -10, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 205, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblUytkownik = new JLabel("U\u017Cytkownik");
		lblUytkownik.setForeground(Color.WHITE);
		lblUytkownik.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_panel.putConstraint(SpringLayout.NORTH, lblUytkownik, 3, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, lblUytkownik, -46, SpringLayout.WEST, textField);
		panel.add(lblUytkownik);

		JLabel lblHaso = new JLabel("Has\u0142o");
		lblHaso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHaso.setForeground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, lblHaso, 3, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblHaso, 0, SpringLayout.WEST, lblUytkownik);
		panel.add(lblHaso);

		/**
		 * LOGIN BUTTON HANDLER START
		 */

		btnZalogujSi = new JButton("Zaloguj si\u0119");
		btnZalogujSi.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				String sql = "SELECT nazwa, mail FROM mainTab";

				try {
					Statement stmt = DB_connector.conn.createStatement();
					stmt.executeQuery(sql);
					ResultSet rs = stmt.getResultSet();

					while (rs.next()) {
						String db_username = rs.getString("nazwa");
						String db_password = rs.getString("mail");
						// check null's also
						if (db_username.equals(textField.getText()) && db_password.equals(textField_1.getText())) {
							 flag = true;

						}

					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		});

		/**
		 * LOGIN BUTTON HANDLER END
		 */

		sl_panel.putConstraint(SpringLayout.NORTH, btnZalogujSi, 21, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnZalogujSi, 0, SpringLayout.EAST, textField);
		panel.add(btnZalogujSi);

		lblLogowanie = new JLabel("Logowanie");
		lblLogowanie.setForeground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.WEST, lblLogowanie, 51, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblLogowanie, -30, SpringLayout.NORTH, textField);
		lblLogowanie.setFont(new Font("Tahoma", Font.BOLD, 36));
		panel.add(lblLogowanie);
		
		lblPoczonoZBaz = new JLabel("Brak po\u0142\u0105czenia z baz\u0105 danych");
		sl_panel.putConstraint(SpringLayout.WEST, lblPoczonoZBaz, 158, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPoczonoZBaz, -10, SpringLayout.SOUTH, panel);
		lblPoczonoZBaz.setForeground(Color.WHITE);
		panel.add(lblPoczonoZBaz);
	}
}
