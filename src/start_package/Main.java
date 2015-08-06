package start_package;

public class Main {

	/**
	 * MAKE SURE CLASS IS SINGLETON
	 */
	private Main() {
		Start.getReference().start_program();
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		new Main();
	}

}
