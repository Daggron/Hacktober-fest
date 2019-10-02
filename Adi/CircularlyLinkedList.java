  public class CircularlyLinkedList<E>
  {
    //---------------- nested Node class ----------------
    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {

      /** The element stored at this node */
      private E element;     // an element stored at this node

      /** A reference to the subsequent node in the list */
      private Node<E> next;  // a reference to the subsequent node in the list

      /**
       * Creates a node with the given element and next node.
       *
       * @param e  the element to be stored
       * @param n  reference to a node that should follow the new node
       */
      public Node(E e, Node<E> n) {
        element = e;
        next = n;
      }

      // Accessor methods
      /**
       * Returns the element stored at the node.
       * @return the element stored at the node
       */
      public E getElement() {
        return element;
       }

      /**
       * Returns the node that follows this one (or null if no such node).
       * @return the following node
       */
      public Node<E> getNext() {
        return next;
       }

      // Modifier methods
      /**
       * Sets the node's next reference to point to Node n.
       * @param n    the node that should follow this one
       */
      public void setNext(Node<E> n) {
        next = n;
       }
    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /** The designated cursor of the list */
    private Node<E> tail = null;                  // we store tail (but not head)

    /** Number of nodes in the list */
    private int size = 0;                         // number of nodes in the list

    /** Constructs an initially empty list. */
    public CircularlyLinkedList() { }             // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() {
      return size;
     }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
      return tail == null;
     }

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
      if(tail == null)
      return null;
      return tail.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
      if(tail == null)
      return null;
      return tail.getElement();

     }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list

      if(size >= 1)
      {
        tail = tail.getNext();
      }

     }

    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
      Node<E> new_node = new Node<E>(e,null);
      if(tail == null)
      {
          tail = new_node;
      }
      else
      {
        new_node.setNext(tail.getNext());
      }
      tail.setNext(new_node);
      size++;
     }

     public void addInBetween(E e,int index)
     {
       if(index == 1)
       {
         addFirst(e);
       }
       else if(index == size)
       {
         addLast(e);
       }
       else
       {
         Node<E> curr_node = tail.getNext(),prev_node = tail;
         int i=1;
         while(i<index)
         {
           prev_node = curr_node;
           curr_node = curr_node.getNext();
           i++;
         }
         Node<E> new_node = new Node<E>(e,curr_node);
         prev_node.setNext(new_node);
         size++;
       }
     }

     public void addLast(E e) {                 // adds element e to the end of the list
       Node<E> new_node = new Node<E>(e,null);
       if(tail == null)
       {
         new_node.setNext(new_node);
       }
       else
       {
         new_node.setNext(tail.getNext());
         tail.setNext(new_node);
       }
       tail = new_node;
       size++;
      }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
      if(size == 0)
      return null;
      E e = tail.getNext().getElement();
      if(tail.getNext() == tail)
      {
        tail = null;
      }
      else
      {
          tail.setNext(tail.getNext().getNext());
      }
      size--;
      return e;
     }

     public E removeValueAt(int index)
     {
       if(index == 1)
       {
         return removeFirst();
       }
       else if(index == size)
       {
         return removeLast();
       }
       else
       {
         Node<E> curr_node = tail.getNext(),prev_node = tail;
         int i=1;
         while(i<index)
         {
           prev_node = curr_node;
           curr_node = curr_node.getNext();
           i++;
         }
         prev_node.setNext(curr_node.getNext());
         return curr_node.getElement();
       }
     }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */

     public E removeLast() {                   // removes and returns the last element
       if(size == 0)
       return null;
       E e = tail.getElement();
       if(tail.getNext() == tail)
       {
         tail = null;
       }
       else
       {
         Node<E> curr_node = tail.getNext();
         while(curr_node.getNext() != tail)
         {
           curr_node = curr_node.getNext();
         }
         curr_node.setNext(tail.getNext());
         tail = curr_node;
       }
       size--;
       return e;
      }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
      StringBuilder sb = new StringBuilder("(");
      if(tail != null)
      {
        Node<E> walk = tail;
        do
        {
          sb.append(walk.getNext().getElement());
          walk = walk.getNext();
          if(walk!=tail)
          sb.append(", ");
        }while(walk!=tail);
      }
      sb.append(")");
      return sb.toString();
     }
  }
