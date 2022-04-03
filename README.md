# 32-Collections
Collections Framework:   
List, ArrayList, LinkedList, Map, HashMap, Set, HashSet.Iterator, Comparable and Comparator. equals() and hashCode().   

This project contains 5 packages:  
-  1 simulate a mobile phone contacts list using ArrayLIst;  
-  2 create a music playlist using LinkedList;  
-  3 reserve seats in a theatre using lists, Comparable interface with compareTo() method.    
   Theatre class contains an inner Seat class that implement Comparable interface;    
-  4 create a map with location and direction for a game using Map interface and HashMap implementation;  
-  5 create a solar system representation using Set interface and HashSet implementation.   

[BACK TO START PAGE](https://github.com/FlorescuAndrei/Start.git)  

Collections Interface Implementation:  
<img src="box/Collections_Interface_Implementation.png" />   

| | | | |
|-------- |----------- |-------- |----------- |
| **Map** Interface<br>key/value pairs(HashTable DataStructure for Java)<br>Map<Key, Value><br>No duplicate keys | **HashMap** implementation<br> Map implementation<br>No order | **LinkedHashMap**<br>Order HashMap | **TreeMap**<br>Sorted Map|  
| **Set** Interface<br>Set<Value,> <br> **No duplicate** objects | **HashSet** Implementation<br>**No order**<br>Is backed up by an HashMap with key as the element and a dummy object as value | **LinkedHashSet**<br>**Order** HashSet | **TreeSet** <br> **Sorted** Set  

   
**ArrayList**  
-	.add(), addAll(), .get(),  .set() – update, .remove()   
-	.contains() – search an item (boolean)  
-	.indexOf(serachItem) – return index  
-	.toArray() – transform ArrayList to a regular Array   

**Copy**  
-	Shallow copy – create a new list but refer to the same elements:   
ArrayList<String> newArray = new ArrayList<>(oldArray);  
-	Deep copy – copy the elements (more complex, use Collections.copy(), rarely use, not cover in here)  

**LinkedList**
-	.add(item), .add(position, item) = add(3, item)    
-	.remove()    
   
**ListIterator** – allows the programmer to traverse the list in either direction, modify the list, and obtain the current position.  
ListIterantor has no current position, its cursor position always lies between the element that would be returned by a call to previous() and the element that would be returned by a call to next().  
-	hasNext(), hasPrevious(), next(), previous(), nextIndex(), previousIndex()  
-	add(), remove(), set()    
When use .next()  return current position and move to the next one.    
ListIterator extends Iterator from java.util package.    
<img src="box/Iterator_position.png"/>    

**Collections Methods:** 
-	Collections.sort(list)  
-	Collections.reverse(list)  
-	Collections.shuffle(list)  
-	Collections.min(list), .max(list)  
-	Collentions.swap(list, i, j)  
-	Collections.binarySearch(list, item, comparator).   
     The list must be sorted.  
     We need a comparator because the binary sort algorithm split in half the collection to be sorted and the items in the left half must be less than the items in the right half. If the item class implements Comparable, instead of comparator we pass null at comparator position.    
   
 
   
**Comparable interface vs Comparator**  
Needed to  sort the elements of a collection 
-	Comparable interface: the objects to be sorted must implement Comparable**<T,>**     
Override compareTo()method  
**Collections.sort(list)**  
   
-	Comparator
We can use Collectio.sort() method by passing a Comparator **Collections.sort(list, comparator)**.   
Comparator interface define a single method compare().   
The object to be sorted don’t have to implement Comparator, instead, an object of type Comparator can be created with the compare() method that can sort the objects.   
To create Comparator:    
    -	We can create a new class that implement Comparator. I do not refear to object class that we compare to implement Comparator. We will create a new class that implement Comparator   
    -	Create a comparator object using an anonymous inner class within an existing class  

   
**Map and HashMap**   

Key/Value pairs. HashTable DataStructure for Java.    
Key must be unique.  
Methods:  
-  .put(Key, value) 	- add a new element or replace an existing one  
-  .replace(key, oldValue,newValue)  
-  .containsKey() &emsp;   .keySet()  
Example of use: Vocabulary(letter, word). AdventureGame project - locations(direction, location)    

   
**Sets and HashSet**  

Methods:  
-  add(), remove(), size() , isEmpty()...  
   
   
   
    
Set<type> - Interface  	HashSet – Implementation of Set interface. No order.  No duplicates  
Map<keyType, valueType> Interface	 -HashMap – implementation of Map interface. No order.  No duplicates key.  
List is an order collection that can contain duplicates;  

Some sets have order: Treeset, LinkedHashSet.    
   
 --------------------------------  
   
Bulk Operations  
-  .addAll()	- union get all elements, no duplicates  
-  .retainAll()	- intersection get all elements that are in both sets  
-  .removeAll	- difference: set1-set2  
-  .containsAll	- test if one set is a superset of another  - non distructive  
Bulk Operations  
The Collections framework has always provided a number of so-called "bulk operations" as part of its API. These include methods that operate on entire collections, such as containsAll, addAll, removeAll, etc. Do not confuse those methods with the aggregate operations that were introduced in JDK 8. The key difference between the new aggregate operations and the existing bulk operations (containsAll, addAll, etc.) is that the old versions are all mutative, meaning that they all modify the underlying collection. In contrast, the new aggregate operations do not modify the underlying collection. When using the new aggregate operations and lambda expressions, you must take care to avoid mutation so as not to introduce problems in the future, should your code be run later from a parallel stream.  
   
   -------------------------------------------------------

Set has no order and no duplicates. If we want a collection with no duplicates we go for sets;
If we want to get all unique items in a collection can use a Set
If we want to perform a mathematical operation pe multimi can use a set (intersection, union, difference)
Everything that applies to Key in a Map applies to the Set. (Ex: we cannot have a duplicate key in Map and we cannot have duplicate elements in Set)
HASHSETS implementation uses a HashMap in java8– value as a key, and a dummy object as value;
We chose to use Set because we need no duplicate elements, but we must create our objects as close as possible to be immutable and/or to have good equal() and hashCode() methods otherwise we will have duplicates because java will not see that the objects are equal.
Daca este key in Map sau element in Set– se recomanda sa fie immutable
Daca nu pot fi immutable java  recomanda  to override the hash code and equal methods and we mark them final if we subclass the class for not to be overridden in subclasses.
The base Object equals method compare equals if two references point to the same object. Same as ==.    == return true if it is the same object.
Hash code is an integer value associated with an object. 
hashCode() method takes an object and return an int value.
Every object have a hash code. The idea is to have a good hash function (hashCode() method) to generate different hash code for not equal objects, and same hash code for equal objects.

   if equals() and hCode() methods are properly made); (equals for verifying equality and hashCode for the correct bucket – equals object to be placed in the same bucket)
   
   
In Java, Hash Collections like HashMap or HashSet, store objects in buckets. Hash code gives the bucket where the element will be stored. Equals elements should have the same hash code. If their hash code will not be equal, will be stored by the hash collection in different buckets. 
(LinkedList is a Collection  but not a Hash Collection, does not use hashcode() or buckets)

If the elements to be compared are equals but have different hash codes they will not be compared as equals because will be placed in different buckets. The hash collection will look in the wrong buckets. Two objects to be compared equals must have the same hash Code to be in the same bucket. Strict relation sheep between equals and hash code
If hashCodes are equal the object will be stored in the same bucket(hashCode point to the bucket). Different objects can have the same hashCode but can be inefficient. 
Equals objects must have the same hashCode for HashMap key or HashSet to work properly.
 
When we use objects in sets or keys in maps is good that in object class to override the hashCode() and equals() methods.
Override equals()
•	We must keep Object in method signature, otherwise will be an Overload and we want to Override.
•	We keep the first lines: this == obj, and the getClass() check
•	We can cast the Object 
Override hashCode()


In Sets se permite operatii ca intersectie si union
Inteleg ca Sets are good to use when we work with operations pe multimi de element.

a union of two or more sets is a set containing all the elements, no duplicates.

Symmetric and Asymmetric  - type of the intersection
Diagram with two Sets of Strings: Set nature(green), Set divine(blue), Intersection (red)
 
•	Asymmetric difference => a-b != b-a
o	nature – divine = all the green words
o	divine – nature = all blue words
•	Symmetric difference = the elements that appear in one set and another but not both.
Symmetric difference = union – intersection 
o	Green and blue words


HashSet   .add nu adauga daca obiectul este egal cu unul din lista(no duplicates) si nici nu inlocueste.
HashMap  .put inlocueste obiectul daca este vorba de aceeasi key.

LinkedHashMap(have order)
for order: compareTo() method
LinkedHashSet (order)

Tree Map(Sorted Map)
Tree Set(Sorted Set)



[BACK TO START PAGE](https://github.com/FlorescuAndrei/Start.git)
