package function;

import java.util.function.Predicate;

/**
 * @author xiangjing
 * @version : Demo15PredicateTest, v 0.1 2020-11-19 10:26 xiangjing Exp$
 */
public class Demo15PredicateTest {
    /**
     * Predicate: 对某种类型的数据进行判断，从而得到一个boolean值结果。
     * @param predicate
     * @param str
     */
    private static void method(Predicate<String> predicate, String str) {
        boolean veryLong = predicate.test(str);
        System.out.println("字符串很长吗：" + veryLong);
    }

    public static void main(String[] args) {
        method(s -> s.length() > 5, "Hello World");
    }
}
