package start_package;

import java.awt.EventQueue;

import javax.swing.UIManager;

import ordering_package.Controller;
import ordering_package.Model;
import ordering_package.View;
import other_threads.RefreshingThread;

public class Start {

	public static final Start INSTANCE = new Start();

	public String loggedUser = null;

	private Start() {
	};

	public static Start getReference() {
		return INSTANCE;
	}

	public String getUser() {
		return loggedUser;
	}

	public void start_program() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Log in - start / //
		 */

		LogIn.getReference().RunWindow();

		while (!LogIn.flag) {
			System.out.println("");
		}

		loggedUser = LogIn.getReference().close();

		/**
		 * Log in - end
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {

					 
					View viewOBJ = new View();
					Controller controllerOBJ = new Controller(viewOBJ);

					Model.getIntance().getControllerRef(controllerOBJ);

					viewOBJ.visibleWindow(true);
					
					RefreshingThread t2 = new RefreshingThread();
					t2.start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
