package lecture10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		int ntasks = 1000;
		ExecutorService exs = Executors.newFixedThreadPool(4);

		for (int i=0; i<ntasks; i++) {
		  HelloTask t = new HelloTask("Hello from task " + i);
		  exs.submit(t);
		}

		exs.shutdown(); // initiate shutdown, does not wait, but can’t submit more tasks

	}

}
