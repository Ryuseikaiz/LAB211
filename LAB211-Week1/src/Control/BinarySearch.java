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

public class BinarySearch {

    public static int binarySearch(Element[] elements, int target) {
        int left = 0;
        int right = elements.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (elements[mid].getSize() == target) {
                return mid;
            }

            if (elements[mid].getSize() < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; 
    }
}
