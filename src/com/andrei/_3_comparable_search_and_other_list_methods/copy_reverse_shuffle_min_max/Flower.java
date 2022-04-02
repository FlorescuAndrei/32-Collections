package com.andrei._3_comparable_search_and_other_list_methods.copy_reverse_shuffle_min_max;

public class Flower implements Comparable<Flower>{
    private String color;
    private boolean open;

    public Flower(String color){
        this.color = color;
        open = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void close(){
        this.open = false;
    }


    @Override
    public String toString() {
        return color + " flower is " + (open ? "open" : "close");
    }


    @Override
    public int compareTo(Flower flower) {
        return this.color.compareTo(flower.getColor());
    }
}
