package OOP_2;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
	public static final String colors[] = {"black ", "yellow ", "green ", "blue ", "voilet ", "silver "};
	public static final String colors2[] = {"gold ", "white ", "brown ", "blue ", "gray ", "silver "};
	
	public ListTest() {
		List<String> list1 = new LinkedList<String>();
		List<String> list2 = new LinkedList<String>();
		
		for(String color : colors)
			list1.add(color);
		for(String color : colors2)
			list2.add(color);
		
		list1.addAll(list2);
		list2 =null;
		printList(list1);
		
		convertToUppercasestring(list1);
		printList(list1);
		
		System.out.println("\n Deleting elements 4 to 6");
		reoveItems(list1 ,4,7);
		printList(list1);
		
		printReversedList(list1);
		
	}
	
	public void printList(List<String> list) {
		System.out.println("\nList:");
		
		for(String color :list)
			System.out.printf("%s", color);
		
		System.out.println();
	}
	
	public void convertToUppercasestring(List<String> list) {
		ListIterator<String> iterator = list.listIterator();
		
		while(iterator.hasNext()) {
			String color = iterator.next();
			iterator.set(color.toUpperCase());
		}
	}
	
	public void reoveItems(List<String> list , int start , int end) {
		list.subList(start, end).clear();
	}
	
	public void printReversedList(List<String> list) {
		ListIterator<String> iterator = list.listIterator(list.size());
		
		System.out.println("\nReversed List");
		
		while(iterator.hasPrevious())
			System.out.printf("%s", iterator.previous());
		
	}
	
	public static void main(String[] args) {
		new ListTest();
	}
}

//List:
//black yellow green blue voilet silver gold white brown blue gray silver 
//
//List:
//BLACK YELLOW GREEN BLUE VOILET SILVER GOLD WHITE BROWN BLUE GRAY SILVER 
//
// Deleting elements 4 to 6
//
//List:
//BLACK YELLOW GREEN BLUE WHITE BROWN BLUE GRAY SILVER 
//
//Reversed List
//SILVER GRAY BLUE BROWN WHITE BLUE GREEN YELLOW BLACK