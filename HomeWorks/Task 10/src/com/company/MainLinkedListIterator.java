package com.company;

import java.util.Iterator;

public class MainLinkedListIterator {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Marsel");
        list.add("Nailya");
        list.add("Damir");
        list.add("Sergey");
        list.add("Aysilu");

        System.out.println(list.get(2));
        System.out.println(list.contains("Marsel"));
        list.delete(3);
        System.out.println(list.delete("Marsel"));


    }
}
