package Assignment_3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListOperations {

    public static void main(String[] args) {

        System.out.println("ArrayList Constructors->");

        // 1.️Default constructor
        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println("Default constructor: " + list1);

        // 2️.Constructor with initial capacity
        ArrayList<Integer> list2 = new ArrayList<>(5);
        System.out.println("Initial capacity constructor: " + list2);

        // 3️.Constructor with another collection
        ArrayList<Integer> list3 = new ArrayList<>(list1);
        System.out.println("Collection constructor: " + list3);
        
        

        System.out.println("\nArrayList Methods->");
        ArrayList<Integer> list = new ArrayList<>();

        // add(E e)
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After add : " + list);

        // add(index, E e)
        list.add(1, 15);
        System.out.println("After add at index 1: " + list);

        // addAll(Collection c)
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(40);
        temp.add(50);
        list.addAll(temp);
        System.out.println("After addAll : " + list);

        // get(index)
        System.out.println("Element at index 2: " + list.get(2));

        // set(index, E e)
        list.set(2, 25);
        System.out.println("After set at index 2: " + list);

        // remove(index)
        list.remove(3);
        System.out.println("After remove at index 3: " + list);

        // remove(Object o)
        list.remove(Integer.valueOf(50));
        System.out.println("After remove object 50: " + list);

        // contains(E e)
        System.out.println("Contains 20 " + list.contains(20));

        // indexOf(E e)
        System.out.println("Index of 25: " + list.indexOf(25));

        // lastIndexOf(E e)
        list.add(20);
        System.out.println("After adding another 20: " + list);
        System.out.println("Last index of 20: " + list.lastIndexOf(20));

        // size()
        System.out.println("Size: " + list.size());

        // isEmpty()
        System.out.println("Is list empty : " + list.isEmpty());

        // toArray()
        Object[] arr = list.toArray();
        System.out.print("Elements in array: ");
        for (Object o : arr) System.out.print(o + " ");
        System.out.println();


        // SubList()
        System.out.println("SubList of list : " + list.subList(0, list.size()));


        
        System.out.println("\nTraversals->");

        // 1. For loop
        System.out.print("Using for loop :");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 2. For-each loop
        System.out.print("Using for-each :");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 3. Iterator
        System.out.print("Using Iterator :");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 4. forEach lambda
        System.out.print("Using forEach lambda :");
        list.forEach(i -> System.out.print(i + " "));
        System.out.println();

        // clear() demonstration
        list.clear();
        System.out.println("\nAfter clear : " + list);
        System.out.println("Is list empty : " + list.isEmpty());
    }
}
