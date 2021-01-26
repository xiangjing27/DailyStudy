package basic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangjing
 * @version : Md5Test, v 0.1 2020-12-18 16:33 xiangjing Exp$
 */
public class Md5Test {

    public static void main(String[] args) {
        List<String> keys = new ArrayList<>();
        keys.add("20201201shop20200");
        keys.add("20201202shop20200");
        keys.add("20201203shop20200");
        keys.add("20201204shop20200");
        keys.add("20201205shop20200");
        keys.add("20201206shop20200");

        keys.forEach(p -> {
            try {
                String md5Str = md5(p);
                System.out.println(md5Str + " ==> " + md5Str.substring(0, 4));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        });
    }

    public static String md5(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 计算md5函数
        md.update(text.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        return new BigInteger(1, md.digest()).toString(16);
    }
}
