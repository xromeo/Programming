package sort;

import java.util.Arrays;

public class Sort {

    void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int aux = array[i];
                array[i] = array[index];
                array[index] = aux;
            }
        }

    }

    int[] mergeSort(int[] array) {
        if(array.length == 1){
            return array;
        }
        int center = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, center);    
        int[] right = Arrays.copyOfRange(array, center, array.length);
        return merge(mergeSort(left),mergeSort(right));    
    }

    int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[i] = left[l];
                i++;
                l++;
            } else {
                result[i] = right[r];
                i++;
                r++;
            }
        }
        while (l < left.length) {
            result[i] = left[l];
            i++;
            l++;
        }
        while (r < right.length) {
            result[i] = right[r];
            i++;
            r++;
        }
        return result;
    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("" + array[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 30, 5, -1, 4, 7 };
        int[] array2 = { -30, -5, -1, -4, -7 };
        int[] a = { -30, 5, 10, 14, 17 };
        int[] b = { 3, 5, 7, 40, 70 };
        Sort sort = new Sort();
        // sort.bubbleSort(array);

        sort.selectionSort(array);

        sort.print(array);

        sort.print(sort.merge(a, b));

        int[] r = sort.mergeSort(array2);

        sort.print(r);
    }
}
