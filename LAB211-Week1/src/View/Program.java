/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.BinarySearch;
import Control.BubbleSort;
import Control.Inputter;
import Control.LinearSearch;
import Control.QuickSort;
import Model.Element;

/**
 *
 * @author HELLO
 */
public class Program extends Menu<String> {

    private static Element[] elements;

    public Program() {
        super("Choose an option:", new String[]{"Input array", "Print array", "Bubble sort", "Quick sort",
            "Linear search", "Binary search"});
    }

    private void inputArray() {

        System.out.println("Enter the number of array:");
        int n = Inputter.checkInputInt();
        elements = new Element[n];
        System.out.println("Now input the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            int size = Inputter.checkInputInt();
            elements[i] = new Element(size);
        }
    }

    public static void printArray() {
        if (elements != null) {
            System.out.println("Array elements:");
            BubbleSort.printArray(elements);
        } else {
            System.out.println("Empty array.");
        }
    }

    private void performBubbleSort() {
        if (elements != null) {
            elements = BubbleSort.sortArrayByBubbleSort(elements);
            System.out.println("Sorted Elements (Bubble Sort):");
            BubbleSort.printArray(elements);
        } else {
            System.out.println("Empty array.");
        }
    }

    private void performQuickSort() {
        if (elements != null) {
            QuickSort.quickSort(elements, 0, elements.length - 1);
            System.out.println("Sorted Elements (Quick Sort):");
            BubbleSort.printArray(elements);
        } else {
            System.out.println("Empty array.");
        }
    }

    private void performLinearSearch() {
        if (elements != null) {                    
            System.out.println("Enter the element to search:");
            int target = Inputter.checkInputInt();
            int result = LinearSearch.linearSearch(elements, target);
            if (result != -1) {
                System.out.println("Element found at index " + result);
            } else {
                System.out.println("Element not found in the array.");
            }
        } else {
            System.out.println("Empty array.");
        }
    }

    private void performBinarySearch() {
        if (elements != null) {
            QuickSort.quickSort(elements, 0, elements.length - 1);
            System.out.println("Sorted Elements:");
            BubbleSort.printArray(elements);
            
            System.out.println("Enter the element to search:");
            int target = Inputter.checkInputInt();
            int result = BinarySearch.binarySearch(elements, target);
            if (result != -1) {
                System.out.println("Element found at index " + result);
            } else {
                System.out.println("Element not found in the array.");
            }
        } else {
            System.out.println("Empty array.");
        }
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                inputArray();
                break;
            case 2:
                printArray();
                break;
            case 3:
                performBubbleSort();
                break;
            case 4:
                performQuickSort();
                break;
            case 5:
                performLinearSearch();
                break;
            case 6:
                performBinarySearch();
                break;
            default:
                System.out.println("Invalid selection.");
        }
    }

    public static void main(String[] args) {
        Program mainMenu = new Program();
        mainMenu.run();
    }
}
