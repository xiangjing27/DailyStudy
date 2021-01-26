package function;

import java.util.function.Supplier;

/**
 * @author xiangjing
 * @version : DemoIntArray, v 0.1 2020-11-19 10:22 xiangjing Exp$
 */
public class DemoIntArray {
    public static void main(String[] args) {
        int[] array = { 10, 20, 100, 30, 40, 50 };
        printMax(() -> {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        });
    }

    private static void printMax(Supplier<Integer> supplier) {
        int max = supplier.get();
        System.out.println(max);
    }
}
