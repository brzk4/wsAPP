package other_threads;

import dataBase_package.DB_mainTable;

public class RefreshingThread extends Thread {
 

    public void run() {
    	infinitive_loop();
    }

	private void infinitive_loop() {
		while(true){
    	
    	wait_sec(3);
    	 
    	DB_mainTable.getInstance().connectToMainDB();
    	
    	}
	}

	private void wait_sec(int s) {
		try {
			Thread.sleep(s*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}