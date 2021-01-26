package basic;

import java.util.Random;

/**
 * @author xiangjing
 * @version : RandomTest, v 0.1 2020-12-17 17:37 xiangjing Exp$
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextInt(100) % 2);
        }
    }
}
