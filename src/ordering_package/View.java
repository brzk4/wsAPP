package ordering_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import start_package.Start;

public class View {

	final JFrame frame = new JFrame("Test");
	private CenterView centerP;
	private JPanel eastP;
	private JPanel westP;
	private JPanel southP;
	private JPanel northP;

	@SuppressWarnings("unused")
	private Color bg_color = new Color(90, 143, 179);
	private Color top_color = new Color(51, 81, 104);

	private String user;

	public View() {

		user = Start.INSTANCE.getUser();
		initialize();

	}

	public void visibleWindow(boolean k) {
		frame.setVisible(k);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// main panels
		centerP = new CenterView(frame);
		eastP = new JPanel();
		westP = new JPanel();
		southP = new JPanel();
		northP = new JPanel();

		// add panels to frame
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(centerP, BorderLayout.CENTER);
		frame.getContentPane().add(eastP, BorderLayout.EAST);
		frame.getContentPane().add(westP, BorderLayout.WEST);
		frame.getContentPane().add(southP, BorderLayout.SOUTH);
		frame.getContentPane().add(northP, BorderLayout.NORTH);

		// delMe
		north_panel_init();

		southP.add(new JLabel("Connected"));
		southP.setBackground(top_color);

		// frame init
		frame.pack(); // Setting JFrame size. This will only take required space
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true); // Making JFrame Visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		topMenu_init();

	}

	private void north_panel_init() {

		JPanel leftTOP = new JPanel();
		JPanel rightTOP = new JPanel();

		northP.setLayout(new BorderLayout(0, 0));
		northP.add(leftTOP, BorderLayout.WEST);
		northP.add(rightTOP, BorderLayout.EAST);

		northP.setBackground(top_color);
		leftTOP.setBackground(top_color);
		rightTOP.setBackground(top_color);

		northP.setPreferredSize(new Dimension(frame.getWidth(), 100));

		// northP.setLayout(new BoxLayout(northP, BoxLayout.X_AXIS));
 

		JLabel title = new JLabel("WOLSPED TRANS - ZLECENIA");
		leftTOP.add(title);
		title.setFont(new Font("Verdana", Font.BOLD, 45));
		title.setForeground(Color.white);

		JLabel login = new JLabel("Zalogowany, " + user);
		login.setFont(new Font("Verdana", Font.BOLD, 14));
		login.setForeground(Color.white);
		rightTOP.add(login);
		login.setAlignmentX(Component.RIGHT_ALIGNMENT);

	}

	private void topMenu_init() {

		JMenuBar menuBar = new JMenuBar();

		JMenu file_bar = new JMenu("Plik");
		JMenuItem clear_item = new JMenuItem("Wyczysc");
		JMenuItem exit_item = new JMenuItem("Wyjdz");

		JMenu edit_bar = new JMenu("Edycja");

		JMenu help_bar = new JMenu("Pomoc");

		frame.setJMenuBar(menuBar);

		menuBar.add(file_bar);
		menuBar.add(edit_bar);
		menuBar.add(help_bar);

		file_bar.add(clear_item);
		file_bar.add(exit_item);
	}

	public CenterView getCenterViewRef() {
		return centerP;
	}

}