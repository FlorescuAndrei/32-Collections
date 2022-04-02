package com.andrei._4_Map_Adventure_Game.v02_immutable;

import java.util.HashMap;
import java.util.Map;


//make Location immutable
public class Location2 {

    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    //add map in constructor
    public Location2(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;

       // this.exits = exits; not good, not immutable

        if(exits != null) {
            this.exits = new HashMap<>(exits);// we will use a copy of the original map that we pass to the constructor
        }else {
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

    //Remove addExit() because we add exits in the constructor now
//    public void addExit(String direction, int location){
//        exits.put(direction, location);
//    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    //
    public Map<String, Integer> getExits() {
      //  return exits;  not ok, we want original exits map to be impossible to change, so we will return a copy of it
        return new HashMap<String, Integer>(exits);
    }
}

// for the class to be immutable:
// getter - we get (take) a copy of the map, so even if we change the copy  the original map will not be changed
// setter (or in constructor because will not be setter in immutable classes)  - we set (put) a copy of the map so even if we change the original map the class will not be change