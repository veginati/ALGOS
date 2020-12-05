package system.design;

import java.util.HashMap;

public class TinyUrl {

    static HashMap<Integer,String> urlHashCode = new HashMap<Integer,String>();
    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        Integer code = longUrl.hashCode();
        urlHashCode.put(code, longUrl);
        return code.toString();
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return urlHashCode.get(Integer.valueOf(shortUrl));
    }

    public static void main(String[] args) {

        String code = encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(decode(code).equals("https://leetcode.com/problems/design-tinyurl"));
    }
}
