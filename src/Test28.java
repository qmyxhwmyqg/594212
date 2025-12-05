import java.util.*;

public class Test28 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("张三", 25));
        people.add(new Person("李四", 20));
        people.add(new Person("王五", 30));

        // 使用Comparator按年龄排序
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.age, p2.age);
            }
        });

        System.out.println("按年龄排序:");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}