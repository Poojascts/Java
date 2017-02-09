/**
 * 
 */
package collections_package.methods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 * @author sitaramm
 *
 */

public class TCollection {

	public static void main(String[] args) {

		
// ------------------- Linked List and ArrayList --------------------	
// Syntax wise same but performance wise different.	
		
		List list = new LinkedList<Integer>();
		
		list.add(10); // This method is from Collection Interface. No ordered maintained. 
						// Element added to last and in case of removing, 
						//it removes first occurance of elements.
		
		list.add(1,20); // This method is from List Interface
						// Thats why it is called as sequential or ordered insertion. Similary other methods.
		
		list.add(2,30);
		list.add(0,0); // The order of insertion is in our hand.
		
		
		// How to iterate ? Three ways :
		
		//1 : Simple for loop or for each loop
		for(Object obj:list){
			Object genericObject = null;
			// If we dont know what type of collection is this. Use instanceof.
			if (obj instanceof Integer) { 
				Integer iRef = (Integer) obj; // Downcasting
				int i = iRef; // Unboxing	
				Integer iBox = i; // Boxing
				genericObject = iBox; // Upcasting. 
			}
			if (obj instanceof Character) {
				char c = (Character) obj; // AutoUnboxing
				genericObject = c; // Auto Boxing. 1st Boxing to Character and then upcasting to Object.
			}
			if (obj instanceof String) {
				String sRef = (String) obj;  // Downcasting
				genericObject = sRef; // Only Upcasting.
			}
		}
		
		
		
		//2 : This method is from Iterable Interface. Can be used by all collection classes which has implemented Iterable Iterface.
		Iterator<Integer> it = list.iterator();
		System.out.println("Iterating by Iterable Interface method(Iterator):");
		while(it.hasNext()){
			Object ele = it.next(); // This method return Integer referance. But if we dont know what type of collection it is. 
									// Called Upacasting
			Integer iRef = (Integer) ele; // downcasting.
			int i = iRef; // Unboxing.
			if(i == 0)it.remove();// Remove while traversing
			System.out.println(i);
		}
		
		//3 : This method is from List Interface. Can be used by all collection classes which has implemented List Iterface.
		ListIterator<Integer> lit = list.listIterator();
		System.out.println("Iterating by Collection Interface method(Iterator):");
		System.out.println("Forward : ");
		while(lit.hasNext()){
			int ele = lit.next(); // Auto Unboxing.
			System.out.println(ele); 
			// Advantages of ListIterator over Iterator : 
			if(ele == 30) lit.set(300); //A: Replace
			
		}
		//B: Can access in reverse order
		System.out.println("Reverse : ");
		while(lit.hasPrevious()){
			System.out.println(lit.previous());
		}
		
//  ------------------------ Vector -------------------------------
	// Simple Array(Dynamically Growable)	
		Vector <Integer> vector = new Vector(); 
		vector.addAll(list);
		vector.add(null);
		// We can Iterate this using Iterator.
		// It also implements Enumerable Interface which has Enumerator method.
		
		Enumeration<Integer> enm = vector.elements();
		System.out.println("Iterating vector elements by ENumeration");
		while(enm.hasMoreElements()){
			int i = enm.nextElement();
			// Can't remove here(Disadvantage over Iterator).
			System.out.println(i); 
		}
		
// ----------------------  Stack ---------------------------------
		//LIFO + Index ordering
		
		Stack stack = new Stack();
		stack.addAll(list);
		
		stack.push(200);int topElement = (int) stack.peek();
		System.out.println("Top Element from Stack is : "+topElement);
		stack.pop();
		
//----------------------- HashSet ------------------------------
		
		Set set = new HashSet();
		set.addAll(list);
		boolean isSetAffected = set.add(300); // Adding duplicate element.Dont give error.It simply ignores it.
		System.out.println("Is set affected by adding duplicate ? :"+isSetAffected); // Return false if operationd dont affect the set.
		set.add(1);
		set.add(2);
		set.add(346);
		System.out.println("HASHSET : Doesnt follow insertion order ");
		Iterator itr = set.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
//-------------------- LinkedHashSet -----------------------------
		
		Set<Integer> linkedHashSet = new LinkedHashSet();
		linkedHashSet.add(101);
		linkedHashSet.add(2);
		linkedHashSet.add(303); // Cannot insert by index. So not indexed.
		
		System.out.println("LINKEDHASHSET : Follows insertion order. ");
		itr = linkedHashSet.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			
		}

//----------------------- TreeSet ------------------------------
		Set<Integer> treeSet = new TreeSet();
		treeSet.add(5);
		treeSet.add(2);
		treeSet.add(-10);
		treeSet.add(15);
		
		System.out.println("TreeSet : Keep element in sorting order ");
		itr = treeSet.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			
		}
		
// ------------------ HashTable --------------------------------
		Map<Integer,String> map = new Hashtable(); //Map  doesnt allow primitiev types as a key or value.
		map.put(1, "Aditya");
		map.put(1, "Sitaram"); // Since key is duplicate, value is replaced.
		map.put(2, "Mulik"); // Null not allowed either as key or value
		System.out.println("HashTable: ");
		Collection values = map.values();
		System.out.println("Values:");
		for(Object obj:values){
			String str = (String) obj;
			System.out.println(str);
		}
		System.out.println("Keys:");
		Set<Integer> keys = map.keySet();
		for(Object obj:keys){
			Integer key = (Integer) obj;
			System.out.println(key);
		}
		
		// How to access all elements ?
		System.out.println("KEYS  AND VALUES: ");
		
		Set<Map.Entry<Integer, String>> entries = map.entrySet();
		
		for(Map.Entry<Integer, String> entry : entries){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}

// --------------------- HashMap ------------------------------
		// Synchronized
		
	   map = new HashMap();
	   map.put(1,"Aditya");
	   map.put(2, "Sitaram");
	   map.put(3, "Mulik");
	   map.put(null, null); // Both can be null
	   map.put(4, null); 
	   
	   
	   
	   values = map.values();
	   System.out.println("HashMap Values : ");
	   for(Object obj:values){
		   String value = (String) obj;
		   System.out.println(value);
	   }
	   
// ------------------- TreeMap -------------------------------
	 // Inserted in ordered  
		map = new TreeMap();
		map.put(1,"Aditya");
		map.put(2, "Sitaram");
		map.put(3, "Mulik");
		map.put(3, null); // Key cant be null
		values = map.values();
		   System.out.println("TreeMap Values : ");
		   for(Object obj:values){
			   String value = (String) obj;
			   System.out.println(value);
		   }
		   
// ----------------- LinkedHashMap -------------------------
		   map = new LinkedHashMap();
			map.put(1,"Aditya");
			map.put(2, "Sitaram");
			map.put(3, "Mulik");
			map.put(null, null); // Key cant be null
			values = map.values();
			   System.out.println("TreeMap Values : ");
			   for(Object obj:values){
				   String value = (String) obj;
				   System.out.println(value);
			   } 
		   
	}

}
