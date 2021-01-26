package function;

import java.util.function.Supplier;

/**
 * @author xiangjing
 * @version : Demo08Supplier, v 0.1 2020-11-19 10:20 xiangjing Exp$
 */
public class Demo08Supplier {
    /**
     * Supplier: 意味着"供给" , 对应的Lambda表达式需要“对外提供”一个符合泛型类型的对象数
     *
     * @param function
     * @return
     */
    private static String getString(Supplier<String> function) {
        return function.get();
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        System.out.println(getString(() -> msgA + msgB));
    }
}
