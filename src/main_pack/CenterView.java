package main_pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
 

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
 
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class CenterView extends JPanel {

	SinglePanel head;
	JPanel bot;

	JButton addButton;
	JButton popButton;
 
	private Color bg_color = new Color(90, 143, 179);
	private Font main_font_B;
	@SuppressWarnings("unused")
	private Font main_font_L;	
	JFrame frame;
	JScrollPane scrollPane;
	JScrollPane scrollPane2;
	 

	public CenterView(JFrame f) {
		 scrollPane = new JScrollPane();
		 scrollPane2 = new JScrollPane();
		frame = f;
 
		init();
		
		
		
		
	}
	
	private void fonts_init() {
		main_font_B = new Font("Verdana", Font.BOLD, 14);
		main_font_L = new Font("Verdana", Font.BOLD, 9);
	}

	private void init() {

		this.setLayout(new BorderLayout(0, 0));

		head = new SinglePanel();
		bot = new JPanel();

		this.add(head, BorderLayout.NORTH);
		this.add(bot, BorderLayout.CENTER);
		
		Box boxBazy = Box.createHorizontalBox();
	 	bot.add(boxBazy);
		
		fonts_init();
		JPanel lewy = left_panel_init();
		JPanel prawy = right_panel_init();
		
		
		lewy.add(scrollPane);
		prawy.add(scrollPane2);
 
		boxBazy.add(lewy);
		boxBazy.add(prawy);
			
		
 

 
		 
		bot.setBackground(bg_color);

	}

	private JPanel left_panel_init() {
		JPanel lewy = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lewy.setBackground(bg_color);
		TitledBorder title1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Dane");
		title1.setTitleColor(Color.white);
		title1.setTitleFont(main_font_B);
		lewy.setBorder(title1);
		return lewy;
	}

	private JPanel right_panel_init() {
		JPanel prawy = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		prawy.setBackground(bg_color);
		TitledBorder title2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Daty");
		title2.setTitleColor(Color.white);
		title2.setTitleFont(main_font_B);
		prawy.setBorder(title2);
		return prawy;
	}

	public JScrollPane getSP_left() {
		return scrollPane;
	}
	
	public JScrollPane getSP_right() {
		return scrollPane2;
	}

}
