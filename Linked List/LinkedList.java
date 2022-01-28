public class LinkedList<E> {
    Node head;
    Node tail;
    int size;
    public class Node {
        E value;
        Node next;
        public Node(E value){
            this.value = value;
        }
    }
    public void insertLast(E val){
        //runs in O(n) time
        if(this.size == 0){
            this.head = new Node(val);
            this.tail = new Node(val);
            head.next = tail.next = null;
            size++;
        } else {
            Node tmp = this.head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tail = tmp.next = new Node(val);
            tail.next = null;
            size++;
        }
    }
    public void insertFirst(E val){
        //runs in O(1) time
        if(this.size == 0) {
            this.head = new Node(val);
            this.tail = new Node(val);
            this.head.next = null;
            size++;
        } else{
            Node tmp = new Node(val);
            tmp.next = this.head;
            this.head = tmp;
            size++;
        }
    }
    public boolean contains(E val){
        //runs in O(n) time
        Node tmp = this.head;
        while(tmp != null){
            if(tmp.value == val){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    public E removeFirst(){
        //runs in O(1) time
        Node h = this.head;
        this.head = h.next;
        size--;
        return h.value;
    }
    public E removeLast(){
        //Runs in O(n) time
        Node h = this.head;
        Node tmp = null;
        while(h.next != null){
            tmp = h;
            h = h.next;
        }
        tail = tmp;
        tail.next = null;
        size--;
        return h.value;
    }
    public int size(){
        return this.size;
    }
    public void print(){
        Node h = this.head;
        while(h != null){
            System.out.print( h.value + " -> ");
            h = h.next;
        }

    }
}