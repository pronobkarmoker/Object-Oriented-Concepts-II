package OOP_2;

import java.util.*;


public class ConcurrentModificationExceptions {
	public static void main(String []args) {
		List<Integer> val = new ArrayList<>();
		val.add(33);
		val.add(44);
		val.add(22);
		
		Iterator<Integer> iterator = val.iterator();
		
		val.remove(1); // can not use 
		while (iterator.hasNext()) {
	            int value = iterator.next();
	            System.out.println(value);
	        }
		 
	}

}

//Exception in thread "main" java.util.ConcurrentModificationException
//at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
//at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
//at OOP_2/OOP_2.ConcurrentModificationExceptions.main(ConcurrentModificationExceptions.java:17)

