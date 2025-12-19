package Assignment_1;
import java.util.Scanner;

public class ArrayOperations {

    // Insert element
    static int insert(int[] arr, int n, int pos, int value) {
        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = value;
        return n + 1;
    }

    // Delete element
    static int delete(int[] arr, int n, int pos) {
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;
    }

    // Linear Search
    static int linearSearch(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // Binary Search (Array must be sorted)
    static int binarySearch(int[] arr, int n, int key) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    // Find Maximum
    static int findMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    // Count Even & Odd
    static void countEvenOdd(int[] arr, int n) {
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers : " + odd);
    }

    // Insertion Sort
    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Array sorted using Insertion Sort.");
    }

    // Display Array
    static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\n===== ARRAY MENU =====");
            System.out.println("1. Insert Element");
            System.out.println("2. Delete Element");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even/Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    n = insert(arr, n, pos, val);
                    break;

                case 2:
                    System.out.print("Enter position to delete: ");
                    int delPos = sc.nextInt();
                    n = delete(arr, n, delPos);
                    break;

                case 3:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    int index = linearSearch(arr, n, key);
                    if (index != -1)
                        System.out.println("Element found at index " + index);
                    else
                        System.out.println("Element not found");
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    int bkey = sc.nextInt();
                    int bindex = binarySearch(arr, n, bkey);
                    if (bindex != -1)
                        System.out.println("Element found at index " + bindex);
                    else
                        System.out.println("Element not found");
                    break;

                case 5:
                    System.out.println("Maximum value: " + findMax(arr, n));
                    break;

                case 6:
                    countEvenOdd(arr, n);
                    break;

                case 7:
                    insertionSort(arr, n);
                    break;

                case 8:
                    display(arr, n);
                    break;

                case 9:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 9);

        sc.close();
    }
}
