public class bubbleSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 54, 23, 2};
        bubbleSort(array);
        System.out.println(java.util.Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        //keeps track of any sorting done.
        boolean needSort = true;
        for(int i = 1; i < array.length && needSort; i++){
            //init as false
            needSort = false;
            for(int j = 0; j < array.length - i; j++){
                //array.length - i to keep inner loop from going out of bounds
                if(array[j] > array[j + 1]){
                    //if one element is bigger than the next, swap them.
                    int tmp = array[j + 1];
                    array[j+ 1] = array[j];
                    array[j] = tmp;
                    needSort = true;
                    //flag that more sorting needs to be done.
                }
            }
        }
    }
}
