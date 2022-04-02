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
<img src="box/Collections_Interface_Implementation.png" width="700" height="150" />   

| | | | |
|-------- |----------- |-------- |----------- |
| **Map** Interface<br>key/value pairs(HashTable DataStructure for Java)<br>Map<Key, Value><br>No duplicate keys | **HashMap** implementation<br> Map implementation<br>No order | **LinkedHashMap**<br>Order HashMap | **TreeMap**<br>Sorted Map|  
| **Set** Interface<br>Set<Value,> <br> **No duplicate** objects | **HashSet** Implementation<br>**No order**<br>Is backed up by an HashMap with key as the element and a dummy object as value | **LinkedHashSet**<br>**Order** HashSet | **TreeSet** <br> **Sorted** Set  

**ListIterator** – allows the programmer to traverse the list in either direction, modify the list, and obtain the current position.  
ListIterantor has no current position, its cursor position always lies between the element that would be returned by a call to previous() and the element that would be returned by a call to next().  
-	hasNext(), hasPrevious(), next(), previous(), nextIndex(), previousIndex()  
-	add(), remove(), set()  
When use .next()  return current position and move to the next one.  
ListIterator extends Iterator from java.util package.  

Collections Methods:  
-	Collections.sort(list)  
-	Collections.reverse(list)  
-	Collections.shuffle(list)  
-	Collections.min(list), .max(list)  
-	Collentions.swap(list, i, j)  
-	Collections.binarySearch(list, item, comparator). If the item Class implements Comparable, instead of comparator we pass null at comparator position. The list must be sorted.  
-	
**Copy**  
-	Shallow copy – create a new list but refer to the same elements:   
ArrayList<String> newArray = new ArrayList<>(oldArray);  
-	Deep copy – copy the elements (more complex, use Collections.copy(), rarely use, not cover in here)  
   
   
**Comparable interface vs Comparator**  
Needed to  sort the elements of a collection 
-	Comparable interface: the objects to be sorted must implement Comparable**<T>**     
Override compareTo()method  
**Collections.sort(list)**  
   
-	Comparator
We can use Collectio.sort() method by passing a Comparator **Collections.sort(list, comparator)**.   
Comparator interface define a single method compare().   
The object to be sorted don’t have to implement Comparator, instead, an object of type Comparator can be created with the compare() method that can sort the objects.   
To create Comparator:    
    -	We can create a new class that implement Comparator. I do not refear to object class that we compare to implement Comparator. We will create a new class that implement Comparator   
    -	Create a comparator object using an anonymous inner class within an existing class  






[BACK TO START PAGE](https://github.com/FlorescuAndrei/Start.git)
