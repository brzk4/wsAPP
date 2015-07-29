package main_pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Controller {

	private View viewOBJ;
	private CenterView centerViewOBJ;
	private JScrollPane sp1;
	private JScrollPane sp2;

	private DB_mainTable db_mainTableOBJ;
	private DB_dates db_usersOBJ;

	private JButton clearButton;
	private JButton addButton;
	private JButton delButton;
	private JButton editButton;

	private Model modelOBJ;

	public Controller(View v, Model m) {
		modelOBJ = m;
		db_mainTableOBJ = new DB_mainTable();
		db_usersOBJ = new DB_dates();

		viewOBJ = v;
		centerViewOBJ = viewOBJ.getCenterViewRef();

		sp1 = centerViewOBJ.getSP_left();
		sp2 = centerViewOBJ.getSP_right();

		updateMainTab();
		db_usersOBJ.initConnection(sp2);

		buttonsInit();

	}

	private void buttonsInit() {
		clearButtonInit();
		addButtonInit();
		delButtonInit();
		editButtonInit();
		
	}

	private void editButtonInit() {
		editButton = centerViewOBJ.head.retEditBut();
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editAll();
			}

		
		});
		
	}

	private void clearButtonInit() {
		clearButton = centerViewOBJ.head.retClearBut();
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllFields();
			}
		});
	}

	private void addButtonInit() {
		addButton = centerViewOBJ.head.retAddBut();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRow();
			}
		});
	}

	private void delButtonInit() {
		delButton = centerViewOBJ.head.retDelBut();
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dellRow();

			}

		});
	}

	private void dellRow() {
		modelOBJ.delRowInMainDB(centerViewOBJ.head.getFieldsAsStringTab());

	}
	
	private void editAll() {
		modelOBJ.editRowInMainDB(centerViewOBJ.head.getFieldsAsStringTab());
		
	}

	public void updateMainTab() {
		db_mainTableOBJ.initConnection(sp1);
	}

	public void clearAllFields() {
		centerViewOBJ.head.clearAll();

	}

	public void addRow() {

		// to DO
		// funkcja ma zwrocic tablice stringów z tablicy TextFieldow
		modelOBJ.executeAddButton(centerViewOBJ.head.getFieldsAsStringTab());

	}

}
