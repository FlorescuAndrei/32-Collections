package com.andrei._5_Set_Solar_System;

import java.util.HashSet;
import java.util.Set;


public class HeavenlyBody {

    //The class object will be an element in a set, elements in sets are unique so class should be immutable or as close as possible to immutable.
    // final help the class to be immutable.
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName(){
        return name;
    }

    public double getOrbitalPeriod(){
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    @Override
    //final can not be override in subclasses
    // when subclass we have to take care of  comparison between class and subclasses
    // for that we mark as final equals() and hashcode() in class.
    public final boolean equals(Object o) {
        System.out.println("equals() called");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        String objName = ((HeavenlyBody) o).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode() called");
        //+57 I guess is optional. The reason is to avoid obtaining a 0 (zero) number, but I don't see why will be zero if we use only the string.
        return this.name.hashCode() + 57;
    }
}
