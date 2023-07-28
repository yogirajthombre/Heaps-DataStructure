import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {
    public int size;
    public int current = 0;
    public int[] maxHeapSize;
    public MaxHeap(int size){
        this.size = size;
        this.maxHeapSize = new int[size];
    }
    public void resize(){
        int[] trt = new int[maxHeapSize.length+1];
        for (int x = 0;x<maxHeapSize.length;x++){
            trt[x] = maxHeapSize[x];
        }
        this.maxHeapSize = trt;
    }

    /**
     *
     * insertion takes time complexity of log(n)
     * Space complexity O(n)
     * **/
    public void insert(int ele){
        if (current == maxHeapSize.length-1){
            resize();
        }
        this.maxHeapSize[current] = ele;
        swim(current);
        this.current += 1;
    }

    /**
     *
     * deletion takes time complexity of log(n)
     * Space complexity O(1)
     * **/
    public void deleteMax(){
        int lastEle = maxHeapSize[maxHeapSize.length-2];
        this.maxHeapSize[0] = lastEle;
        this.maxHeapSize[maxHeapSize.length-2] = 0;
        /// top-down swim
        int trav = 0;
        while (trav < maxHeapSize.length-1){
            int leftChildIndex = 2*trav+1;
            int rightChildIndex = 2*trav+2;
            if (leftChildIndex < maxHeapSize.length-1 && rightChildIndex < maxHeapSize.length-1){
                int leftChild = this.maxHeapSize[leftChildIndex];
                int rightChild = this.maxHeapSize[rightChildIndex];
                int swappingChildIndex = 0;
                if (this.maxHeapSize[trav]<leftChild || this.maxHeapSize[trav]<rightChild){
                    int maxChild = Math.max(leftChild,rightChild);
                    if (maxChild == leftChild){
                        swappingChildIndex = leftChildIndex;
                    }else {
                        swappingChildIndex = rightChildIndex;
                    }
                }
                int temp = this.maxHeapSize[trav];
                this.maxHeapSize[trav] = this.maxHeapSize[swappingChildIndex];
                this.maxHeapSize[swappingChildIndex] = temp;
                trav=swappingChildIndex;
            }else {
                trav+=1;
            }
        }
    }

    private void swim(int currentIndex) {
        int lastElementParent = (int) Math.floor((currentIndex-1)/2);
        if (lastElementParent != currentIndex && this.maxHeapSize[lastElementParent]<this.maxHeapSize[currentIndex]){
            int temp = this.maxHeapSize[lastElementParent];
            this.maxHeapSize[lastElementParent] = this.maxHeapSize[currentIndex];
            this.maxHeapSize[currentIndex] = temp;
            swim(lastElementParent);
        }
    }

    /**
     * Time complexity O(nLog(k))
     * Space complexity O(kn)
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode();
        ListNode currNode = node;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                return listNode.val-t1.val;
            }
        });
        for (int x = 0;x<lists.length;x++){
            ListNode arr = lists[x];
            queue.offer(arr);
        }

        while (!queue.isEmpty()){
            ListNode currentNode = queue.poll();
            node.next = currentNode;
            node = node.next;
            if (currentNode.next != null){
                queue.offer(currentNode.next);
            }
        }

        return currNode.next;
    }

    public static ListNode mergeLists(ListNode node1,ListNode node2){
        ListNode node = new ListNode();
        ListNode currentNode = node;

        return currentNode.next;
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
        ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
