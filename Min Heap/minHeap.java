/**Assignment 2 (COSC-2336: Data Structures and Algorithms).
 * @author Rachel Van Sciver*/
public class minHeap {
    /** Exercise 3. The heapsort() method described in Lecture 6 (and the Sorting Chapter from [Dr. Liang’s textbook]) is also known as max-heap,
     * in which each node is greater than or equal to any of its children. A min-heap is a heap in which each node is less than or equal to any of its children.
     * Min-heaps are often used to implement priority queues. Write a Java program which implements the sorting algorithm based on a min-heap data structure.*/
    static int leftNode;
    static int rightNode;
    public static void main(String[] args) {
        int[] array = {2, 3, 0, 2, 5, 6, -1, -2, 3, 14, 12, 7};
        int size = array.length;
        heapSort(array,size);
        System.out.println(java.util.Arrays.toString(array));
    }
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void heapSort(int[] array, int size){
        for(int i = 0; i < (size - 1)/2; i++) {
            int parent = i;
            leftNode = 2 * i + 1;
            rightNode = 2 * i + 2;
            if(leftNode <= size && array[leftNode] > array[parent]){
                //if left child is smaller than parent, left node becomes the new parent.
                parent = leftNode;
            }
            if(rightNode <= size && array[rightNode] > array[parent]){
                //if right child is smaller than parent, right node becomes new parent.
                parent = rightNode;
            }
            if(parent != i){
                //if parent is not the root node, swap the current index so parent becomes root.
                swap(array, i,parent);
                //recursively heap-sort this array with size decreasing by 1.
                heapSort(array, size-1);
            }
        }
    }
}