import lld.LRUCache;
import lld.LazyHashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.useCache();

    }

    public void useMap() {
        LazyHashMap<String, Integer> map = new LazyHashMap<>();
        map.put("Sai", 1);
//        map.remove("Sai");
//        System.out.println(map.isEmpty());
//        System.out.println(map.containsKey("Sai"));
        map.rehash();
        map.keySet().forEach(System.out::println);
        System.out.println(map.n);
    }

    public void useCache() {

        LRUCache<Integer> cache = new LRUCache<>(3);
        cache.put("sai", 1);
        cache.put("leo", 2);
        cache.get("sai");
        cache.put("lazy", 3);
        cache.get("leo");
        cache.put("praneeth", 4);

    }
}