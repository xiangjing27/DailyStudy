package function;

import java.util.function.Function;

/**
 * @author xiangjing
 * @version : Demo11FunctionApply, v 0.1 2020-11-19 10:25 xiangjing Exp$
 */
public class Demo11FunctionApply {
    /**
     * Function: 根据一个类型的数据得到另一个类型的数据，前者称为前置条件，后者称为后置条件。有进有出
     *
     * @param function
     * @param str
     */
    private static void method(Function<String, Integer> function, String str) {
        int num = function.apply(str);
        System.out.println(num + 20);
    }

    public static void main(String[] args) {
        method(s -> Integer.parseInt(s), "10");
    }

}
