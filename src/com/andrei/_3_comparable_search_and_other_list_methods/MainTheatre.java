package com.andrei._3_comparable_search_and_other_list_methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTheatre {
    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);

       theatre.printSeats();

        System.out.println("========= Reserve a seat ============");
        if (theatre.reserveSeatsV1("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("sorry seat is taken");
        }

        System.out.println("========= Reserve same seat ============");
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("sorry seat is taken");
        }

        System.out.println("\n========= Comparable and Comparator ============");
        System.out.println("===========Comparator===========");

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));

        Collections.sort(priceSeats, Theatre.priceOrder);

        printList(priceSeats);


    }

    public static void printList(List<Theatre.Seat> list){
        System.out.println("\nAll seats:");
        for (Theatre.Seat seat : list) {
            System.out.println(seat.getSeatNumber() + " : $" + seat.getPrice());
        }
        System.out.println("\n=====================");
    }




}
