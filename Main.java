package SortingAlgorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int n = 10000;
        int[] list = generateRandomArray(n); // Generate an array of n random integers
        long start, finish, time;
        System.out.println("\r\n");
        System.out.println("List of " + n + " integer numbers is: " + Arrays.toString(list) + "\r\n");

        //Sorting the list with Insertion Sort Method
        start = System.nanoTime();// Start timer
        insertionSort(list);
        finish = System.nanoTime(); // End timer
        time = (finish - start); // Calculate duration in nanoseconds
        System.out.println("Insertion Sort Method");
        System.out.println("Sorted List: " + Arrays.toString(list));
        System.out.println("Time to sort list of " + n + " integers: " + time + " nanoseconds" + "\r\n");

        // Sorting with Bubble Sort Method
        start = System.nanoTime();// Start timer
        bubbleSort(list);
        finish = System.nanoTime(); // End timer
        time = (finish - start); // Calculate sorting time
        System.out.println("Bubble Sort Method");
        System.out.println("Sorted List: " + Arrays.toString(list));
        System.out.println("Time to sort list of " + n + " integers: " + time + " nanoseconds" + "\r\n");

        //Sorting with Selection Sort Method
        start = System.nanoTime();// Start timer
        selectionSort(list);
        finish = System.nanoTime(); // End timer
        time = (finish - start); // Calculate duration in nanoseconds
        System.out.println("Selection Sort Method");
        System.out.println("Sorted List: " + Arrays.toString(list));
        System.out.println("Time to sort list of " + n + " integers: " + time + " nanoseconds");
    }
    // Creating Insertion Sort function
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    // Creating Bubble Sort function
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //Creating Selection Sort Function
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int index  = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    //Generating random array with no repeating integers
    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<Integer>(); // using set to make sure values don't repeat
        Random rand = new Random();
        while (set.size() < n) {
            set.add(rand.nextInt(20000)); // Generate a random integer between 0 and 19999 and add to set
        }
        int i = 0;
        for (int num : set) {
            arr[i++] = num; // Add integers from set to array
        }
        return arr;
    }
}
