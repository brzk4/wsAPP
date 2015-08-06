package dataBase_package;

public class Sorter {

	private static Sorter INSTANCE = new Sorter();
	
	
	public static Sorter getInstance() {
		return INSTANCE;
	}

	public void sortByDate(String date) {
		System.out.println(date);

		
		
	}

}
