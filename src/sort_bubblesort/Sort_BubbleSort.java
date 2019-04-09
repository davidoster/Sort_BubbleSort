/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort_bubblesort;

import static java.lang.Math.pow;
import static sort_bubblesort.SortUtils.less;
import static sort_bubblesort.SortUtils.print;
import static sort_bubblesort.SortUtils.swap;


/**
 *
 * @author George.Pasparakis
 */
public class Sort_BubbleSort implements SortAlgorithm {

    /**
     * This method implements the Generic Bubble Sort
     *
     * @param array The array to be sorted
     * Sorts the array in increasing order
     **/

    @Override
    public  <T extends Comparable<T>> T[] sort(T array[]) {
        int last = array.length;
        //Sorting
        boolean swap;
        do {
            swap = false;
            for (int count = 0; count < last-1; count++) {
                if (less(array[count + 1], array[count])) {
                    swap = swap(array, count, count+1);
                }
            }
            last--;
        } while (swap);
        return array;
    }
    
    static int binarysearch(Double[] array, Double seekelement) {
        int middleelement = array.length / 2;
        if(Double.compare(array[middleelement], seekelement) > 0) {
            for(int i = 0; i <= middleelement; i++) {
                if(Double.compare(array[i], seekelement) == 0) return i;
            }
        }
        else {
            for(int i = middleelement + 1; i < array.length; i++) {
                if(Double.compare(array[i], seekelement) == 0) return i;
            }
        }
        
        return -1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Integer Input
        Double[] integers = {4.4, 23.12, 6.78, 78.91, 1.22, 54.19, 231.21, 9.33, 12.44};
        Sort_BubbleSort bubbleSort = new Sort_BubbleSort();
        long startTime = System.nanoTime();
        bubbleSort.sort(integers);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Secs:" + pow(totalTime,-6) + " Nano Secs: " + totalTime);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        print(integers);
//        Double d1 = new Double(1.22);
//        Double d2 = new Double(5.47);
//        System.out.println(Double.compare(d2,d1));
        System.out.println("Element 54.19 is found on " + binarysearch(integers, new Double(54.19)));
        // String Input
        String[] strings = {"cjp", "azk", "caq", "bfn","duk"};
        //Output => e, d, c, b, a
        startTime = System.nanoTime();
        bubbleSort.sort(strings);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        print(strings);
        System.out.println("Secs:" + pow(totalTime,-6) + " Nano Secs: " + totalTime);
    }
    
}
