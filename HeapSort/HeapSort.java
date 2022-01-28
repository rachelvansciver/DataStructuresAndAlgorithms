public class HeapSort { /** Heap sort method */
public static <E extends Comparable<E>> void heapSort(E[] list) {
    // Create a Heap of integers
    Heap<E> heap = new Heap<E>();
    // Add elements to the heap
    for (int i = 0; i < list.length; i++)
        heap.add(list[i]);
    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--)
        list[i] = heap.remove();
    }
    /** A test method */
    public static void main(String[] args) {
        Integer[] list = {2, 5, -1, 8, 4, 0, -3, 7, 3, 6, -4};
        heapSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    } // the end of main() method
} // the end of HeapSort class

