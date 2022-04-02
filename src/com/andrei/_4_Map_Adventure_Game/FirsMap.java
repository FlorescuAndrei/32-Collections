package com.andrei._4_Map_Adventure_Game;

import java.util.HashMap;
import java.util.Map;

public class FirsMap {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compile high level, object oriented, platform independent language");
        languages.put("Python", "an interpreted, object-oriented, high-level programing language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("Java"));

        //will override  the value but will return the old value;
        System.out.println(languages.put("Java", "this course is about Java"));
        System.out.println(languages.get("Java"));

        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        }else {
            languages.put("Java", "I love Java");
        }

        System.out.println("=============Replace================");
        System.out.println(languages.replace("Lisp", "a functional programing language with imperative features"));
        languages.replace("Lisp", "oldValue", "newValue");
        System.out.println(languages.remove("Scala", "this will not be added"));

        System.out.println("===============Remove=================");
        // return true or false
        languages.remove("BASIC"); // true
        System.out.println(languages.remove("Algol", "a family of algorithmic languages")); //false

        System.out.println("==============Print list==============");
        // unknown order
        for(String key: languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }





    }
}
