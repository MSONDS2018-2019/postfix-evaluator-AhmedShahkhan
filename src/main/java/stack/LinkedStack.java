package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node head;     // top of stack

    // helper linked list class
    private class Node {
        private T elem;
        private Node next;
    }

    /**
     * Initializes an empty stack.
     */
    public LinkedStack() {
        head = null;
    }


    /**
     * {@inheritDoc}.
     */
    @Override
    public T pop() throws StackUnderflowException {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new StackUnderflowException("The stack is empty. Nothing to pop");
        }
        T top = top();

        // Pop the elem at the top of the stack
        head = head.next;

        return top;

    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public T top() throws StackUnderflowException {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new StackUnderflowException("The stack is empty. Nothing to pop");
        }
        T top = head.elem;
        return top;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        Node n = head;
        if(n != null){
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int size() {
        Node n = head;
        int listSize = 0;
        while (n != null) {
            listSize += 1;
            n = n.next;
        }
        // TODO Auto-generated method stub
        return listSize;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void push(T elem) {
        // TODO Auto-generated method stub

        Node oldfirst = head;
        head = new Node();
        head.elem = elem;
        head.next = oldfirst;

    }




    }
