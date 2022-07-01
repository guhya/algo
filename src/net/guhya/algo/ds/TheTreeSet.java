package net.guhya.algo.ds;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TheTreeSet {
    
    static class Type {
        String name;
        int count;
        public Type(String name, int count) {
            this.name = name;
            this.count = count;
        }
        public String toString() {
            return "[" + this.name + ", " + this.count + "]";
        }
        public int hashcode() {
            return this.name.hashCode();
        }
        public boolean equals(Object obj) {
            return ((Type) obj).name.equals(this.name);
        }
    }

    public static void main(String[] args) {
        SortedSet<Type> sortedType = new TreeSet<>(new Comparator<Type>() {
            @Override
            public int compare(Type o1, Type o2) {
                return o2.count - o1.count;
            }
        });
        
        sortedType.add(new Type("Ham", 1));
        sortedType.add(new Type("Burger", 3));
        sortedType.add(new Type("Donuts", 4));
        sortedType.add(new Type("Fries", 5));
        sortedType.add(new Type("Cola", 1));
        sortedType.add(new Type("Cola", 6));
        sortedType.add(new Type("Fries", 7));
        for (Type t : sortedType) {
            System.out.println(t.hashCode());
        }
        System.out.println(sortedType.first().hashCode());
        
        System.out.println(sortedType);
        System.out.println(sortedType.first());
        System.out.println(sortedType.last());
        
        System.out.println((new Type("Food", 1).equals(new Type("Food", 2))));

    }

}
