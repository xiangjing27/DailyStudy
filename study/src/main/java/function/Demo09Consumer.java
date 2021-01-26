package function;

import java.util.function.Consumer;

/**
 * @author xiangjing
 * @version : Demo09Consumer, v 0.1 2020-11-19 10:23 xiangjing Exp$
 */
public class Demo09Consumer {
    /**
     * Consumer: 消费一个数据
     *
     * @param function
     * @param str
     */
    private static void consumeString(Consumer<String> function , String str) {
        function.accept(str);
    }

    public static void main(String[] args) {
        consumeString(s -> System.out.println(s), "hello world");
    }
}
