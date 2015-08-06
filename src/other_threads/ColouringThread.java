package other_threads;
 

public class ColouringThread extends Thread {
 

    public void run() {
    	infinitive_loop();
    }

	private void infinitive_loop() {
		while(true){
    	wait_sec(10);
    	// sprwadzaj stan zlecenia i koloruj na okrslony kolor
    	
    	
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