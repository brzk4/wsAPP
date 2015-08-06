package ordering_package;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import static_structures.Names;

@SuppressWarnings("serial")
public class OperationalPanel extends JPanel {

	private JTextField[] tf_tab;
	private JLabel[] lab_tab;
	private Box[] box_tab;

	private int numberOfColumns = 14;

	private JButton addButton;
	private JButton clearButton;
	private JButton delButton;
	private JButton editButton;

	private JPanel top_panel_with_form_and_buttons;
	private Box mainBox;

	private Color bg_color = new Color(90, 143, 179);
	private Font main_font_B;
	private Font main_font_L;

	private JPanel buttons_panel;
	private Box wholeBox;
	private EntryFormController entryForm;
	private List<JButton> buttons = new ArrayList<JButton>();

	public OperationalPanel() {

		buttons_panel_init();
		panel_and_form_init();
		graphics_settings();
		panels_ordering();

		initColumns();
	}

	private void panels_ordering() {
		mainBox = Box.createHorizontalBox();
		top_panel_with_form_and_buttons.add(entryForm);
	}

	private void graphics_settings() {
		fonts_init();
		vertical_organize();

		setColors();
		setTopFrameBorder();
	}

	private void panel_and_form_init() {
		top_panel_with_form_and_buttons = new JPanel();
		entryForm = new EntryFormController(this);
	}

	private void vertical_organize() {
		wholeBox = Box.createVerticalBox();
		wholeBox.add(top_panel_with_form_and_buttons);
		wholeBox.add(buttons_panel);
		this.add(wholeBox);
	}

	private void setColors() {
		top_panel_with_form_and_buttons.setBackground(bg_color);
		set_background_color();
		entryForm.setBGcolor(bg_color);
	}

	private void set_background_color() {
		this.setBackground(bg_color);
	}

	public List<JButton> get_list_of_buttons() {
		return buttons;
	}

	public JButton retClearBut() {
		return clearButton;
	}

	public JButton retAddBut() {
		return addButton;
	}

	public JButton retDelBut() {
		return delButton;
	}

	private void buttons_panel_init() {
		buttons_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttons_panel.setBackground(bg_color);

		set_buttons_names();
		add_buttons_to_panel();
		list_of_buttons_init();
	}

	private void set_buttons_names() {
		addButton = new JButton(Names.add_btn);
		clearButton = new JButton(Names.clear_btn);
		delButton = new JButton(Names.del_btn);
		editButton = new JButton(Names.edit_btn);
	}

	private void add_buttons_to_panel() {
		buttons_panel.add(delButton);
		buttons_panel.add(editButton);
		buttons_panel.add(clearButton);
		buttons_panel.add(addButton);
	}

	private void list_of_buttons_init() {
		buttons.add(addButton);
		buttons.add(clearButton);
		buttons.add(delButton);
		buttons.add(editButton);
	}

	private void fonts_init() {
		main_font_B = new Font("Verdana", Font.BOLD, 14);
		main_font_L = new Font("Verdana", Font.BOLD, 9);
	}

	private void setTopFrameBorder() {
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Zlecenie");
		title.setTitleColor(Color.white);
		title.setTitleFont(main_font_B);
		top_panel_with_form_and_buttons.setBorder(title);
	}

	private void initColumns() {

		boxListInit();
		textFieldListInit();
		labelListInit();

		for (int i = 0; i < box_tab.length; i++) {

			box_tab[i].add(lab_tab[i]);
			box_tab[i].add(tf_tab[i]);
			box_tab[i].add(tf_tab[i + numberOfColumns]);
			box_tab[i].add(tf_tab[i + numberOfColumns * 2]);

		}

		setRowInvisible();

		for (int i = 0; i < box_tab.length; i++) {
			mainBox.add(box_tab[i]);
		}

	}

	void setRowInvisible() {
		for (int i = 0; i < numberOfColumns * 3; i++) {
			if ((i != 9 & i != 11 & i != 23 & i != 25 & i != 37 & i != 39) & (i > 27 | i < 14)) {

				tf_tab[i].setEditable(false);
				tf_tab[i].setBackground(bg_color);
				tf_tab[i].setBorder(null);

			}
		}
	}

	private void labelListInit() {

		lab_tab = new JLabel[numberOfColumns];

		for (int i = 0; i < lab_tab.length; i++) {
			lab_tab[i] = new JLabel();
			lab_tab[i].setFont(main_font_L);
			lab_tab[i].setForeground(Color.white);

		}

		lab_tab[0].setText("Nr zlecenia");
		lab_tab[1].setText("Zleceniodawca");
		lab_tab[2].setText("Referencje");
		lab_tab[3].setText("Towar");
		lab_tab[4].setText("Przewo\u017Anik");
		lab_tab[5].setText("Spedytor");
		lab_tab[6].setText("Nr pojazdu");
		lab_tab[7].setText("Kierowca");
		lab_tab[8].setText("Miejsce za\u0142adunku");
		lab_tab[9].setText("G za\u0142/wja/wyj");
		lab_tab[10].setText("M roz\u0142adunku");
		lab_tab[11].setText("G roz\u0142/wja/wyj");
		lab_tab[12].setText("Odebra\u0142");
		lab_tab[13].setText("Uwagi");

	}

	private void textFieldListInit() {

		tf_tab = new JTextField[numberOfColumns * 3];

		for (int i = 0; i < tf_tab.length; i++) {
			tf_tab[i] = new JTextField();
			tf_tab[i].setBorder(BorderFactory.createLineBorder(bg_color));
			tf_tab[i].setPreferredSize(new Dimension(50, 20));

		}

		tf_tab[11].addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
				JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");

				timeSpinner.setEditor(timeEditor);
				timeSpinner.setValue(new Date()); // will only show the current
													// time

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void boxListInit() {

		box_tab = new Box[numberOfColumns];

		for (int i = 0; i < box_tab.length; i++) {
			box_tab[i] = Box.createVerticalBox();
		}

	}

	public void clearAll() {
		for (int i = 0; i < tf_tab.length; i++) {
			tf_tab[i].setText("");
		}
	}

	public String[] getFieldsAsStringTab() {

		String[] fieldsToStringTab = new String[18];
		for (int i = 0; i < fieldsToStringTab.length; i++) {
			fieldsToStringTab[i] = new String();
		}

		fieldsToStringTab[0] = tf_tab[14].getText();
		fieldsToStringTab[1] = tf_tab[15].getText();
		fieldsToStringTab[2] = tf_tab[16].getText();
		fieldsToStringTab[3] = tf_tab[17].getText();
		fieldsToStringTab[4] = tf_tab[18].getText();
		fieldsToStringTab[5] = tf_tab[19].getText();
		fieldsToStringTab[6] = tf_tab[20].getText();
		fieldsToStringTab[7] = tf_tab[21].getText();
		fieldsToStringTab[8] = tf_tab[22].getText();

		fieldsToStringTab[9] = tf_tab[9].getText();
		fieldsToStringTab[10] = tf_tab[23].getText();
		fieldsToStringTab[11] = tf_tab[37].getText();

		fieldsToStringTab[12] = tf_tab[24].getText();

		fieldsToStringTab[13] = tf_tab[11].getText();
		fieldsToStringTab[14] = tf_tab[25].getText();
		fieldsToStringTab[15] = tf_tab[39].getText();

		fieldsToStringTab[16] = tf_tab[26].getText();
		fieldsToStringTab[17] = tf_tab[27].getText();

		return fieldsToStringTab;
	}

	public JButton retEditBut() {
		return editButton;
	}

	public void setFieldsFromDB() {

	}

}

/**
 * POLSKIE ZNAKI: ę \u0119 ó \u00F3 ą \u0105 ś \u015B ł \u0142 ż \u017C ź \u017A
 * ć \u0107
 * 
 */
