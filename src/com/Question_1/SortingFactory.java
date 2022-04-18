package com.Question_1;

import java.util.Arrays;

enum SortingAlgorithm {HEAP_SORT, BUBBLE_SORT, SELECTION_SORT};

public class SortingFactory {
    public static BinarySearch getSortingAlgorithm(SortingAlgorithm algo) {
        if(algo == SortingAlgorithm.HEAP_SORT) {
            return new HeapSort();
        } else if (algo == SortingAlgorithm.BUBBLE_SORT) {
            return new BubbleSort();
        } else if (algo == SortingAlgorithm.SELECTION_SORT) {
            return new SelectionSort();
        } else {
            //Since we're using an Enum this will never return null
            return null;
        }
    }
}

interface BinarySearch {
    void binarySearch(int[] arr, int target);
}

class BubbleSort implements BinarySearch {

    @Override
    public void binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        System.out.println("Array sorted using Bubble sort");

        //Binary Search Operation
    }

}

class SelectionSort implements BinarySearch {

    @Override
    public void binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        System.out.println("Array sorted using Selection sort");

        //Binary Search Operation
    }

}

class HeapSort implements BinarySearch {

    @Override
    public void binarySearch(int[] arr, int target) {
        Arrays.sort(arr);

        //Binary Search Operation
        System.out.println("Array sorted using Heap sort");
    }

}

