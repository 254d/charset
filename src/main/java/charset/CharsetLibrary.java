package charset;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Hex;

public class CharsetLibrary {

  /**
   * 文字列からJEF16進文字列に変換
   *
   * @param string
   * @return JEF16進文字列
   */
  public String string2JexHex(String string) {
    Charset cs = Charset.forName("x-Fujitsu-JEF-ASCII");
    byte[] bytes = string.getBytes(cs);
    return format(Hex.encodeHex(bytes));
  }

  /**
   * JEF16進文字列から文字列に変換
   *
   * @param binary
   * @return 文字列
   */
  public String jefHex2String(String binary) {
    String out = binary.replaceAll("\s", "");
    byte[] buff = new byte[256 * 1000 * 1000];

    int len = 0;
    for (len = 0; len < out.length(); len += 2) {
      StringBuilder sb = new StringBuilder();
      sb.append(out.charAt(len));
      sb.append(out.charAt(len + 1));
      String strByte = sb.toString();
      byte byteCasted = (byte) Integer.parseInt(strByte, 16);
      buff[len / 2] = byteCasted;
    }

    byte[] array = new byte[len / 2];
    System.arraycopy(buff, 0, array, 0, len / 2);

    Charset cs = Charset.forName("x-Fujitsu-JEF-ASCII");
    String str = new String(array, cs);

    return str;
  }

  /**
   * フォーマッタ
   *
   * @param str
   * @return バイト区切り文字列
   */
  private String format(char[] str) {
    int length = str.length;
    String out = "";
    for (int i = 0; i < length; i++) {
      out = out + str[i];
      if (i % 2 != 0) {
        out = out + " ";
      }
    }
    out = out.trim();
    return out;
  }

}

