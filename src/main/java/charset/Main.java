package charset;

public class Main {
  public static void main(String[] args) {
    CharsetLibrary cs = new CharsetLibrary();
    String convStr = "　　㈱　123　　１２３ TEST   こんにちは ABC 髙島屋森鷗外 ①②③";
    System.out.println(cs.string2JexHex(convStr));
    System.out.println(cs.jefHex2String(cs.string2JexHex(convStr)));
  }
}
