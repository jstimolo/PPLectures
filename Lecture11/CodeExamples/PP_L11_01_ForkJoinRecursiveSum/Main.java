import java.util.concurrent.ForkJoinPool;

public class Main {

	private static final ForkJoinPool fjPool = new ForkJoinPool(4);
	
	public static void main(String[] args) throws Exception {
		
	  System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
	  	  
	  int[] myIntArray = new int[8];
	  for(int i=0; i<myIntArray.length; i++)
		  myIntArray[i] = 1;
	  
	  int sum = sum(myIntArray);	  
	  System.out.println("sum: " + sum);
	}

	public static int sum(int[] arr) throws InterruptedException {
		return fjPool.invoke(new ForkJoinRecursiveSum(arr, 0, arr.length));
	}
	
}
