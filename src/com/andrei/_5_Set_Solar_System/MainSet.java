package com.andrei._5_Set_Solar_System;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainSet {
    public static void main(String[] args) {
        Set<Integer>squares = new HashSet<>();
        Set<Integer>cubes = new HashSet<>();

        for(int i = 1; i<=100; i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }
        System.out.println("There are " + squares.size()  + " squares and " + cubes.size() + " cubes");

  //union get all elements, no duplicates
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");

        //intersection get all elements that are in both sets
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size());
        for(int i : intersection){
            System.out.println(i + " is the square of " + Math.sqrt(i) + " ant the cube of " + Math.cbrt(i));
        }


        //create a Set from an Array
        //there is not set or map literals in Java. We can not initialize a Set or a Map by passing a list of values.
        //we have to add one by one.
        //but we can pass an array to simulate that.
        System.out.println("========== Set from Array ==================");
        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for(String s : words){
            System.out.println(s);
        }


//Symmetric and Asymmetric Difference
        System.out.println("========== Symmetric and Asymmetric Difference ==================");
        System.out.println("Set 1: ");

        //Asymmetric
        //set1 - set2 != set2 - set1
        //set1 - set2 = set1 - intersection
        System.out.println("========== Asymmetric Difference ==================");

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        //Asymmetric Difference nature - divine
        System.out.println("nature - divine");
        Set<String>diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String>diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        //Symmetric
        //intersection - union
        System.out.println("========== Symmetric Difference ==================");

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        unionTest.removeAll(intersectionTest);
        printSet(unionTest);


        //test if one set is a superset of another
        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }
        if(nature.containsAll(intersectionTest)){
            System.out.println("intersectionTest is a subset of nature");
        }
        if(divine.containsAll(intersectionTest)){
            System.out.println("intersectionTest is a subset of divine");
        }

    }

    private static void printSet(Set<String> set){
        System.out.print("\t");
        for(String s : set){
            System.out.print(s + " ");
        }
        System.out.println();
    }




}
