package org.py.web2020.win;

import java.util.Iterator;

public class IterModel implements Iterable<String> {
    private String[] collection;
    private int index;
    public static void main(String[] args) {
        IterModel it = new IterModel();
        it.forEach(System.out::println);
    }
    public IterModel() {
        collection = new String[] {"win95", "win98", "win2000", "winxp", "winvista", "win2008", "win7", "win8", "win10"};
        index = 0;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < collection.length;
            }

            @Override
            public String next() {
                return collection[index++];
            }
        };
    }
}
