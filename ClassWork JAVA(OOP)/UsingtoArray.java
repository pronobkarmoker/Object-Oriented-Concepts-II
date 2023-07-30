package OOP_2;

import java.util.Arrays;
import java.util.LinkedList;

public class UsingtoArray {
	
	public UsingtoArray() {
		String colors[] = {"black ", "yellow ", "green "};
		
		LinkedList<String> link =new LinkedList<String>(Arrays.asList(colors));
		
		link.addLast(" red "); // add as last item
		link.add(" pink "); // add end
		link.add(3, " green "); //3rd index
		link.addFirst(" cyan "); // add as first item
		
		colors = link.toArray(new String[link.size()]);
		
		System.out.println("colors:");
		
		for(String color : colors)
			System.out.printf("%s", color);
		
	}
	
	

	public static void main(String[] args) {
		new UsingtoArray();

	}

}
