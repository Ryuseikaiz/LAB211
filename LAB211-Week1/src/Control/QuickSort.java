/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Element;

/**
 *
 * @author HELLO
 */
public class QuickSort {

    public static void quickSort(Element[] elements, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(elements, low, high);
            quickSort(elements, low, partitionIndex - 1);
            quickSort(elements, partitionIndex + 1, high);
        }
    }

    private static int partition(Element[] elements, int low, int high) {
        Element pivot = elements[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (elements[j].getSize() < pivot.getSize()) {
                i++;

                Element temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
            }
        }

        Element temp = elements[i + 1];
        elements[i + 1] = elements[high];
        elements[high] = temp;

        return i + 1;
    }
}
