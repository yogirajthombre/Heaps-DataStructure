import java.util.Arrays;

public class MaxHeapImpl {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(1);
        maxHeap.insert(5);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(3);
        maxHeap.deleteMax();

        int[] arr = maxHeap.maxHeapSize;
        System.out.println(Arrays.toString(arr));
    }
}