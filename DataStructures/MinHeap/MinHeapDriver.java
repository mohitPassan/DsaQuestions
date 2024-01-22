package DataStructures.MinHeap;

public class MinHeapDriver {
    public static void main(String[] args) {   
        MinHeap heap = new MinHeap();
        heap.insert(8);
        System.out.println(heap);
        heap.insert(18);
        System.out.println(heap);
        heap.insert(32);
        System.out.println(heap);
        heap.insert(14);
        System.out.println(heap);
        heap.insert(10);
        System.out.println(heap);
        heap.insert(2);
        System.out.println(heap);
        heap.insert(1);
        System.out.println(heap);

        Integer a;
        a = heap.remove();
        System.out.println(heap + " : " + a);
        a = heap.remove();
        System.out.println(heap + " : " + a);
        a = heap.remove();
        System.out.println(heap + " : " + a);
        a = heap.remove();
        System.out.println(heap + " : " + a);
        a = heap.remove();
        System.out.println(heap + " : " + a);
        a = heap.remove();
        System.out.println(heap + " : " + a);
        a = heap.remove();
        System.out.println(heap + " : " + a);
        a = heap.remove();
        System.out.println(heap + " : " + a);
    }
}
