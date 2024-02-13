import java.util.*;

class SortingAlgorithms<T extends Comparable<T>> {

    // Bubble Sort
    public void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Swap array[j] and array[j+1]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    
    public void mergeSort(T[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;

        
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

       
        mergeSort(left);
        mergeSort(right);

        
        merge(array, left, right);
    }

    private void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }


        while (i < left.length) {
            array[k++] = left[i++];
        }

        
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    
    public void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        SortingAlgorithms<Integer> sorter = new SortingAlgorithms<>();

        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Before sorting:");
        sorter.printArray(arr);

       
        sorter.bubbleSort(arr);
        System.out.println("After Bubble Sort:");
        sorter.printArray(arr);

        
        arr = new Integer[]{64, 34, 25, 12, 22, 11, 90};
        
        
        sorter.mergeSort(arr);
        System.out.println("After Merge Sort:");
        sorter.printArray(arr);
    }
}
