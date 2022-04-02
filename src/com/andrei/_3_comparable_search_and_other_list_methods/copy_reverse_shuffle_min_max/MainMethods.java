package com.andrei._3_comparable_search_and_other_list_methods.copy_reverse_shuffle_min_max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainMethods {
    public static void main(String[] args) {
        List<Flower>flowers = new ArrayList<>();

        Flower flower1 = new Flower("red");
        Flower flower2 = new Flower("blue");
        Flower flower3 = new Flower("green");

        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);


        System.out.println("\n============Shallow copy==============");
        // a new list is created but refers to the same objects
        //in the copy list we can have different order of the elements but there are the same elements.
        List<Flower> copyFlowers = new ArrayList<>(flowers);


        printList(flowers);
        printList(copyFlowers);

        //modify flower 2 and 3 in one list - the result will be the same in both lists.
        flowers.get(1).close();
        copyFlowers.get(2).setColor("purple");
        flowers.get(1).close();

        printList(flowers);
        printList(copyFlowers);

        //the order will be reverse only in copyFlowers because is a separated list
        Collections.reverse(copyFlowers);

        printList(flowers);
        printList(copyFlowers);

        Collections.shuffle(copyFlowers);

//Min and Max
        //Flower class must implement Comparable<Flower>
        Flower minFlower = Collections.min(flowers);
        System.out.println("minFlower: " + minFlower);

        Flower maxFlower = Collections.max(flowers);
        System.out.println("maxFlower: " + maxFlower);


        System.out.println("\n=============Deep copy================");

        //Deep copy use Collections.copy() method is complex and rare to use.
        //it is not cover in here.


    }

    public static void printList(List<Flower> flowers){
        for(Flower f : flowers){
            System.out.println(f);
        }
        System.out.println("------------\n");
    }

}
