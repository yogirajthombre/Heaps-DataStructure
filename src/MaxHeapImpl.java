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

        MaxHeap.ListNode node = new MaxHeap.ListNode(1);
        node.next = new MaxHeap.ListNode(4);
        node.next.next = new MaxHeap.ListNode(5);

        MaxHeap.ListNode node1 = new MaxHeap.ListNode(1);
        node1.next = new MaxHeap.ListNode(3);
        node1.next.next = new MaxHeap.ListNode(4);

        MaxHeap.ListNode node2 = new MaxHeap.ListNode(2);
        node2.next = new MaxHeap.ListNode(6);

        MaxHeap.ListNode[] listNodes = new MaxHeap.ListNode[3];
        listNodes[0] = node;
        listNodes[1] = node1;
        listNodes[2] = node2;

        maxHeap.mergeKLists(listNodes);
    }
}