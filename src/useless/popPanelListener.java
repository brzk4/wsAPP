/*package useless;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import main_pack.CenterView;

public class popPanelListener {

	public popPanelListener(CenterView centerPanel) {

		centerPanel.popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {

						if (centerPanel.panelsList.size() > 1) {
							centerPanel.remove(centerPanel.panelsList.get(centerPanel.panelsList.size() - 1));
							centerPanel.panelsList.remove(centerPanel.panelsList.size() - 1);

							centerPanel.frame.validate();
							centerPanel.frame.repaint();
						}
					}
				});
			}
		});

	}
}*/