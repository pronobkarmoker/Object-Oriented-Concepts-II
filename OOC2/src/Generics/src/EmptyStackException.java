package Generics.src;

// Fig. 18.9: EmptyStackException.java
// Indicates a stack is full.
public class EmptyStackException extends RuntimeException {
    // no-argument constructor
    public EmptyStackException() {
        this("Stack is empty");
    } // end no-argument EmptyStackException constructor

    // one-argument constructor
    public EmptyStackException(String exception) {
        super(exception);
    } // end one-argument EmptyStackException constructor
} // end class EmptyStackException
