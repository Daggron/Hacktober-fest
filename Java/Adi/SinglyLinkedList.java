  public class SinglyLinkedList<E>
  {
    //---------------- nested Node class ----------------
    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */

    private static class Node<E>
      {
          /** The element stored at this node */
          private E element;            // reference to the element stored at this node

          /** A reference to the subsequent node in the list */
          private Node<E> next;         // reference to the subsequent node in the list

          /**
           * Creates a node with the given element and next node.
           *
           * @param e  the element to be stored
           * @param n  reference to a node that should follow the new node
           */
          public Node(E e, Node<E> n)
          {
            element = e;
            next = n;
          }

          // Accessor methods
          /**
           * Returns the element stored at the node.
           * @return the element stored at the node
           */
          public E getElement()
          {
            return element;
          }

          /**
           * Returns the node that follows this one (or null if no such node).
           * @return the following node
           */
          public Node<E> getNext()
          {
            return next;
          }

          // Modifier methods
          /**
           * Sets the node's next reference to point to Node n.
           * @param n    the node that should follow this one
           */
          public void setNext(Node<E> n)
          {
            next = n;
          }
      } //----------- end of nested Node class -----------


    // instance variables of the SinglyLinkedList
    /** The head node of the list */

    private Node<E> head = null;               // head node of the list (or null if empty)

    /** The last node of the list */
    private Node<E> tail = null;               // last node of the list (or null if empty)


    /** Number of nodes in the list */
    private int size = 0;                      // number of nodes in the list


    /** Constructs an initially empty list. */
    public SinglyLinkedList() {   // constructs an initially empty list

      head = null;
      tail = null;
      size = 0;
     }

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size()
    {
      return size;
    }


    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty()
    {
      return size == 0 ;
     }

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first()
    {
      if(size == 0)
      return null;
      return head.getElement();
                   // returns (but does not remove) the first element
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last()
    {              // returns (but does not remove) the last element
      if(isEmpty())
      return null;
      return tail.getElement();
    }

    // update methods
    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e)
    {              // adds element e to the front of the list
      head = new Node<E>(e,head);
      if(tail == null)
      {
        tail = head;
      }
      size++;
    }

    public void addInBetween(E e,int index)
    {
      if(index>size)
      {
        addLast(e);
      }
      else if(index==1)
      {
        addFirst(e);
      }
      else
      {
        Node<E> curr_node = head,prev_node = null;
        int i=1;
        while(i<index)
        {
          prev_node = curr_node;
          curr_node = curr_node.getNext();
          i++;
        }
        Node<E> new_node = new Node<E>(e,curr_node);
        prev_node.setNext(new_node);
      }
    }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e)
    {                 // adds element e to the end of the list
      Node<E> new_node = new Node(e,null);
      if(isEmpty())
      {
        head = new_node;
      }
      else
      {
        tail.setNext(new_node);
      }
      tail = new_node;
      size++;
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst()
    {                   // removes and returns the first element
      if(isEmpty())
      return null;
      E ele = head.getElement();
      head = head.getNext();
      size--;
      if(size == 0)
      {
        tail = null;
      }
      return ele;
    }

    public E removeValueAt(int index)        // not completed
    {
      return head.getElement();
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString()
    {
      StringBuilder sb = new StringBuilder("(");
      Node<E> walk = head;
      while (walk != null) {
        sb.append(walk.getElement());
        if (walk != tail)
          sb.append(", ");
        walk = walk.getNext();
      }
      sb.append(")");
      return sb.toString();
    }

  }
