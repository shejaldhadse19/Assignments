package Assignment_3;

import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class TreeMapDemo {

    public static void main(String[] args) {

        System.out.println("TreeMap Constructors");

        // Default constructor
        TreeMap<Integer, String> map1 = new TreeMap<>();
        System.out.println("Default constructor: " + map1);

        // Constructor with another map
        map1.put(1, "Java");
        map1.put(2, "Python");
        TreeMap<Integer, String> map2 = new TreeMap<>(map1);
        System.out.println("Map constructor: " + map2);

        // Constructor with comparator
        TreeMap<Integer, String> map3 = new TreeMap<>((a, b) -> b - a);
        map3.put(1, "A");
        map3.put(2, "B");
        System.out.println("Comparator constructor: " + map3);

        System.out.println("\nTreeMap Methods");

        TreeMap<Integer, String> map = new TreeMap<>();

        // put
        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        System.out.println("After put: " + map);

        // putIfAbsent
        map.putIfAbsent(40, "Forty");
        System.out.println("After putIfAbsent: " + map);

        // get
        System.out.println("Get key 20: " + map.get(20));

        // containsKey
        System.out.println("Contains key 30: " + map.containsKey(30));

        // containsValue
        System.out.println("Contains value Ten: " + map.containsValue("Ten"));

        // size
        System.out.println("Size: " + map.size());

        // isEmpty
        System.out.println("Is empty: " + map.isEmpty());

        // firstKey
        System.out.println("First key: " + map.firstKey());

        // lastKey
        System.out.println("Last key: " + map.lastKey());

        // higherKey
        System.out.println("Higher key than 20: " + map.higherKey(20));

        // lowerKey
        System.out.println("Lower key than 30: " + map.lowerKey(30));
        
     // remove
        map.remove(20);
        System.out.println("After remove key 20: " + map);
        

        // getOrDefault
        System.out.println("GetOrDefault for key 100: " + map.getOrDefault(100, "Not Found"));


        // keySet
        Set<Integer> keys = map.keySet();
        System.out.println("Key set: " + keys);

        // values
        Collection<String> values = map.values();
        System.out.println("Values: " + values);

        // entrySet
        System.out.println("\nEntry set:");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        // clear
        map.clear();
        System.out.println("\nAfter clear: " + map);
        System.out.println("Is empty now: " + map.isEmpty());
    }
}
