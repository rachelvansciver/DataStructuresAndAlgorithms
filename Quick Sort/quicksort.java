import java.util.Arrays;
public class quicksort {
    public static void main(String[] args){
        int[] array = {5,9,7,2,4,13};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high){
        if(low < high){
           int pivot = partition(array,low,high);
           partition(array,low,pivot-1);
           partition(array,pivot+1,high);
        }
    }
    public static int partition(int[] array,int left,int right) {
        int pivot = array[left];
        int low = left + 1;
        int high = right;
        while(high > low ){
            //stopping point for searching and swapping elements
            while(low <= high && array[low] < pivot) {
                //finds first element greater than pivot on left side
                low++;
            }
            while(low <= high && array[high] > pivot) {
                high--;
            }
                //finds first element less than pivot on right side
            if(high > low) {
                swap(array, low,high);
                //and swaps them
            }
        } while(array[high] >= pivot && high > left){
            //moves pointer into proper position for partitioning
            high--;
        } if(array[high] < pivot){
            //swaps if necessary for proper partitioning
            array[left] = array[high];
            array[high] = pivot;
            return high;
        }
      return 0;
    }




    public static void swap(int[] array, int low, int high){
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
}
