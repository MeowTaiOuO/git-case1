import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>();


        names.add("小明");
        names.add("小美");
        names.add("小明");


        for (String name : names) {
            System.out.println("名字：" + name);
        }
    }
}

