package com.Question_1;

//To achieve the said abstractions I have used the following classes and interfaces -

//SortingFactory ---> returns an object of BinarySearch algorithm that uses the sorting algo
// as required by the user
//Interface --> `BinarySearch`
//Sorting algorithm classes that implement the above sorting algorithm

//This strategy of design is one of the creational design patters called -> Factory Design Pattern

public class SearchingRunner {

    public static void main(String[] args) {

        int[] arr = {1,3,5,2,0};
        int target = 3;

        //Takes enum as input
        //Here very high modularity and low coupling has been achieved

        BinarySearch bs1 = SortingFactory.getSortingAlgorithm(SortingAlgorithm.BUBBLE_SORT);
        bs1.binarySearch(arr, target);

        BinarySearch bs2 = SortingFactory.getSortingAlgorithm(SortingAlgorithm.SELECTION_SORT);
        bs2.binarySearch(arr, target);

        BinarySearch bs3 = SortingFactory.getSortingAlgorithm(SortingAlgorithm.HEAP_SORT);
        bs3.binarySearch(arr, target);

    }

}
