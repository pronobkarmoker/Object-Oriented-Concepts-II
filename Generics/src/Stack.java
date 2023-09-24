// Fig. 18.7: Stack.java
// Generic class Stack.

public class Stack<E> {
    private final int size; // number of elements in the stack
    private int top; // location of the top element
    private E[] elements; // array that stores stack elements

    // no-argument constructor creates a stack of the default size
    public Stack() {
        this(10); // default stack size
    } // end no-argument Stack constructor

    // constructor creates a stack of the specified number of elements
    public Stack(int s) {
        size = s > 0 ? s : 10; // set the size of the Stack
        top = -1; // Stack initially empty
        elements = (E[]) new Object[size]; // create an array
    } // end Stack constructor

    // push element onto the stack; if successful, return true;
    // otherwise, throw FullStackException
    public void push(E pushValue) {
        if (top == size - 1) // if the stack is full
            throw new FullStackException(String.format("Stack is full, cannot push %s", pushValue));

        elements[++top] = pushValue; // place pushValue on the Stack
    } // end method push

    // return the top element if not empty; else throw EmptyStackException
    public E pop() {
        if (top == -1) // if the stack is empty
            throw new EmptyStackException("Stack is empty, cannot pop");

        return elements[top--]; // remove and return the top element of the Stack
    } // end method pop
} // end class Stack<E>
