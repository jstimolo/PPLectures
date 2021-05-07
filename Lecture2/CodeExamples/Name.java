
public class Name {
  protected String name = "";

  public Name(String name) {
    assert name != null : "Name may not be null";
    assert name.length() > 2 : "A name must comprise more than two characters, but got: " + name;

    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getLength() {
    return name.length();
  }

  public int foo(int a, int b) {
    if (name != null) {
      return a * name.length() + b;
    } else {
      return 0;
    }
  }
}
