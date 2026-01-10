package Assignment_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class HashMapDemo {

    public static void main(String[] args) {

        System.out.println("HashMap Constructors");

        // Default constructor
        HashMap<Integer, String> map1 = new HashMap<>();
        System.out.println("Default constructor: " + map1);

        // Constructor with initial capacity
        HashMap<Integer, String> map2 = new HashMap<>(10);
        System.out.println("Initial capacity constructor: " + map2);

        // Constructor with initial capacity and load factor
        HashMap<Integer, String> map3 = new HashMap<>(10, 0.75f);
        System.out.println("Capacity and load factor constructor: " + map3);

        // Constructor with another map
        map1.put(1, "A");
        map1.put(2, "B");
        HashMap<Integer, String> map4 = new HashMap<>(map1);
        System.out.println("Map constructor: " + map4);

        System.out.println("\nHashMap Methods");

        HashMap<Integer, String> map = new HashMap<>();

        // put
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        System.out.println("After put: " + map);

        // putIfAbsent
        map.putIfAbsent(4, "SQL");
        System.out.println("After putIfAbsent: " + map);

        // get
        System.out.println("Get value of key 2: " + map.get(2));

        // containsKey
        System.out.println("Contains key 3: " + map.containsKey(3));

        // containsValue
        System.out.println("Contains value Java: " + map.containsValue("Java"));

        // size
        System.out.println("Size of map: " + map.size());

        // isEmpty
        System.out.println("Is map empty: " + map.isEmpty());

        // remove
        map.remove(3);
        System.out.println("After remove key 3: " + map);

        // replace
        map.replace(2, "Python", "JavaScript");
        System.out.println("After replace: " + map);

        // keySet
        Set<Integer> keys = map.keySet();
        System.out.println("Keys: " + keys);

        // values
        Collection<String> values = map.values();
        System.out.println("Values: " + values);

        // entrySet
        System.out.println("\nEntry set:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // forEach
        System.out.println("\nUsing forEach:");
        map.forEach((k, v) -> System.out.println(k + " " + v));

        // getOrDefault
        System.out.println("\nGetOrDefault for key 10: " + map.getOrDefault(10, "Not Found"));

        // clear
        map.clear();
        System.out.println("After clear: " + map);
        System.out.println("Is map empty now: " + map.isEmpty());
    }
}
