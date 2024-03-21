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
public class BubbleSort {

    public static Element[] sortArrayByBubbleSort(Element[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j].getSize() > elements[j + 1].getSize()) {
                    Element temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
        return elements;
    }

    public static void printArray(Element[] elements) {
        System.out.print("[");
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i]);
            if (i < elements.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
