package Assignment_3;

import java.util.Vector;
import java.util.Iterator;
import java.util.Enumeration;

public class VectorOperations {

    public static void main(String[] args) {

        System.out.println("Vector Constructors->");

        // Default constructor
        Vector<Integer> v1 = new Vector<>();
        System.out.println("Default constructor: " + v1);

        // Constructor with initial capacity
        Vector<Integer> v2 = new Vector<>(5);
        System.out.println("Initial capacity constructor: " + v2);

        // Constructor with another collection
        Vector<Integer> v3 = new Vector<>(v1);
        System.out.println("Collection constructor: " + v3);

        System.out.println("\nVector Methods->");
        Vector<Integer> v = new Vector<>();

        // add(E e)
        v.add(10);
        v.add(20);
        v.add(30);
        System.out.println("After add : " + v);

        // add(index, E e)
        v.add(1, 15);
        System.out.println("After add at index 1: " + v);

        // addAll(Collection c)
        Vector<Integer> temp = new Vector<>();
        temp.add(40);
        temp.add(50);
        v.addAll(temp);
        System.out.println("After addAll : " + v);

        // addElement(E e)
        v.addElement(60);
        System.out.println("After addElement : " + v);

        // get(index)
        System.out.println("Element at index 2: " + v.get(2));

        // set(index, E e)
        v.set(2, 25);
        System.out.println("After set at index 2: " + v);

        // setElementAt(E e, index)
        v.setElementAt(35, 3);
        System.out.println("After setElementAt : " + v);

        // remove(index)
        v.remove(4);
        System.out.println("After remove at index 4: " + v);

        // remove(Object o)
        v.remove(Integer.valueOf(20));
        System.out.println("After remove object 20: " + v);

        // removeElement(Object o)
        v.removeElement(Integer.valueOf(10));
        System.out.println("After removeElement : " + v);

        // contains(E e)
        System.out.println("Contains 25 : " + v.contains(25));

        // indexOf(E e)
        System.out.println("Index of 25: " + v.indexOf(25));

        // lastIndexOf(E e)
        v.add(25);
        System.out.println("After adding another 25: " + v);
        System.out.println("Last index of 25: " + v.lastIndexOf(25));

        // size()
        System.out.println("Size: " + v.size());

        // isEmpty()
        System.out.println("Is vector empty : " + v.isEmpty());

        // capacity()
        System.out.println("Capacity: " + v.capacity());

        // toArray()
        Object[] arr = v.toArray();
        System.out.print("Elements in array: ");
        for (Object o : arr) System.out.print(o + " ");
        System.out.println();

        // SubList()
        System.out.println("SubList of vector : " + v.subList(0, v.size()));


        System.out.println("\nTraversals->");

        // Using for loop
        System.out.print("Using for loop :");
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println();

        // Using for-each
        System.out.print("Using for-each :");
        for (Integer i : v) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Using Iterator
        System.out.print("Using Iterator :");
        Iterator<Integer> it = v.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Using Enumeration
        System.out.print("Using Enumeration :");
        Enumeration<Integer> e = v.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }
        System.out.println();

        // Using forEach lambda
        System.out.print("Using forEach lambda :");
        v.forEach(i -> System.out.print(i + " "));
        System.out.println();

        // clear()
        v.clear();
        System.out.println("\nAfter clear : " + v);
        System.out.println("Is vector empty : " + v.isEmpty());
    }
}
