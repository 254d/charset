package charset;

/**
 * CharsetLibrary呼出しサンプル
 *
 * @author niwase.hiroaki
 * @version 1.0
 */
public class Main {
  /**
   * Mainメソッド
   *
   * @param args 起動パラメータ
   */
  public static void main(String[] args) {
    CharsetLibrary cs = new CharsetLibrary();
    String convStr = "　　㈱　123　　１２３ TEST   こんにちは ABC 髙島屋森鷗外 ①②③";

    // 16進文字列で表示
    System.out.println(cs.string2JexHex(convStr));
    // 16進文字列を再変換
    System.out.println(cs.jefHex2String(cs.string2JexHex(convStr)));
  }
}
