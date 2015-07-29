package main_pack;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * Log in - start   / //  
		 */
		
  	LogIn loginWin = new LogIn();
		loginWin.RunWindow();

		while (!LogIn.flag) {
			System.out.println("");
		}

		String loggedUser = loginWin.close();
		System.out.println(loggedUser);
 
		
		
		/**
		 * Log in - end
		 */
		
		
	

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					
					Model modelOBJ  = new Model();
					View viewOBJ = new View();
					Controller controllerOBJ = new Controller(viewOBJ, modelOBJ);
					
					modelOBJ.getControllerRef(controllerOBJ);
					
					viewOBJ.visibleWindow(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
