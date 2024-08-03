import lld.LazyHashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LazyHashMap<String, Integer> map = new LazyHashMap<>();
        map.put("Sai", 1);
//        map.remove("Sai");
//        System.out.println(map.isEmpty());
//        System.out.println(map.containsKey("Sai"));
        map.rehash();
        map.keySet().forEach(System.out::println);
        System.out.println(map.n);

    }
}