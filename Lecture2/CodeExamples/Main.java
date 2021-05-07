
public class Main {
  public static void main(String[] args) {
    demo1_bytecode(args);
 //  demo2_errors();
 //  demo3_collatz();
 //  demo4_arrays();
 //  demo5_strings();
  }

  private static void demo1_bytecode(String[] args) {
    assert 1 <= args.length : "Expected at least one argument, but got none";

    Name name = new Name(args[0]);

    System.out.println("Name: " + name.getName());
    System.out.println("Length: " + name.getLength());
    System.out.println("Foo: " + name.foo(2, 5));
  }

  private static void demo2_errors() {
    Demos.celsiusToFahrenheit(35);
  }

  private static void demo3_collatz() {
    Demos.collatz(77);
  }

  private static void demo4_arrays() {
    Demos.array_equality();
  }

  private static void demo5_strings() {
	  Demos.string_equality();
  }
}
