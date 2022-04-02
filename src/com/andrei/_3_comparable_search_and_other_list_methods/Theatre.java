package com.andrei._3_comparable_search_and_other_list_methods;

import java.util.*;

public class Theatre {

    private final String theatreName;

    //Seat is an inner class
    private List<Seat> seats = new ArrayList<>();

    //instead, Seat class to implement comparable interface, we can use a Comparator
    static final Comparator<Seat> priceOrder = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()){
                return -1;
            }else if(seat1.getPrice() > seat2.getPrice()){
                return 1;
            }else {
                // not consistent with equals. Seats with same price are not equal, are not the same seat
                // must add code to repair
                return 0;
            }
        }
    };

    public Theatre(String theatreName, int numRows, int seatPerRow) {

        this.theatreName = theatreName;

        //create all seats
        //a seat will have a row letter and a seat number ex: A01
        //create last row (first row letter is A)
        int lastRow = 'A' + (numRows - 1);

        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum < seatPerRow; seatNum++) {
                //price 12 for seat, price in middle three rows increase to 14,price in the back two rows or at the edges 7
                double price = 12.00;

                if(row < 'D' && seatNum >= 4 && seatNum <=9  ){
                    price = 14.00;
                }else if (row > 'F' || seatNum < 4 || seatNum > 9){
                    price = 7.00;
                }

                //A02 --> 02 = String.format("%02d", seat num)
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);

                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }


//Search V1
    public boolean reserveSeatsV1(String seatNumber) {
        Seat requestedSeat = null;

//search the seat using brute force, we search every element
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }

        }
        if (requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        return requestedSeat.reserve();
    }

//Search V2 much more efficient
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber,0.0);

//search using collections binary search method  - the Seat class must implement Comparable
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat > 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

    }

    //for testing
    public void printSeats() {
        System.out.println("\nAll seats:");
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber() + " : " + seat.getPrice());
        }
        System.out.println("\n=====================");
    }

    public Collection<Seat> getSeats(){
        return seats;
    }



    //inner class Seat
    // implement Comparable(and override compareTo()method) for that Collections binary search method to work with seats.
    // this class should be private, but we need to work with List<Theatre.Seat> in main and we need to be public
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, Double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }


        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
            //return 0 if equal, number > 0 if is greater than the object that we compare to, number < 0 if is less
        }



        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice(){
            return price;
        }
    }


}
