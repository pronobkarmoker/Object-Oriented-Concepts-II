package OOP_2;

import java.util.NoSuchElementException;
import java.util.Vector;

public class VectorTest {
	
	private static final String colors[] = {"red", "white", "blue"};
	
	public VectorTest() {
		Vector<String> vector = new Vector<String>();
		printVector(vector);
		
		// add elements to the vector
		
		for(String color : colors)
			vector.add(color);
		
		printVector(vector);
		
		//output the first and last element
		try
		{
			System.out.printf("first element : %s\n", vector.firstElement());
			System.out.printf("last element : %s\n", vector.lastElement());
		} // end try
		// catch exception if vector is empty
		
		catch(NoSuchElementException exception)
		{
			exception.printStackTrace();
		} // end catch
		
		//does vector contain "red" ?
		
		if(vector.contains("red"))
			System.out.printf("\n\"red\" fouund at %d\n" , vector.indexOf("red"));
		else
			System.out.println("\n\"red\" not found");
		
		vector.remove("red");
		System.out.println("\n\"red\" has been removed");
		printVector(vector);
		
		if(vector.contains("red"))
			System.out.printf("\n\"red\" fouund at %d", vector.indexOf("red"));
		else
			System.out.println("\n\"red\" not fouund ");
		
		System.out.printf("\nSize : %d\nCapacity: %d\n",vector.size(),vector.capacity());
		
	}
	
	public void printVector(Vector<String>output) {
		if(output.isEmpty())
			System.out.println("Vector is empty");
		else
		{
			System.out.println("vector contains:");
			
			for(String element: output)
				System.out.printf("%s", element);
		}
		
		System.out.println("\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VectorTest();
	}

}
