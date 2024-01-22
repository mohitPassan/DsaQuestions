package DataStructures.MaxHeap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    List<Integer> heap;
    int size;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.size = 0;
    }

    public void insert(Integer num) {
        heap.add(num);
        size++;

        int childIndex = size - 1;

        if (childIndex == 0) {
            return;
        }
        int parentIndex = childIndex % 2 == 0 ? (childIndex - 2) / 2 : (childIndex - 1) / 2;

        while (heap.get(childIndex) > heap.get(parentIndex)) {
            Integer temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            childIndex = parentIndex;
            if (childIndex == 0) {
                break;
            }
            parentIndex = childIndex % 2 == 0 ? (childIndex - 2) / 2 : (childIndex - 1) / 2;
        }
    }

    public Integer remove() {
        if (size == 0) {
            System.out.println("Array is empty");
            return null;
        }

        Integer temp = heap.get(0);
        heap.set(0, heap.get(size - 1));
        heap.set(size - 1, temp);

        Integer answer = heap.get(size - 1);
        heap.remove(size - 1);
        size--;

        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while (true) {
            if (leftChildIndex >= size) {
                break;
            }

            if (rightChildIndex >= size) {
                if (heap.get(parentIndex) < heap.get(leftChildIndex)) {
                    temp = heap.get(parentIndex);
                    heap.set(parentIndex, heap.get(leftChildIndex));
                    heap.set(leftChildIndex, temp);
                    parentIndex = leftChildIndex;
                    leftChildIndex = 2 * parentIndex + 1;
                    rightChildIndex = 2 * parentIndex + 2;
                }
                break;
            }

            if (heap.get(parentIndex) < heap.get(leftChildIndex) && heap.get(parentIndex) < heap.get(rightChildIndex)) {
                if (heap.get(leftChildIndex) > heap.get(rightChildIndex)) {
                    temp = heap.get(parentIndex);
                    heap.set(parentIndex, heap.get(leftChildIndex));
                    heap.set(leftChildIndex, temp);
                    parentIndex = leftChildIndex;
                } else {
                    temp = heap.get(parentIndex);
                    heap.set(parentIndex, heap.get(rightChildIndex));
                    heap.set(rightChildIndex, temp);
                    parentIndex = rightChildIndex;
                }
            } else if (heap.get(parentIndex) < heap.get(leftChildIndex)) {
                temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(leftChildIndex));
                heap.set(leftChildIndex, temp);
                parentIndex = leftChildIndex;
            } else if (heap.get(parentIndex) < heap.get(rightChildIndex)) {
                temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(rightChildIndex));
                heap.set(rightChildIndex, temp);
                parentIndex = rightChildIndex;
            }
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }

        return answer;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

}
