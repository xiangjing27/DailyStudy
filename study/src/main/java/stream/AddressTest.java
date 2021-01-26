package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangjing
 * @version : AddressTest, v 0.1 2020-09-16 21:31 xiangjing Exp$
 */
public class AddressTest {

    public static void main(String[] args) {
        Boolean a = (Boolean)null;
        System.out.println(a);

        Map m = new HashMap<>();
        m.put("a", "2");

        Entity entity = new Entity();
        entity.setM(m);

        List<Entity> data = new ArrayList<>();
        data.add(entity);

        List addr = new ArrayList();
        data.stream().map(p -> {
            p.getM().put("a", "1");
            addr.add(p.getM().toString());
            entity.setKey(p.getM().toString());
            return p;});
        System.out.println("==========");
        System.out.println(data.get(0).getM());
        System.out.println("==========");
        System.out.println(addr.size());
        System.out.println(entity.getKey());
    }

    static class Entity {
        private Map m;

        private String key;

        public Map getM() {
            System.out.println(this);
            return m;
        }

        public void setM(Map m) {
            this.m = m;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
