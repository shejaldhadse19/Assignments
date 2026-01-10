package Assignment_3;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Enumeration;

public class HashtableDemo {

    public static void main(String[] args) {

        System.out.println("Hashtable Constructors");

        // Default constructor
        Hashtable<Integer, String> ht1 = new Hashtable<>();
        System.out.println("Default constructor: " + ht1);

        // Constructor with initial capacity
        Hashtable<Integer, String> ht2 = new Hashtable<>(10);
        System.out.println("Capacity constructor: " + ht2);

        // Constructor with initial capacity and load factor
        Hashtable<Integer, String> ht3 = new Hashtable<>(10, 0.75f);
        System.out.println("Capacity & load factor constructor: " + ht3);

        // Constructor with another map
        ht1.put(1, "Java");
        ht1.put(2, "Python");
        Hashtable<Integer, String> ht4 = new Hashtable<>(ht1);
        System.out.println("Map constructor: " + ht4);

        System.out.println("\nHashtable Methods");

        Hashtable<Integer, String> ht = new Hashtable<>();

        // put
        ht.put(10, "Ten");
        ht.put(20, "Twenty");
        ht.put(30, "Thirty");
        System.out.println("After put: " + ht);

        // putIfAbsent
        ht.putIfAbsent(40, "Forty");
        System.out.println("After putIfAbsent: " + ht);

        // get
        System.out.println("Get key 20: " + ht.get(20));

        // containsKey
        System.out.println("Contains key 30: " + ht.containsKey(30));

        // containsValue
        System.out.println("Contains value Ten: " + ht.containsValue("Ten"));

        // size
        System.out.println("Size: " + ht.size());

        // isEmpty
        System.out.println("Is empty: " + ht.isEmpty());

        // keySet
        Set<Integer> keys = ht.keySet();
        System.out.println("Key set: " + keys);

        // values
        Collection<String> values = ht.values();
        System.out.println("Values: " + values);

        // entrySet
        System.out.println("\nEntry set:");
        for (Map.Entry<Integer, String> e : ht.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        // remove
        ht.remove(20);
        System.out.println("\nAfter remove key 20: " + ht);

        // getOrDefault
        System.out.println("GetOrDefault key 100: " + ht.getOrDefault(100, "Not Found"));

        // replace
        ht.replace(10, "TEN");
        System.out.println("After replace: " + ht);

        // keys enumeration
        System.out.print("Keys using Enumeration: ");
        Enumeration<Integer> en = ht.keys();
        while (en.hasMoreElements()) {
            System.out.print(en.nextElement() + " ");
        }
        System.out.println();

        // elements enumeration
        System.out.print("Elements using Enumeration: ");
        Enumeration<String> en2 = ht.elements();
        while (en2.hasMoreElements()) {
            System.out.print(en2.nextElement() + " ");
        }
        System.out.println();

        // clear
        ht.clear();
        System.out.println("After clear: " + ht);
        System.out.println("Is empty now: " + ht.isEmpty());
    }
}
