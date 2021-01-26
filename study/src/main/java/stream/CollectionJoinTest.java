package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiangjing
 * Creation Time: 2021/1/19 19:51
 */
public class CollectionJoinTest {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        System.out.println(arr.stream().collect(Collectors.joining(",")));
    }
}
