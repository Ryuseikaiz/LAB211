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
public class LinearSearch {

    public static int linearSearch(Element[] elements, int target) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getSize() == target) {
                return i;
            }
        }
        return -1;
    }
}
