package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiangjing
 * @version : ListUnionTest, v 0.1 2020-12-30 17:37 xiangjing Exp$
 */
public class ListUnionTest {

    public static void main(String[] args) {
        List<ListUnionItem> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            ListUnionItem item = new ListUnionItem();
            item.setA(new ArrayList<>());
            item.setB(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                item.getA().add("a-" + i + "-" + j);
                item.getB().add("b-" + i + "-" + j);
            }
            list.add(item);
        }
        List<String> a = list.stream().flatMap(p -> p.getA().stream()).collect(Collectors.toList());
        List<String> b = list.stream().flatMap(p -> p.getB().stream()).collect(Collectors.toList());
        System.out.println(a);
        System.out.println(b);
    }

    static class ListUnionItem {
        List<String> a;
        List<String> b;

        public List<String> getA() {
            return a;
        }

        public void setA(List<String> a) {
            this.a = a;
        }

        public List<String> getB() {
            return b;
        }

        public void setB(List<String> b) {
            this.b = b;
        }
    }
}
