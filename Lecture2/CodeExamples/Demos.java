import java.util.Arrays;

public class Demos {
  public static void celsiusToFahrenheit(int celsius) {
    assert -273 <= celsius : "Learn yourself some physics!";

    System.out.print(celsius + "°C is ");
    System.out.print(9/5 * celsius + 32); // logic error: 9.0/5.0
    System.out.println("°F");
  }
  
  

  public static void collatz(final int n) {
    assert 0 < n : "Input must be positive";
    System.out.println("Collatz for n="+ n);

    int c = n;

    while (c != 1) {
      c = (c % 2 == 0)
              ? c/2
              : 3*c + 1;
     System.out.print(c + " ");
    }
    System.out.println();
    System.out.println("Terminated!");
  }

  
  
  public static void array_equality() {
	  
	  	int[] a1 = new int[] {1,2,3};
	  	int[] a2 = new int[] {1,2,3};
	  	//int[] a2 = a1;

	  	System.out.println("a1 == a2? " + (a1 == a2));
	    System.out.println("a1.equals(a2)? " + a1.equals(a2));
	    System.out.println("Arrays.equals(a1, a2)? " + Arrays.equals(a1, a2));
	  }
  
  
  
  public static void string_equality() {
	String s1 = "ETH";
	String s2 = "ETH";
	//String s2 = "E" + "TH";
	//String s2 = s1.charAt(0) + "TH";
	  
    System.out.println("s1 == s2? " + (s1 == s2));
    System.out.println("s1.equals(s2)? " + s1.equals(s2));
  }

}


