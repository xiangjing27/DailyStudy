package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author xiangjing
 * @version : MapSortTest, v 0.1 2020-12-24 17:15 xiangjing Exp$
 */
public class MapSortTest {

    public static void main(String[] args) {
        List<Integer> ageList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        for(int i = 0; i < 1000; i++) {
            Person person = new Person(10+ new Random().nextInt(30), "xx" + i);

            personList.add(person);
            ageList.add(person.getAge());
        }
        List<String> reList = personList.stream().map(p -> p.toString()).collect(Collectors.toList());
        for (int i = 0; i < ageList.size(); i++) {
            Integer age1 = ageList.get(i);
            if(!reList.get(i).startsWith(String.valueOf(age1))) {
                System.out.println(reList.get(i));
            }
        }
    }

    static class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.valueOf(age) + " " + name;
        }
    }
}
