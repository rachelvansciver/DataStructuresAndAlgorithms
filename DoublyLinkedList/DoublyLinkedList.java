
public class DoublyLinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    static int size = 0;
    class Node<E>{
        E element;
        //data held by node container class.
        Node<E> next;
        //pointer for next element
        Node<E> previous;
        //pointer for previous element
        public Node(E element){
            this.element = element;
        }
    }
    public void add(E element){
        //adds new element to the list.
        Node<E> newNode = new Node<E>(element);
        if(head == null) {
            head = tail = newNode;
            //new node is head and tail.
            size = 1;
        } else {
            head.previous = tail;
            //previous pointer for head points to tail
            tail.next = newNode;
            //add new element to the end
            tail.previous = tail;
            //keeps previous pointer on current element
            tail = tail.next;
            //moves tail pointer
            size++;
            //increments size
            tail.next = head;
            //forward pointer for last element points to head
        }
    }
    public E removeFirst(){
        if(size == 0){
            return null;
        }
        Node<E> tmp = head;
        //holds head element
        head = head.next;
        //moves head pointer
        size--;
        return tmp.element;
    }
    public E removeLast(){
        if(size == 0){
            return null;
        }
        Node<E> tmp = tail;
        //holder for tail element
        tail = tail.previous;
        //moves pointer to previous element
        size--;
        return tmp.element;
    }
    public E remove(int index){
        if(index < 0 || size == 0 || index > size){
            //if index isn't in bounds return null
            return null;
        }
        else if(index == 0) {
            //removes head
            return removeFirst();
        }
        else if(index == size){
            //removes tail
            return removeLast();
        } else {
            Node<E> tmp = head;
            for(int i = 0; i < index-1; i++){
                tmp = tmp.next;
                //traversing through list.
            }
            Node<E> current = tmp.next;
            //element to be removed
            tmp.next = current.next;
            //moving pointers
            size--;
            return current.element;


        }
    }
    public void print(){
       for(int i = 0; i < DoublyLinkedList.size; i++){
           System.out.print("["+ head.element+ "], " );
           head = head.next;
       }
    }
    public static void main(String[] args){
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.add("rachel");
        list.add("krysti");
        list.add("meh");
        list.add("pointers r annoying");
        list.print();


    }
}
