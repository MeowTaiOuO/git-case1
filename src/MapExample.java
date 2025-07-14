import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        // 加入資料
        scores.put("小明", 90);
        scores.put("小美", 85);
        scores.put("小明", 95);

        // 取得指定 key 的 value
        System.out.println("小明的分數是：" + scores.get("小明"));

        // 印出所有資料
        for (String name : scores.keySet()) {
            System.out.println(name + " 的分數是：" + scores.get(name));
        }
    }
}

