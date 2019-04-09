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

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};
        //Output => e, d, c, b, a
        print(bubbleSort.sort(strings));
    }
    
}
