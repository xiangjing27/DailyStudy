package stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiangjing
 * @version : CalculateTest, v 0.1 2020-12-01 15:11 xiangjing Exp$
 */
public class CalculateTest {

    public static void main(String[] args) {
        new CalculateTest().test();
    }

    private void test() {
        int a = 1;
        int b = 2;

        A a1 = new A(2, 3);
        A a2 = new A(3, 1);

        List<A> arr = new ArrayList<>();
        arr.add(a1);
        arr.add(a2);

        int sum = arr.stream().mapToInt(A::getA).sum();
        System.out.println(sum);
    }
}
